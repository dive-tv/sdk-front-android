package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.touchvie_front.ui.modules.adapters.MovieListAdapter;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class MovieListHolder extends NoPaddingListHolder {

    /**
     * Default constructor
     *
     * @param itemView
     */
    public MovieListHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(Card cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);

        MovieListAdapter adapter= new MovieListAdapter();
        mList.setList(adapter, true);
    }
}

