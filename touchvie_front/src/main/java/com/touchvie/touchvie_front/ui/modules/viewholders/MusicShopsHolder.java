package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.ui.modules.adapters.AwardsAdapter;
import com.touchvie.touchvie_front.ui.modules.adapters.MusicShopsAdapter;
import com.touchvie.touchvie_front.ui.modules.data.MusicShopRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 19/10/2016.
 */

public class MusicShopsHolder  extends VerticalListHolder {

    protected MusicShopsAdapter adapter;
    protected ArrayList<MusicShopRowData> data;

    /**
     * Default constructor
     *
     * @param itemView
     */
    public MusicShopsHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        mTitle.setVisibility(View.GONE);

        data = new ArrayList<>();
        adapter = new MusicShopsAdapter(context, data);  //TODO: get all the data.
        super.setAdapter(adapter, true, null);

    }
}
