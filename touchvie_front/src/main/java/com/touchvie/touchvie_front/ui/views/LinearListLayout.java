package com.touchvie.touchvie_front.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.touchvie.touchvie_front.R;

/**
 * Created by Tagsonomy S.L. on 23/07/2015.
 */
public class LinearListLayout extends LinearLayout {

    private Adapter list;
    private OnClickListener mListener;

    /**
     * Instantiates a new Linear list layout.
     *
     * @param context the context
     */
    public LinearListLayout(Context context) {
        super(context);
    }

    /**
     * Instantiates a new Linear list layout.
     *
     * @param context  the context
     * @param attrs    the attrs
     * @param defStyle the def style
     */
    public LinearListLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    /**
     * Instantiates a new Linear list layout.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public LinearListLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Sets list.
     *
     * @param list          the list
     * @param withSeparator the with separator
     */
    public void setList(Adapter list, boolean withSeparator) {
        this.list = list;
        this.removeAllViews();

        //Popolute list
        if (this.list != null) {
            if (withSeparator) {
                for (int i = 0; i < this.list.getCount(); i++) {
                    View item = list.getView(i, null, null);
                    this.addView(item);
                    if (i < this.list.getCount() - 1) {
                        FrameLayout separator = new FrameLayout(getContext());
                        FrameLayout.LayoutParams layoutparams;

                        if (getOrientation() == LinearLayout.VERTICAL) {
                            layoutparams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) getResources().getDimension(R.dimen.stroke));
                        } else {
                            layoutparams = new FrameLayout.LayoutParams((int) getResources().getDimension(R.dimen.stroke), ViewGroup.LayoutParams.MATCH_PARENT);
                        }
                        separator.setLayoutParams(layoutparams);
                        this.addView(separator);
                    }
                }
            } else {
                for (int i = 0; i < this.list.getCount(); i++) {
                    View item = list.getView(i, null, null);
                    this.addView(item);
                }
            }
        }

    }

    /**
     * Sets listener.
     *
     * @param mListener the m listener
     */
    public void setmListener(OnClickListener mListener) {
        this.mListener = mListener;
    }
}