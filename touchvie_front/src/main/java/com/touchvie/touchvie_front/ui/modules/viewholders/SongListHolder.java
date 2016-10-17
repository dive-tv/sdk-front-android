package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.touchvie_front.ui.modules.adapters.SongListAdapter;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class SongListHolder extends VerticalListHolder {

    /**
     * Default constructor
     *
     * @param itemView
     */
    public SongListHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(Card cardData, Picasso picasso, Context context) {

        SongListAdapter adapter= new SongListAdapter();
        mList.setList(adapter, true);
    }
}
