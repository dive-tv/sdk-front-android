package com.touchvie.touchvie_front.ui.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.R;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by Tagsonomy S.L. on 21/09/2016.
 * Holds a line view in the carousel. It is related to one carousel section.
 */

public class CarouselItem extends AbstractSectionableItem<CarouselItem.ViewHolder, SceneHeaderItem> {

    private int id;

    /**
     * Constructor
     * @param id the identifier of this row.
     * @param header The header this row is related to.
     */
    public CarouselItem(int id, SceneHeaderItem header) {
        super(header);
        this.id = id;
    }

    @Override
    public boolean equals(Object inObject) {
        if (inObject instanceof CarouselItem) {
            CarouselItem inItem = (CarouselItem) inObject;
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
        return R.layout.carousel_item;
    }

    @Override
    public ViewHolder createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
        return new ViewHolder(inflater.inflate(getLayoutRes(), parent, false), adapter);
    }

    @Override
    public void bindViewHolder(final FlexibleAdapter adapter, final ViewHolder holder, int position, List payloads) {

    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }

    static class ViewHolder extends FlexibleViewHolder {

        /**
         * Default constructor.
         *
         * @param view    The {@link View} being hosted in this ViewHolder
         * @param adapter Adapter instance of type {@link FlexibleAdapter}
         */
        public ViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);

        }

    }

}
