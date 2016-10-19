package com.touchvie.touchvie_front.ui.modules.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.touchvie.backend.carddetail.containers.Awards;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.util.List;

/**
 * Created by Tagsonomy S.L. on 11/10/2016.
 */

public class AwardsAdapter extends BaseAdapter {


    private Context context;

    private List<Awards> awards;

    private Typeface latoRegular;

    private LayoutInflater mInflater;


    /**
     * Instantiates a new awards adapter.
     *
     * @param context the context
     */
    public AwardsAdapter(Context context, List<Awards> items) {
        this.context = context;
        this.awards = items;
        this.mInflater = LayoutInflater.from(context);
        latoRegular = Utils.getFont(this.context, Utils.TypeFaces.LATO_REGULAR);
    }


    /**
     * The number of items in the list.
     *
     * @returns {int} length. The number of items in the providers list.
     */
    @Override
    public int getCount() {
        return awards.size();
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

        return awards.get(position);
    }

    /**
     * Gets the item identifier. Uses the array index as a unique id.
     *
     * @param {int} position. The item's position in the array.
     * @returns {Object} position. The item's identifier.
     */
    @Override
    public long getItemId(int position) {

        return awards.indexOf(getItem(position));
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

        //TODO: create view for awards
        return convertView;

    }

    /**
     * The type Basic info holder.
     */
    class AwardsItemHolder {

        TextView title;

        TextView subtitle;

        TextView view;
    }
}
