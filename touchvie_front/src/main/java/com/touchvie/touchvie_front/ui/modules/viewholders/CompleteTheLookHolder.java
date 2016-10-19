package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 19/10/2016.
 */

public class CompleteTheLookHolder extends SquareImageItemsHolder {

    public CompleteTheLookHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(final CardDetail cardData, Picasso picasso, final Context context, FragmentManager fragmentManager, LinearLayout container) {

        super.configure(cardData, picasso, context, fragmentManager, container);
        mTitle.setText(context.getResources().getString(R.string.complete_the_look));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_complete_the_look));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.

            }
        });

        ArrayList<ImageRowData> rows = new ArrayList<>();
        super.setData(rows);
    }
}
