package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
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
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager mFragmentManager, LinearLayout container) {

        super.configure(cardData, picasso, context, mFragmentManager, container);
        MovieListAdapter adapter= new MovieListAdapter();
        mList.setList(adapter, true, null);

    }
}

