package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_client.data.ImageSize;
import com.touchvie.touchvie_client.manager.ClientManager;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.utils.Utils;


/**
 * Created by Tagsonomy S.L. on 05/10/2016.
 */

public class HeaderHolder extends ModuleHolder {

    protected TextView title;
    protected TextView subtitle;
    protected ImageView image;

    /**
     * Default constructor
     */
    public HeaderHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.txtv_header_title);
        subtitle = (TextView) view.findViewById(R.id.txtv_header_subtitle);
        image = (ImageView) view.findViewById(R.id.imgv_header_image);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        if (cardData.getTitle() != null) {
            title.setText(cardData.getTitle());
            title.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_BOLD));
        } else {
            title.setVisibility(View.GONE);
        }
        if (cardData.getSubtitle() != null) {
            subtitle.setText(cardData.getSubtitle());
            title.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
        } else {
            subtitle.setVisibility(View.GONE);
        }

        if (cardData.getImage() != null && cardData.getImage().getFull() != null) {
            picasso.load(ClientManager.getInstance().getImageUrl(cardData.getImage().getFull(), ImageSize.medium, DisplayMetrics.DENSITY_XHIGH)) //TODO transformation, insert density.
                    .into(image);
        } else {
            image.setVisibility(View.GONE);
        }
    }
}
