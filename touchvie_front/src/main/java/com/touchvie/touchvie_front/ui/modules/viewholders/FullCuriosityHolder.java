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
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class FullCuriosityHolder extends ModuleHolder {

    protected TextView mTitle;
    protected TextView mText;

    /**
     * Default constructor
     *
     * @param itemView
     */

    public FullCuriosityHolder(View itemView) {

        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.txtv_fcuriosity_title);
        mText = (TextView) itemView.findViewById(R.id.txtv_fcuriosity_text);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager mFragmentManager, LinearLayout container) {

        mTitle.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_BOLD));
        mText.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));

        //TODO: get data from carddata and insert into texts.

    }

}