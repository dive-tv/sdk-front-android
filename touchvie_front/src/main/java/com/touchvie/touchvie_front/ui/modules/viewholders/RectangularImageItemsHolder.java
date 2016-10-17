package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.touchvie_front.ui.modules.adapters.RectangularImageItemsAdapter;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 14/10/2016.
 */

public abstract class RectangularImageItemsHolder  extends HorizontalListHolder {

    protected RectangularImageItemsAdapter adapter;
    protected ArrayList<ImageRowData> data;

    public RectangularImageItemsHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(Card cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);
        data=new ArrayList<>();
        adapter= new RectangularImageItemsAdapter(data);
        super.setAdapter(adapter);
    }

    protected void setData(ArrayList<ImageRowData> data){
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
    }

    protected void setImageTextSpace(boolean space){

        adapter.setImageTextSpace(space);
    }

}

