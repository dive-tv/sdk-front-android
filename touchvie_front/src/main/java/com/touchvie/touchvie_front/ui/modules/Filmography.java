package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.viewholders.FilmographyHolder;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class Filmography extends HorizontalListModule {

    public Filmography(){
        super();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(LayoutInflater inflater, ViewGroup group) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(this.layout, group, false);
        FilmographyHolder holder= new FilmographyHolder(viewGroup);
        return holder;
    }
}
