package com.tianniu.custom.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.Snackbar;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tianniu.custom.HttpCallBack;
import com.tianniu.custom.HttpManager;
import com.tianniu.custom.model.PersonInfo;
import com.tianniu.custom.api.UserApi;
import com.tianniu.custom.utils.ToastUtil;
import com.tianniu.custom.view.base.BaseActivity;
import com.tianniu.up.testprogect.R;
import com.tianniu.custom.view.custom_view.InputMethodRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * 登录页
 */
public class LoginActivity extends BaseActivity implements LoaderCallbacks<Cursor>, InputMethodRelativeLayout.OnSizeChangedListenner {


    private static final int REQUEST_READ_CONTACTS = 0;


    private static final String[] DUMMY_CREDENTIALS = new String[]{"123@163.com:123456", "bar@example.com:world"};


    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private InputMethodRelativeLayout mLoginFormView;
    private LinearLayout login_logo_layout_v;
    private LinearLayout login_logo_layout_h;
    private HttpManager httpManager;
    private UserApi userApi;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_login);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        populateAutoComplete();

        mPasswordView = (EditText) findViewById(R.id.password);
        mEmailView.setText("13641330091");
        mPasswordView.setText("111111");
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        findViewById(R.id.email_sign_in_button2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpManager.cancel(userApi);
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
//                attemptLogin();
                String callPhone = mEmailView.getText().toString();

                String password = mPasswordView.getText().toString();
                if (TextUtils.isEmpty(callPhone) || TextUtils.isEmpty(password)){
                    ToastUtil.showShortToast(mActivity,getString(R.string.error_sign_in_1));
                    return;
                }
                userApi = httpManager.get(UserApi.class);
                userApi.login(httpManager.login(callPhone,password)).enqueue(new HttpCallBack<PersonInfo>(mActivity) {
                    @Override
                    public void onSuccess(PersonInfo personInfo) {
                        if (personInfo != null){
                            mApp.setPersonInfo(personInfo);
                        }
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    }

                    @Override
                    public void onFailure(int code, String message) {
                        super.onFailure(code, message);
                    }
                });
            }
        });

        mProgressView = findViewById(R.id.login_progress);
        //取得InputMethodRelativeLayout组件
        mLoginFormView = (InputMethodRelativeLayout) this.findViewById(R.id.loginpage);
        //设置监听事件
        mLoginFormView.setOnSizeChangedListenner(this);
        //取得大LOGO布局
        login_logo_layout_v = (LinearLayout) this.findViewById(R.id.login_logo_layout_v);
        //取得小LOGO布局
        login_logo_layout_h = (LinearLayout) this.findViewById(R.id.login_logo_layout_h);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        httpManager = HttpManager.getInstance();
    }

    @Override
    public void processClick(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();



    }

    private void populateAutoComplete() {
        if (!mayRequestContacts()) {
            return;
        }

        getLoaderManager().initLoader(0, null, this);
    }

    private boolean mayRequestContacts() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
            Snackbar.make(mEmailView, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE).setAction(android.R.string.ok, new View.OnClickListener() {
                @Override
                @TargetApi(Build.VERSION_CODES.M)
                public void onClick(View v) {
                    requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);

                }
            });
        } else {
            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
        }
        return false;
    }




    /**
     * 登录
     */
    private void attemptLogin() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            showProgress(true);
            httpManager = HttpManager.getInstance();
            httpManager.test();
        }
    }


    private boolean isPasswordValid(String password) {
        return password.length() > 6;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                 // Retrieve data rows for the device user's 'profile' contact.
                 Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                 // Select only email addresses.
                 ContactsContract.Contacts.Data.MIMETYPE + " = ?", new String[]{ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE},

                 // Show primary email addresses first. Note that there won't be
                 // a primary email address if the user hasn't specified one.
                 ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(emails);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(LoginActivity.this, android.R.layout.simple_dropdown_item_1line, emailAddressCollection);
        mEmailView.setAdapter(adapter);
    }

    @Override
    public void onSizeChange(boolean flag, int w, int h) {
        if (flag) {//键盘弹出时
            final int i = -10;
            mLoginFormView.setPadding(0, (int)getResources().getDimension(R.dimen.alphabet_size), 0, 0);
            login_logo_layout_v.setVisibility(View.GONE);
            login_logo_layout_h.setVisibility(View.VISIBLE);
        } else { //键盘隐藏时
            mLoginFormView.setPadding(0, 0, 0, 0);
            login_logo_layout_v.setVisibility(View.VISIBLE);
            login_logo_layout_h.setVisibility(View.GONE);
        }
    }


    private interface ProfileQuery {

        String[] PROJECTION = {ContactsContract.CommonDataKinds.Email.ADDRESS, ContactsContract.CommonDataKinds.Email.IS_PRIMARY,};

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }
}

