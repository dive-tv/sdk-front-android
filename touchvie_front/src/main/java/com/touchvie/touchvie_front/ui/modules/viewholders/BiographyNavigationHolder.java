package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.utils.Utils;

import static android.view.View.GONE;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class BiographyNavigationHolder extends TextHolder {

    public BiographyNavigationHolder(View view) {
        super(view);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        title.setText(context.getResources().getString(R.string.biography));
        more.setVisibility(GONE);
        link.setVisibility(View.VISIBLE);
        link.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: navigate
            }
        });

        //TODO: get data
    }
}

