package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.modules.data.TwoTextRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 05/10/2016.
 */

public class BasicInfoHolder extends TwoColsModuleHolder {

    /**
     * Default constructor
     *
     * @param itemView
     */
    public BasicInfoHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager fragmentManager, LinearLayout container) {

        super.configure(cardData, picasso, context, fragmentManager, container);
        mTitle.setText(context.getResources().getString(R.string.basic_info));


        ArrayList<TwoTextRowData> rows = new ArrayList<>(); //TODO: get all the data.

        super.setData(rows);
    }
}
