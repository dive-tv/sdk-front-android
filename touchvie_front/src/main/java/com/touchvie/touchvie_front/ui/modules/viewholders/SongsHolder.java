package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.ui.modules.adapters.SongsAdapter;
import com.touchvie.touchvie_front.ui.modules.data.TwoTextRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class SongsHolder extends VerticalListHolder {

    protected SongsAdapter adapter;
    protected ArrayList<TwoTextRowData> rows;

    /**
     * Default constructor
     *
     * @param itemView
     */
    public SongsHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        mTitle.setVisibility(View.GONE);
        rows=new ArrayList<>();
        adapter= new SongsAdapter(rows);
        super.setAdapter(adapter, false, null);

    }
}
