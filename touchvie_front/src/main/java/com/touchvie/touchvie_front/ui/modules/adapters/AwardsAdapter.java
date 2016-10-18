package com.touchvie.touchvie_front.ui.modules.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.touchvie.backend.Award;
import com.touchvie.backend.AwardsGroup;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.util.List;

/**
 * Created by Tagsonomy S.L. on 11/10/2016.
 */

public class AwardsAdapter extends BaseAdapter {


    private Context context;

    private List<AwardsGroup> awardsGroups;

    private Typeface latoRegular;

    private LayoutInflater mInflater;

    private int awardsCount=0;

    private int awardsGroupCount=0;

    /**
     * Instantiates a new awards adapter.
     *
     * @param context the context
     */
    public AwardsAdapter(Context context, List<AwardsGroup> items) {
        this.context = context;
        this.awardsGroups = items;
        this.mInflater = LayoutInflater.from(context);
        latoRegular = Utils.getFont(this.context, Utils.TypeFaces.LATO_REGULAR);
        setAwardsCount();
    }

    private void setAwardsCount(){

        for(AwardsGroup group: awardsGroups){

            awardsGroupCount++;

            if(group.getNominee() !=null){
                for(Award award: group.getNominee()){
                    awardsCount++;
                }
            }
            if(group.getWinner() !=null){
                for(Award award: group.getWinner()){
                    awardsCount++;
                }
            }
        }
    }

    /**
     * The number of items in the list. It is determined by the number of speeches in our array.
     *
     * @returns {int} length. The number of items in the providers list.
     */
    @Override
    public int getCount() {
        return awardsCount;
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

        return awardsGroups.get(position);
    }

    /**
     * Gets the item identifier. Uses the array index as a unique id.
     *
     * @param {int} position. The item's position in the array.
     * @returns {Object} position. The item's identifier.
     */
    @Override
    public long getItemId(int position) {

        return awardsGroups.indexOf(getItem(position));
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

      /*  BasicInfoHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.cards_list_to_two_columns_info_row, null);
            holder = new BasicInfoHolder();
            holder.title = (TextView) convertView.findViewById(R.id.cards_list_to_two_columns_info_row_title);
            holder.value = (TextView) convertView.findViewById(R.id.cards_list_to_two_columns_info_row_number);
            holder.icon = (TextView) convertView.findViewById(R.id.cards_list_to_two_columns_info_row_icon);
            convertView.setTag(holder);
        } else {
            holder = (BasicInfoHolder) convertView.getTag();
        }

        final ContainerAwards row_pos = rowItem.get(position);
        holder.title.setText(row_pos.getText());
        holder.title.setTypeface(sourceSansProSemiBold);
        holder.value.setText(" (" + Integer.toString((row_pos.getWinner().length + row_pos.getNominee().length)) + ")");
        holder.value.setTypeface(sourceSansProRegular);

        holder.icon.setText(">");
        holder.icon.setTypeface(touchvieFont);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aws.setNavigationEvent(aws.lastTo, Utils.AWSEvents.awards_card.toString(), null);
                mListener.onCallSingleAwardCard(row_pos);
            }
        });

        */
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
