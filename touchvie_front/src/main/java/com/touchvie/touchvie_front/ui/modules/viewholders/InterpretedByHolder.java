package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class InterpretedByHolder extends SquareImageItemsHolder {

    public InterpretedByHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);
        mTitle.setText(context.getResources().getString(R.string.interpreted_by));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_interpreted_by));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.
            }
        });

        ArrayList<ImageRowData> rows = new ArrayList<>(); //TODO: get all the data.

        super.setData(rows);
    }
}
