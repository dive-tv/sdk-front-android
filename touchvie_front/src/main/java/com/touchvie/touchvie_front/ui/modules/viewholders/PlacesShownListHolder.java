package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;

import java.util.ArrayList;
import com.touchvie.backend.carddetail.CardDetail;


/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class PlacesShownListHolder extends NoPaddingListHolder {

    /**
     * Default constructor
     *
     * @param itemView
     */
    public PlacesShownListHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);

        ArrayList<ImageRowData> rows= new ArrayList<>(); //TODO: get all the data.
        super.setData(rows, true, null);

    }
}
