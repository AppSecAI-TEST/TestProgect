package com.tianniu.custom.view;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.tianniu.custom.view.base.BaseActivity;
import com.tianniu.custom.view.base.BaseFragment;
import com.tianniu.custom.view.custom_view.locatonSelectPop.SearchGoodSelector;
import com.tianniu.custom.view.custom_view.locatonSelectPop.area_page_about.SelectorInfo;
import com.tianniu.up.testprogect.R;

public class MainActivity extends BaseActivity implements BaseFragment.OnFragmentInteractionListener {


    private MostlyFragment mostlyFragment;
    private PushFragment pushFragment;
    private UserFragment userFragment;
    private   Fragment  currentFragment ;
    private FragmentTransaction fragmentTransaction;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        if (mostlyFragment == null){
            mostlyFragment = MostlyFragment.newInstance("", "");
            currentFragment = mostlyFragment;
        }
        if (pushFragment == null){
            pushFragment = PushFragment.newInstance("", "");
        }
        if (userFragment == null){
            userFragment = UserFragment.newInstance("", "");
        }




        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, mostlyFragment).commitNow();


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findview(R.id.bottom_menu_group);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.hide(currentFragment);
                switch (item.getItemId()){
                    case R.id.main_content:
                        currentFragment = mostlyFragment;
                        break;
                    case R.id.main_oter:
                        currentFragment = pushFragment;
                        break;
                    case R.id.main_me:
                        currentFragment = userFragment;
                        break;
                }

                if (!currentFragment.isAdded()){
                    fragmentTransaction.add(R.id.main_container,currentFragment);
                }
                fragmentTransaction.show(currentFragment).commitNowAllowingStateLoss();
                return true;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView tvStartPostion = (TextView) rootView.findViewById(R.id.tv_cargo_explan);
            tvStartPostion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    //测试地址选择器
                    Toast.makeText(v.getContext(),"test click",Toast.LENGTH_SHORT).show();
//                    new LocationSelectorPop(v.getContext(), v, new OnLocationSelectorListener() {
//                        @Override
//                        public void onSelectCancelListener(SelectedLocation selectedLocation) {
//
//                        }
//                    }).showLocationPop();

                    SelectorInfo selectedInfo = new SelectorInfo();
                    selectedInfo.setContext(v.getContext());
                    selectedInfo.setPositionView(v);

                    SearchGoodSelector searchGoodSelector = new SearchGoodSelector(selectedInfo,null);
                    searchGoodSelector.openSelector();

                }
            });
            return rootView;
        }
    }


}
