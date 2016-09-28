package com.touchvie.touchvie_front.ui.adapters;

/**
 * Adapter to present a search movie list to do synchronization.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.R;

import java.util.ArrayList;


public class CarouselAdapter extends BaseAdapter implements SectionIndexer {

    private final ArrayList<CarouselCard> carouselItems;
    private Context context;
    private LayoutInflater mInflater;
    String[] sections;

    /**
     * Constructor.
     *
     * @param context
     * @param carouselItems
     */
    public CarouselAdapter(Context context, ArrayList<CarouselCard> carouselItems) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.carouselItems = carouselItems;

        sections = new String[carouselItems.get(carouselItems.size() - 1).getSceneNumber() + 1];
        for (int i = 0; i < (carouselItems.get(carouselItems.size() - 1).getSceneNumber() + 1); i++) {
            System.out.println("KKKKKKKKK sections " + i + " - " + String.valueOf(carouselItems.get(carouselItems.size() - 1).getSceneNumber() - i + 1));
            sections[i] = String.valueOf(carouselItems.get(carouselItems.size() - 1).getSceneNumber() - i + 1);
        }
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

        CarouselRowGenericViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.carousel_item_generic, null);
            holder = new CarouselRowGenericViewHolder();
            holder.row = (CardView) convertView.findViewById(R.id.carousel_item_generic_base);
            holder.photo = (ImageView) convertView.findViewById(R.id.carousel_item_generic_base_img);
            holder.title = (TextView) convertView.findViewById(R.id.carousel_item_generic_base_txt);
            convertView.setTag(holder);
        } else {
            holder = (CarouselRowGenericViewHolder) convertView.getTag();
        }

        Card card = carouselItems.get(position).getData();
        if (card.getImage() != null && card.getImage().length() > 0) {
            Picasso
                    .with(context)
                    .load(card.getImage())
                    .into(holder.photo);
            holder.photo.setVisibility(View.VISIBLE);
        } else {
            holder.photo.setVisibility(View.GONE);
        }

        //title
        if (card.getTitle() != null && card.getTitle().length() > 0) {
            holder.title.setText(card.getTitle());
        } else {
            holder.title.setText("");
        }

        return convertView;
    }

    private class CarouselRowGenericViewHolder {
        CardView row;
        ImageView photo;
        TextView title;
    }


    @Override
    public Object[] getSections() {
        return sections;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        for (int i = 0; i < carouselItems.size(); i++) {
            if (sectionIndex == carouselItems.get(i).getSceneNumber()) {
                System.out.println("KKKKK getPositionForSection: " + i);
                return i;
            }
        }
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        System.out.println("KKKKK getSectionForPosition: " + position + " - " + carouselItems.get(position).getSceneNumber());
        return carouselItems.get(position).getSceneNumber();
    }
}
