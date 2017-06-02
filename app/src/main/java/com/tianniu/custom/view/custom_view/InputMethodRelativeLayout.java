package com.tianniu.custom.view.custom_view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

import com.tianniu.custom.utils.ScreenUtil;

/**
 * @author junjun
 *         自定义布局解决键盘弹出挡住输入框的问题
 */
public class InputMethodRelativeLayout extends RelativeLayout {
    private int width;
    protected OnSizeChangedListenner onSizeChangedListenner;
    private boolean sizeChanged = false; //变化的标志
    private int height;
    private int screenWidth; //屏幕宽度
    private int screenHeight; //屏幕高度
    private DisplayMetrics displayMetrics = new DisplayMetrics();

    public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        ScreenUtil screenUtil = new ScreenUtil((Activity) paramContext);
        this.screenWidth = screenUtil.getWidth();
        this.screenHeight = screenUtil.getHeight();
    }

    public InputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.width = widthMeasureSpec;
        this.height = heightMeasureSpec;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private int oOldW = 0;
    private int oOldH = 0;
    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (oOldW == 0){
            oOldW = oldw;
        }
        if (oOldH == 0){
            oOldH = oldw;
        }

        //监听不为空、宽度不变、当前高度与历史高度不为0
        if ((this.onSizeChangedListenner != null) && (w == oldw) && (oldw != 0) && (oldh != 0)) {
            if ((h >= oldh) || (Math.abs(h - oldh) <= 1 * this.screenHeight / 4)) {
                if ((h <= oldh) || (Math.abs(h - oldh) <= 1 * this.screenHeight / 4)){
                    return;
                }
                this.sizeChanged = false;
            } else {
                this.sizeChanged = true;
            }
            this.onSizeChangedListenner.onSizeChange(this.sizeChanged, oldh, h);
            measure(this.width - w + getWidth(), this.height - h + getHeight());
        }
    }

    /**
     * 设置视图偏移的监听事件
     *
     * @param paramonSizeChangedListenner
     */
    public void setOnSizeChangedListenner(InputMethodRelativeLayout.OnSizeChangedListenner paramonSizeChangedListenner) {
        this.onSizeChangedListenner = paramonSizeChangedListenner;
    }

    /**
     * 视图偏移的内部接口
     *
     * @author junjun
     */
    public abstract interface OnSizeChangedListenner {
        public abstract void onSizeChange(boolean paramBoolean, int w, int h);
    }
}
