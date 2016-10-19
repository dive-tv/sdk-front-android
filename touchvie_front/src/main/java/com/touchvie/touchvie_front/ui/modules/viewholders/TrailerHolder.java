package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;

/**
 * Created by Tagsonomy S.L. on 19/10/2016.
 */

public class TrailerHolder extends VideoHolder {
    /**
     * Default constructor
     *
     * @param itemView
     */
    public TrailerHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager fragmentManager, LinearLayout container) {

        mTitle.setText(context.getResources().getString(R.string.trailer));

    }
}
