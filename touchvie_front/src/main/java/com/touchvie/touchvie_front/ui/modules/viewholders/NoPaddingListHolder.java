package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.touchvie_front.ui.modules.adapters.NoPaddingListAdapter;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;

import java.util.ArrayList;
import com.touchvie.backend.carddetail.CardDetail;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public abstract class NoPaddingListHolder extends VerticalListHolder {

    protected NoPaddingListAdapter adapter;
    protected ArrayList<ImageRowData> data;

    /**
     * Default constructor
     *
     * @param itemView
     */
    public NoPaddingListHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        mContainer.setPadding(0, mContainer.getPaddingTop(), 0, mContainer.getPaddingBottom());

        data=new ArrayList<>();
        adapter= new NoPaddingListAdapter(data);
        super.setAdapter(adapter, false, null);
    }

    protected void setData(ArrayList<ImageRowData> data, boolean withSeparator, View customView){
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
        super.notifyDataSetChanged(withSeparator, customView);
    }
}
