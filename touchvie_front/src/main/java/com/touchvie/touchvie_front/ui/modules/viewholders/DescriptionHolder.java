package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.backend.TextData;
import com.touchvie.backend.TypeOfContainer;
import com.touchvie.backend.carddetail.Container;
import com.touchvie.backend.carddetail.containers.Text;
import com.touchvie.touchvie_client.data.ImageSize;
import com.touchvie.touchvie_client.manager.ClientManager;
import com.touchvie.touchvie_front.ui.listeners.ExpandableListener;
import com.touchvie.touchvie_front.ui.utils.Utils;

import static android.view.View.GONE;

/**
 * Created by Tagsonomy S.L. on 10/10/2016.
 */

public class DescriptionHolder extends TextHolder implements ExpandableListener {

    public DescriptionHolder(View view) {
        super(view);
    }

    public void configure(Card cardData, Picasso picasso, Context context) {

        title.setVisibility(GONE);
        link.setVisibility(GONE);

        if (cardData.getContainers() != null) {
            for (Container container : cardData.getContainers()) {
                if (TypeOfContainer.DESCRIPTION.getName().equals(container.getType())) {
                    if (container.getData() != null) {
                        if (((Text) container.getData()).getText() != null) {
                            text.setText(((Text) container.getData()).getText());
                            text.setExpandable(true);
                            text.setExpandableListener(this);
                            text.setClickable(false);
                            text.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
                            more.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    text.changeStatus();
                                }
                            });
                        }
                        if (((Text) container.getData()).getSource() == null) {
                            sourceLay.setVisibility(GONE);
                        } else {
                            source.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
                            if (((Text) container.getData()).getSource().getName() != null) {
                                sourceLink.setText(((Text) container.getData()).getSource().getName());
                                sourceLink.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
                                if (((Text) container.getData()).getSource().getUrl() != null) {
                                    sourceLink.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            //TODO:
                                        }
                                    });
                                }
                            }
                            if (((Text) container.getData()).getSource().getImage() != null) {
                                picasso.load(ClientManager.getInstance().getImageUrl(((Text) container.getData()).getSource().getImage(), ImageSize.medium, DisplayMetrics.DENSITY_XHIGH)) //TODO transformation, insert density.
                                        .into(sourceImage);
                            }

                            if (((Text) container.getData()).getSource().getDisclaimer() != null) {
                                disclaimer.setText(((Text) container.getData()).getSource().getDisclaimer());
                                disclaimer.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_ITALIC));
                            }
                        }

                    }
                }
            }
        } else {
            text.setVisibility(GONE);
            more.setVisibility(GONE);
            sourceLay.setVisibility(GONE);
        }

    }

    @Override
    public void onActionDone(boolean expanded) {
        more.setVisibility(expanded ? GONE : View.VISIBLE);
    }
}
