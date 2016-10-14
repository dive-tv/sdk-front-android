package com.touchvie.touchvie_front.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Tagsonomy S.L. on 11/10/2016.
 */

public class SquareGridViewItem extends ImageView {

    public SquareGridViewItem(Context context) {
        super(context);
    }

    public SquareGridViewItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareGridViewItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec); // This is the key that will make the height equivalent to its width
    }
}
