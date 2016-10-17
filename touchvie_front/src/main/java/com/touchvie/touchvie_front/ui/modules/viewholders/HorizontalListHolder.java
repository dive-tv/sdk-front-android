package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.utils.Utils;

/**
 * Created by Tagsonomy S.L. on 05/10/2016.
 */

public abstract class HorizontalListHolder extends ModuleHolder {

    protected TextView mTitle;
    protected TextView mSeeAll;
    protected RecyclerView mList;

    public HorizontalListHolder(View itemView) {
        super(itemView);
        mTitle=(TextView)itemView.findViewById(R.id.txtv_seeall_title);
        mSeeAll=(TextView)itemView.findViewById(R.id.txtv_seeall_button);
        mList=(RecyclerView) itemView.findViewById(R.id.rv_carousel_list);
    }

    @Override
    public void configure(Card cardData, Picasso picasso, Context context) {

        mTitle.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
        mSeeAll.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));

    }

    protected void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter){
        mList.setAdapter(adapter);
    }


}
