package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.touchvie_client.data.ImageSize;
import com.touchvie.touchvie_client.manager.ClientManager;
import com.touchvie.touchvie_front.R;

/**
 * Created by Tagsonomy S.L. on 05/10/2016.
 */

public class MovieHeaderHolder extends ModuleHolder {

    protected ImageView background;
    /**
     * Default constructor
     *
     * @param itemView
     */
    public MovieHeaderHolder(View itemView) {
        super(itemView);
        background=(ImageView)itemView.findViewById(R.id.imgv_mheader_background);
    }

    @Override
    public void configure(Card cardData, Picasso picasso, Context context) {

        if(cardData.getImage() !=null){
            picasso.load(ClientManager.getInstance().getImageUrl(cardData.getImage().getFull(), ImageSize.medium, DisplayMetrics.DENSITY_XHIGH)) //TODO transformation, insert density.
                    .into(background);
        }

    }
}
