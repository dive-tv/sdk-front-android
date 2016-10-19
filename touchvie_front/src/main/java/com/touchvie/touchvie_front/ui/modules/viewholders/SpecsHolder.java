package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.Specifications;
import com.touchvie.touchvie_front.ui.modules.data.TwoTextRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 05/10/2016.
 */

public class SpecsHolder extends TwoColsModuleHolder {


    /**
     * Default constructor
     *
     * @param itemView
     */
    public SpecsHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager mFragmentManager, LinearLayout container) {

        super.configure(cardData, picasso, context);
        mTitle.setText(context.getResources().getString(R.string.specifications));


        ArrayList<TwoTextRowData> rows = new ArrayList<>(); //TODO: get all the data.

        super.setData(rows);
    }
}
