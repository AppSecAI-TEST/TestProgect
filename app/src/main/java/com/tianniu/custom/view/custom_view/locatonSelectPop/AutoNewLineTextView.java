package com.tianniu.custom.view.custom_view.locatonSelectPop;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.tianniu.up.testprogect.R;


/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class AutoNewLineTextView extends android.support.v7.widget.AppCompatTextView {

    private float textSize;
    private float currentsize;
    private float newLinemin;


    public AutoNewLineTextView(Context context) {
        this(context, null);
    }

    public AutoNewLineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        textSize = getTextSize();
    }

    private void refitText(int lowerTextSize) {
        if (getText().length() <5){
            setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        }
        if (getLineCount() > 1) {
            if (getTextSize() == textSize) {
                currentsize = getTextSize() - getResources().getDimensionPixelSize(lowerTextSize);
                setTextSize(TypedValue.COMPLEX_UNIT_PX, currentsize);
            }
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stick_action_search_text_size);
//        setTextSize(TypedValue.COMPLEX_UNIT_PX, dimensionPixelSize);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        if(getLineCount()>1){
//
//            currentsize = dimensionPixelSize - getResources().getDimensionPixelSize(R.dimen.dimen2);
//            setTextSize(TypedValue.COMPLEX_UNIT_PX, currentsize);
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        refitText(1);
    }

    @Override
    public void setTextSize(float textSize) {
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
    }
}
