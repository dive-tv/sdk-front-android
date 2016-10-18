package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.ui.modules.adapters.CuriosityListAdapter;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class CuriosityListHolder extends VerticalListHolder {

    /**
     * Default constructor
     *
     * @param itemView
     */
    public CuriosityListHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        CuriosityListAdapter adapter = new CuriosityListAdapter();
        mList.setList(adapter, true);
    }
}
