package com.tianniu.custom.view.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.util.TypedValue;

/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class AutoZonmTextView extends android.support.v7.widget.AppCompatTextView {

    private final float textSize;


    public AutoZonmTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        textSize = getTextSize();
    }




    private void refitText(String text, int textHight) {
        if (getLineCount() > 1){
            if (getTextSize()  == textSize){
                setTextSize(TypedValue.COMPLEX_UNIT_PX,getTextSize() -2);
            }

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        refitText(getText().toString(),this.getHeight());
    }
}
