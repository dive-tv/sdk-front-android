package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.ui.modules.adapters.CuriosityListAdapter;
import com.touchvie.touchvie_front.ui.modules.data.TextRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class CuriosityListHolder extends VerticalListHolder {

    protected CuriosityListAdapter adapter;
    protected ArrayList<TextRowData> rows;
    /**
     * Default constructor
     *
     * @param itemView
     */
    public CuriosityListHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager mFragmentManager, LinearLayout container) {

        rows=new ArrayList<>();
        adapter= new CuriosityListAdapter(rows);
        super.setAdapter(adapter, false, null);
    }
}
