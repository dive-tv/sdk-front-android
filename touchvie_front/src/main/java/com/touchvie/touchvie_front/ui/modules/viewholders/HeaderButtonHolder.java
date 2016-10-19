package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.utils.Utils;

/**
 * Created by Tagsonomy S.L. on 05/10/2016.
 */

public class HeaderButtonHolder extends HeaderHolder {


    protected TextView mButton;

    /**
     * Default constructor
     *
     * @param view
     */
    public HeaderButtonHolder(View view) {
        super(view);
        mButton = (TextView) view.findViewById(R.id.txtv_bheader_button);

    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager mFragmentManager, LinearLayout container) {

        super.configure(cardData, picasso, context, mFragmentManager, container);

        mButton.setVisibility(View.VISIBLE);
        mButton.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD));
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
