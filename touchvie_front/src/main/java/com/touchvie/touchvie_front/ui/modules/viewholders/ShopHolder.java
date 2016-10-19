package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.adapters.ShopAdapter;
import com.touchvie.touchvie_front.ui.modules.data.ShopRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class ShopHolder extends HorizontalListHolder {

    public ShopHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager mFragmentManager, LinearLayout container) {

        super.configure(cardData, picasso, context, mFragmentManager, container);
        mTitle.setText(context.getResources().getString(R.string.shop));

        mSeeAll.setText(context.getResources().getString(R.string.shop_this));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.
            }
        });

        ArrayList<ShopRowData> data = new ArrayList<>(); //TODO: get the needed data from card data.
        ShopAdapter adapter = new ShopAdapter(data);
        mList.setAdapter(adapter);

    }
}
