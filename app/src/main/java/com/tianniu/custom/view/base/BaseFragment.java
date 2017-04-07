package com.tianniu.custom.view.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/3/31 0031.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    private boolean isVisible = false;
    private boolean isInitView = false;
    private boolean isFirstLoad = false;

    private View convertView;
    private SparseArrayCompat<View> mViews = new SparseArrayCompat<>();
    public abstract int getLayoutId();
    public abstract void initView();
    public abstract void initListener();
    public abstract void initData();
    public abstract void processClick(View view);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            isVisible = true;
            lazyload();
        }else {
            isVisible = false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        convertView = inflater.inflate(getLayoutId(),container,false);
        initView();
        isInitView = true;
        lazyload();
        return convertView;
    }

    private void lazyload() {
        if (isFirstLoad || isVisible || isInitView){
            initListener();
            initData();
            isFirstLoad = false;
        }
    }

    public <E extends View >E findView(int viewid){
        if (convertView != null){
            E view = (E)mViews.get(viewid);
            if (view == null){
                view =(E)convertView.findViewById(viewid);
                mViews.put(viewid,view);
            }
            return view;
        }
        return null;
    }

    public <E extends View>void  setOnclick(E view){
        view.setOnClickListener(this);
    }

}
