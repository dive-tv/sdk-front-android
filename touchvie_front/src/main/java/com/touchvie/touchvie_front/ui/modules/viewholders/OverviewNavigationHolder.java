package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.backend.carddetail.Container;
import com.touchvie.backend.TextData;
import com.touchvie.backend.TypeOfContainer;
import com.touchvie.touchvie_client.data.ImageSize;
import com.touchvie.touchvie_client.manager.ClientManager;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.utils.Utils;

import static android.view.View.GONE;

/**
 * Created by Tagsonomy S.L. on 10/10/2016.
 */

public class OverviewNavigationHolder extends TextHolder {

    public OverviewNavigationHolder(View view) {
        super(view);
    }

    @Override
    public void configure(Card cardData, Picasso picasso, Context context) {

        title.setText(context.getResources().getString(R.string.synopsis));
        more.setVisibility(GONE);
        link.setVisibility(View.VISIBLE);
        link.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: navigate
            }
        });

        if(cardData.getContainers() !=null){
            for(Container container : cardData.getContainers()) {
                if (TypeOfContainer.OVERVIEW.getName().equals(container.getType())) {
                    if(container.getData()!=null) {
                        if (((TextData) container.getData()).getText() != null) {
                            text.setText(((TextData) container.getData()).getText());
                            text.setExpandable(false);
                            text.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
                        }
                        if (((TextData) container.getData()).getSource() == null) {
                            sourceLay.setVisibility(GONE);
                        }else{
                            source.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
                            if(((TextData) container.getData()).getSource().getName() !=null){
                                sourceLink.setText(((TextData) container.getData()).getSource().getName());
                                sourceLink.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
                                if(((TextData) container.getData()).getSource().getUrl() !=null){
                                    sourceLink.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            //TODO:
                                        }
                                    });
                                }
                            }
                            if(((TextData) container.getData()).getSource().getImage() !=null){
                                picasso.load(ClientManager.getInstance().getImageUrl(((TextData) container.getData()).getSource().getImage(), ImageSize.medium, DisplayMetrics.DENSITY_XHIGH)) //TODO transformation, insert density.
                                        .into(sourceImage);
                            }

                            if(((TextData) container.getData()).getSource().getDisclaimer() !=null){
                                disclaimer.setText(((TextData) container.getData()).getSource().getDisclaimer());
                                disclaimer.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_ITALIC));
                            }
                        }

                    }
                }
            }
        }else{
            text.setVisibility(GONE);
            sourceLay.setVisibility(GONE);
        }

    }
}
