package com.touchvie.touchvie_front.ui.modules.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Image;
import com.touchvie.touchvie_client.data.ImageSize;
import com.touchvie.touchvie_client.manager.ClientManager;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.FullScreenFragment;
import com.touchvie.touchvie_front.ui.activities.FullScreenActivity;
import com.touchvie.touchvie_front.ui.utils.Utils;
import com.touchvie.touchvie_front.ui.views.SquareGridViewItem;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 10/10/2016.
 */

public class GalleryAdapter extends BaseAdapter {

    Context context;

    ArrayList<Image> rowItems;

    LayoutInflater mInflater;

    Picasso mPicasso;

    int px;

    /**
     * Instantiates a new Cards gallery grid adapter.
     *
     * @param context the context
     */
    public GalleryAdapter(Context context, ArrayList<Image> rowItems) {
        super();
        this.context = context;
        this.rowItems = rowItems;
        this.mPicasso = Picasso.with(context);
        this.mInflater = LayoutInflater.from(context);
    }

    /**
     * The number of items in the list. It is determined by the number of speeches in our array.
     *
     * @returns {int} length. The number of items in the providers list.
     */
    @Override
    public int getCount() {
        return rowItems.size();
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
        return rowItems.get(position);
    }

    /**
     * Gets the item identifier. Uses the array index as a unique id.
     *
     * @param {int} position. The item's position in the array.
     * @returns {Object} position. The item's identifier.
     */
    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
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

        GalleryItemHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.square_grid_row, null);
            holder = new GalleryItemHolder();
            holder.image = (SquareGridViewItem) convertView.findViewById(R.id.item_image);
            convertView.setTag(holder);
        } else {
            holder = (GalleryItemHolder) convertView.getTag();
        }

        Image image = rowItems.get(position);

        if (image.getFull() != null && image.getFull().length() > 0) {
            mPicasso
                    .load(ClientManager.getInstance().getImageUrl(image.getThumb(), ImageSize.medium, DisplayMetrics.DENSITY_XHIGH))
                    .into(holder.image);
        }

        holder.image.setOnClickListener(new OnImageClickListener(position));

        return convertView;
    }

    private class GalleryItemHolder {
        SquareGridViewItem image;
    }

    /**
     * The type On image click listener.
     */
    class OnImageClickListener implements View.OnClickListener {

        /**
         * The position of the image to be shown first.
         */
        int position;

        /**
         * Instantiates a new On image click listener.
         *
         * @param position the position
         */
        public OnImageClickListener(int position) {

            this.position = position;

        }

        @Override
        public void onClick(View v) {

            Intent i = new Intent(context, FullScreenActivity.class);
            i.putExtra(Utils.FULLSCREEN_FRAGMENT, FullScreenFragment.SWIPE_GALLERY);
            i.putExtra(Utils.POSITION, this.position);
            i.putExtra(Utils.IMAGES, rowItems);
            context.startActivity(i);
        }

    }
}