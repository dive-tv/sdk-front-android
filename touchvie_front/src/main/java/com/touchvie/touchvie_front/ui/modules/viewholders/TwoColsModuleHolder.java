package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.ui.modules.adapters.TwoColsModuleAdapter;
import com.touchvie.touchvie_front.ui.modules.data.TwoTextRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 19/10/2016.
 */

public abstract class TwoColsModuleHolder extends VerticalListHolder {

    protected TwoColsModuleAdapter adapter;
    protected ArrayList<TwoTextRowData> data;

    /**
     * Default constructor
     *
     * @param itemView
     */
    public TwoColsModuleHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        data = new ArrayList<>();
        adapter = new TwoColsModuleAdapter(data);
        super.setAdapter(adapter, true, null);
    }

    protected void setData(ArrayList<TwoTextRowData> data) {
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
    }

}
