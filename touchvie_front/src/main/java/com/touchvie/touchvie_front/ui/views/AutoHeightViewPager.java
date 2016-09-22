package com.touchvie.touchvie_front.ui.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tagsonomy S.L. on 26/01/2016.
 */
public class AutoHeightViewPager extends ViewPager {
    private int mCurrentPagePosition = 0;

    /**
     * Instantiates a new Auto height view pager.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public AutoHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Instantiates a new Auto height view pager.
     *
     * @param context the context
     */
    public AutoHeightViewPager(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        try {
            System.out.println("KKKKKKK onMeasure " + mCurrentPagePosition);
            View child = getChildAt(mCurrentPagePosition);
            if (child != null) {
                child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                int h = child.getMeasuredHeight();
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(h, MeasureSpec.EXACTLY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void reMeasureCurrentPage(int position) {
        System.out.println("KKKKKK reMeasureCurrentPage " + position);
        mCurrentPagePosition = position;
        requestLayout();
    }
}
