package com.tianniu.custom.view.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;

/**
 * Created by Administrator on 2017/3/31 0031.
 */

public abstract class BaseActivity extends Activity implements View.OnClickListener{

    private SparseArrayCompat<View> mViews = new SparseArrayCompat<>();
    public abstract int getLayoutId();
    public abstract void initView();
    public abstract void initListener();
    public abstract void initData();
    public abstract void processClick(View view);

    @Override
    public void onClick(View v) {
        processClick(v);
    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    public <E extends View>E findview(int viewId){
        E view = (E)mViews.get(viewId);
        if (view == null){
            view = (E)findViewById(viewId);
            mViews.put(viewId,view);
        }
        return view;
    }

    public <E extends View>void setOnclick(E view){
        view.setOnClickListener(this);
    }

}
