package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.TypeOfContainer;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.Container;
import com.touchvie.backend.carddetail.containers.Text;
import com.touchvie.touchvie_client.data.ImageSize;
import com.touchvie.touchvie_client.manager.ClientManager;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.listeners.ExpandableListener;
import com.touchvie.touchvie_front.ui.utils.Utils;

import static android.view.View.GONE;

/**
 * Created by Tagsonomy S.L. on 10/10/2016.
 */

public class BiographyHolder extends TextHolder implements ExpandableListener {

    public BiographyHolder(View view) {
        super(view);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        title.setText(context.getResources().getString(R.string.biography));
        title.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));

        if (cardData.getInfo() != null) {
            for (Container container : cardData.getInfo()) {
                if (TypeOfContainer.BIOGRAPHY.getName().equals(container.getType())) {
                    if (container.getData() != null && container.getData().length==1 ) {
                        Text containerText=(Text)container.getData()[0];
                        if (containerText.getText() != null) {
                            text.setText(containerText.getText());
                            text.setExpandable(true);
                            text.setExpandableListener(this);
                            text.setClickable(false);
                            more.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    text.changeStatus();
                                }
                            });
                        }
                        if (containerText.getSource() == null) {
                            sourceLay.setVisibility(GONE);
                        } else {
                            source.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
                            if (containerText.getSource().getName() != null) {
                                sourceLink.setText(containerText.getSource().getName());
                                sourceLink.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
                                if (containerText.getSource().getUrl() != null) {
                                    sourceLink.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            //TODO:
                                        }
                                    });
                                }
                            }
                            if (containerText.getSource().getImage() != null) {
                                picasso.load(ClientManager.getInstance().getImageUrl(containerText.getSource().getImage(), ImageSize.medium, DisplayMetrics.DENSITY_XHIGH)) //TODO transformation, insert density.
                                        .into(sourceImage);
                            }

                            if (containerText.getSource().getDisclaimer() != null) {
                                disclaimer.setText(containerText.getSource().getDisclaimer());
                                disclaimer.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_ITALIC));
                            }
                        }

                    }
                }
            }
        } else {
            text.setVisibility(GONE);
        }
    }

    @Override
    public void onActionDone(boolean expanded) {
        more.setVisibility(expanded ? GONE : View.VISIBLE);
    }
}
