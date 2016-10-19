package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.ui.modules.adapters.SongListAdapter;
import com.touchvie.touchvie_front.ui.modules.data.TwoTextRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class SongListHolder extends VerticalListHolder {

    protected SongListAdapter adapter;
    protected ArrayList<TwoTextRowData> rows;

    /**
     * Default constructor
     *
     * @param itemView
     */
    public SongListHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager mFragmentManager, LinearLayout container) {

        rows=new ArrayList<>();
        adapter= new SongListAdapter(rows);
        super.setAdapter(adapter, false, null);

    }
}
