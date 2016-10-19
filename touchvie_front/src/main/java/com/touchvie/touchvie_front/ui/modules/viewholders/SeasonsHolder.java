package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.adapters.SeasonsAdapter;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class SeasonsHolder extends RectangularImageItemsHolder {

    protected SeasonsAdapter adapter;
    protected ArrayList<ImageRowData> data;

    public SeasonsHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager mFragmentManager, LinearLayout container) {

        super.configure(cardData, picasso, context, mFragmentManager, container);
        mTitle.setText(context.getResources().getString(R.string.seasons));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_seasons));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.
            }
        });

        ArrayList<ImageRowData> rows= new ArrayList<>(); //TODO: get all the data.
        adapter= new SeasonsAdapter(data);
        super.setAdapter(adapter);
    }
}
