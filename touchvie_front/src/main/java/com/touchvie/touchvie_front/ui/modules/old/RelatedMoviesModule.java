package com.touchvie.touchvie_front.ui.modules.old;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.listeners.CardDetailListener;
import com.touchvie.touchvie_front.ui.views.LinearListLayout;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class RelatedMoviesModule extends RecyclerView.ViewHolder {

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

    public void configure(Context context, RelatedMoviesModule relatedMoviesVH, CardDetail cardData, CardDetailListener mListener) {
       /* if (cardData != null && cardData.getRelated_movies() != null) {
            RelatedMovies relatedMovies = cardData.getRelated_movies();
            //Title
            if (relatedMovies.getText() != null && relatedMovies.getText().length() > 0) {
                relatedMoviesVH.getText().setText(relatedMovies.getText());
            } else {
                relatedMoviesVH.getText().setText("");
            }
            //Related Movies
            if (relatedMovies.getMovies() != null && relatedMovies.getMovies().length > 0) {
                RelatedMoviesAdapter relatedMoviesAdapter = new RelatedMoviesAdapter(context, relatedMovies.getMovies(), mListener);
                relatedMoviesVH.getList().setList(relatedMoviesAdapter, true);
            }
        } */
    }
}
