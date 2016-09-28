package com.touchvie.touchvie_front.ui.views;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.backend.Card;
import com.touchvie.touchvie_front.R;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by Tagsonomy S.L. on 21/09/2016.
 * Holds a line view in the carousel. It is related to one carousel section.
 */

public class CarouselItemGeneric extends AbstractSectionableItem<CarouselItemGeneric.ViewHolder, SceneHeaderItem> {


    private int id;
    private Card cardData;

    private int currentPosition = 0;

    /**
     * Constructor
     *
     * @param id       the identifier of this row.
     * @param header   The header this row is related to.
     * @param cardData the data of this card
     */
    public CarouselItemGeneric(int id, SceneHeaderItem header, Card cardData) {
        super(header);
        this.id = id;
        this.cardData = cardData;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }


    @Override
    public boolean equals(Object inObject) {
        if (inObject instanceof CarouselItemGeneric) {
            CarouselItemGeneric inItem = (CarouselItemGeneric) inObject;
            return this.id == inItem.id;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public int getLayoutRes() {
        return R.layout.carousel_item_generic;
    }

    @Override
    public ViewHolder createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
        return new ViewHolder(inflater.inflate(getLayoutRes(), parent, false), adapter);
    }

    @Override
    public void bindViewHolder(final FlexibleAdapter adapter, final ViewHolder holder, int position, List payloads) {
        Context context = holder.itemView.getContext();
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if (position != RecyclerView.NO_POSITION) {
            currentPosition = holder.getAdapterPosition();

//            holder.mCarouselCardBase.addView(this.cardData.getView());
        }
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }

    static class ViewHolder extends FlexibleViewHolder {
        public CardView mCarouselCardBase;

        /**
         * Default constructor.
         *
         * @param view    The {@link View} being hosted in this ViewHolder
         * @param adapter Adapter instance of type {@link FlexibleAdapter}
         */
        public ViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            this.mCarouselCardBase = (CardView) view.findViewById(R.id.carousel_item_generic_base);
        }
    }

}
