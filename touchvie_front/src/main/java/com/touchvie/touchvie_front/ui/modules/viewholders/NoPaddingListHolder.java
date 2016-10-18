package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public abstract class NoPaddingListHolder extends VerticalListHolder {

    /**
     * Default constructor
     *
     * @param itemView
     */
    public NoPaddingListHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        mContainer.setPadding(0, mContainer.getPaddingTop(), 0, mContainer.getPaddingBottom());

    }
}
