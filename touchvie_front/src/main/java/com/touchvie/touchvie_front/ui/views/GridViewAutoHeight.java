package com.touchvie.touchvie_front.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Tagsonomy S.L. on 11/10/2016.
 */

public class GridViewAutoHeight extends GridView {

    public GridViewAutoHeight(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViewAutoHeight(Context context) {
        super(context);
    }

    public GridViewAutoHeight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
