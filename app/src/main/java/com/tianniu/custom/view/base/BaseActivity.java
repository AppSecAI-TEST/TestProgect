package com.tianniu.custom.view.base;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.tianniu.custom.OpApplication;
import com.tianniu.custom.core.CommonDefine;
import com.tianniu.custom.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/3/31 0031.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private SparseArrayCompat<View> mViews = new SparseArrayCompat<>();

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initListener();

    public abstract void initData();

    public abstract void processClick(View view);

    public OpApplication mApp;

    public BaseActivity mActivity;

    @Override
    public void onClick(View v) {
        processClick(v);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mApp = (OpApplication) getApplication();
        if (TextUtils.isEmpty(CommonDefine.CLIENT_ID)) {
            CommonDefine.CLIENT_ID = getMyUUID();
        }
        setContentView(getLayoutId());
    }

    public <E extends View> E findview(int viewId) {
        E view = (E) mViews.get(viewId);
        if (view == null) {
            view = (E) findViewById(viewId);
            mViews.put(viewId, view);
        }
        return view;
    }

    public <E extends View> void setOnclick(E view) {
        view.setOnClickListener(this);
    }


    public String getMyUUID() {
        final TelephonyManager tm = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
        String tmSerial, tmPhone, androidId;
        String tmDevice = null;


        requestPermission(new String[]{Manifest.permission.READ_PHONE_STATE}, new BaseActivity.OnPermissionCallback() {
            @Override
            public void onGranted() {
                ToastUtil.showShortToast(BaseActivity.this, "权限申请成功");
            }

            @Override
            public void onDenied(List<String> deniedPermissions) {
                ToastUtil.showShortToast(BaseActivity.this, "权限申请失败");
            }
        });

//        tmDevice = "" + tm.getDeviceId();
//        tmSerial = "" + tm.getSimSerialNumber();
        tmDevice = "test";
        tmSerial = "test";
        androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String uniqueId = deviceUuid.toString();
        Log.d("debug", "uuid=" + uniqueId);
        return uniqueId;
    }


    private OnPermissionCallback callback;

    public void requestPermission(String[] permissions, OnPermissionCallback onPermissionCallback) {
        if (this == null) {
            return;
        }


        callback = onPermissionCallback;
        List<String> permissionsList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(permission);
            }
        }
//        if(!permissionsList.isEmpty()){
//            ActivityCompat.requestPermissions(this,permissionsList.toArray(new String[permissionsList.size()]),1);
//        }else {
//            if(callback!=null){
//                callback.onGranted();
//            }
//        }


        // Should we show an explanation?
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {

            // Show an expanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
            ToastUtil.showShortToast(this,"成功");

        } else {

            // No explanation needed, we can request the permission.
            ActivityCompat.requestPermissions(this, permissions, 1);
            ToastUtil.showShortToast(this,"失败");
            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
            // app-defined int constant. The callback method gets the
            // result of the request.g
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0) {
            List<String> deniedPermissions = new ArrayList<>();
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    deniedPermissions.add(permissions[i]);
                }
            }
            if (deniedPermissions.isEmpty()) {
                if (callback != null) {
                    callback.onGranted();
                }
            } else {
                if (callback != null) {
                    callback.onDenied(deniedPermissions);
                }
            }
        }
    }

    public interface OnPermissionCallback {
        void onGranted();

        void onDenied(List<String> deniedPermissions);
    }


}
