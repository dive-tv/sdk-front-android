package com.touchvie.touchvie_front.ui.adapters;

/**
 * Adapter to present a search movie list to do synchronization.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Movies;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.listeners.CardDetailListener;
import com.touchvie.touchvie_front.ui.utils.CropSquareTransformation;

import java.util.ArrayList;


public class CarouselAdapter extends BaseAdapter implements SectionIndexer {

    private final ArrayList<CarouselCard> carouselItems;
    private Context context;
    private LayoutInflater mInflater;

    /**
     * Constructor.
     * @param context
     * @param carouselItems
     */
    public CarouselAdapter(Context context, ArrayList<CarouselCard> carouselItems) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.carouselItems = carouselItems;

    }

    /**
     * The number of items in the list. It is determined by the number of speeches in our array.
     *
     * @returns {int} length. The number of items in the providers list.
     */
    @Override
    public int getCount() {
        return carouselItems.size();
    }

    /**
     * Since the data comes from an array, just returning the index is sufficient
     * to get at the data. If we were using a more complex data structure, we
     * would return whatever object represents one row in the list.
     *
     * @param {int} position. The object's position in the array.
     * @returns {Object} position. The object's position in the array
     */
    @Override
    public Object getItem(int position) {
        return carouselItems.get(position);
    }

    /**
     * Since the data comes from an array, just returning the index is sufficient
     * to get at the data. If we were using a more complex data structure, we
     * would return whatever object represents one row in the list.
     *
     * @param {int} position. The object's position in the array.
     * @returns {Object} position. The object's position in the array
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Makes a view to hold each row.
     *
     * @param {int}       position. The item's position in the array.
     * @param {View}      convertView. The provider's list view.
     * @param {ViewGroup} parent. The view group that holds the provider's view.
     * @returns {View} convertView. The view to hold each row.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = new CarouselRowGenericAdapter().getView(context, convertView, carouselItems.get(position));

        return convertView;
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }
}
