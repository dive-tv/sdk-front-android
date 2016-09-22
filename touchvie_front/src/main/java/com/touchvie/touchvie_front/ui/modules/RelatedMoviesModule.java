package com.touchvie.touchvie_front.ui.modules;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.touchvie.backend.CardData;
import com.touchvie.backend.RelatedMovies;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.adapters.RelatedMoviesAdapter;
import com.touchvie.touchvie_front.ui.listeners.CardDetailListener;
import com.touchvie.touchvie_front.ui.views.LinearListLayout;
import com.touchvie.touchvie_front.ui.views.Module;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class RelatedMoviesModule extends Module {

    private TextView mTitle;
    private LinearListLayout mList;

    /**
     * Default constructor
     */
    public RelatedMoviesModule(View v) {
        super(v);
        mTitle = (TextView) v.findViewById(R.id.module_related_movies_title);
        mList = (LinearListLayout) v.findViewById(R.id.module_related_movies_list);
    }

    public TextView getTitle() {
        return mTitle;
    }

    public void setTitle(TextView mTitle) {
        this.mTitle = mTitle;
    }

    public LinearListLayout getList() {
        return mList;
    }

    public void setList(LinearListLayout mList) {
        this.mList = mList;
    }

    public void configure(Context context, RelatedMoviesModule relatedMoviesVH, CardData cardData, CardDetailListener mListener) {
        if (cardData != null && cardData.getRelated_movies() != null) {
            RelatedMovies relatedMovies = cardData.getRelated_movies();
            //Title
            if (relatedMovies.getTitle() != null && relatedMovies.getTitle().length() > 0) {
                relatedMoviesVH.getTitle().setText(relatedMovies.getTitle());
            } else {
                relatedMoviesVH.getTitle().setText("");
            }
            //Related Movies
            if (relatedMovies.getMovies() != null && relatedMovies.getMovies().length > 0) {
                RelatedMoviesAdapter relatedMoviesAdapter = new RelatedMoviesAdapter(context, relatedMovies.getMovies(), mListener);
                relatedMoviesVH.getList().setList(relatedMoviesAdapter, true);
            }
        }
    }
}
