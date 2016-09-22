package com.touchvie.touchvie_front.ui.views;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.touchvie.touchvie_front.R;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.flexibleadapter.utils.DrawableUtils;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by Tagsonomy S.L. on 21/09/2016.
 */

public class CarouselItem extends AbstractSectionableItem<CarouselItem.ViewHolder, SceneHeaderItem> {

    public static final String HASH = "#";
    public static final String SPACE = " ";
    public static final String EMPTY = "";

    private int id;
    private List<CarouselItem> mergedItems;

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



    public boolean hasMergedItems() {
        return mergedItems != null;
    }

    public String getMergedItemsAsText() {
        if (mergedItems == null) return EMPTY;
        StringBuilder mergedText = new StringBuilder();
        for (CarouselItem mergedItem : mergedItems) {
            mergedText.append(SPACE).append(HASH).append(mergedItem.getId());
        }
        return mergedText.toString();
    }

    public List<CarouselItem> getMergedItems() {
        return mergedItems;
    }

    public void setMergedItems(List<CarouselItem> mergedItems) {
        this.mergedItems = mergedItems;
    }

    public void mergeItem(CarouselItem staggeredItem) {
        if (mergedItems == null) {
            mergedItems = new ArrayList<CarouselItem>(1);
        }
        mergedItems.add(staggeredItem);
    }

    public void splitItem(CarouselItem staggeredItem) {
        if (mergedItems != null) {
            mergedItems.remove(staggeredItem);
            if (mergedItems.isEmpty()) mergedItems = null;
        }
    }

    public List<CarouselItem> splitAllItems() {
        List<CarouselItem> newItems = new ArrayList<>();
        if (mergedItems != null) {
            newItems = new ArrayList<>(mergedItems);
            mergedItems = null;
        }
        return newItems;
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
       /* Context context = holder.itemTextView.getContext();

        //Item Id
        holder.itemTextView.setText(toString());



        //Blink after moving the item
        for (Object payload : payloads) {
            if (payload.equals("blink")) {
                holder.itemView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        holder.itemView.setPressed(true);
                    }
                }, 100L);
                holder.itemView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        holder.itemView.setPressed(false);
                    }
                }, 800L);
            }
        } */

    }

    @Override
    public String toString() {
        return HASH + id;
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
