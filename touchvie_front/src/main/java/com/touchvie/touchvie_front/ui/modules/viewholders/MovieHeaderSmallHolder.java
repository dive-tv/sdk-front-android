package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.TypeOfContainer;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.Container;
import com.touchvie.backend.carddetail.containers.Catalog;
import com.touchvie.touchvie_client.data.ImageSize;
import com.touchvie.touchvie_client.manager.ClientManager;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.utils.Utils;

/**
 * Created by Tagsonomy S.L. on 05/10/2016.
 */

public class MovieHeaderSmallHolder extends ModuleHolder {

    protected ImageView mPoster;
    protected TextView mTitle;
    protected TextView mYear;
    protected TextView mDirector;
    protected TextView mGenres;

    /**
     * Default constructor
     *
     * @param itemView
     */
    public MovieHeaderSmallHolder(View itemView) {
        super(itemView);
        mPoster = (ImageView) itemView.findViewById(R.id.imgv_mheaders_poster);
        mTitle = (TextView) itemView.findViewById(R.id.txtv_title);
        mYear = (TextView) itemView.findViewById(R.id.txtv_year);
        mDirector = (TextView) itemView.findViewById(R.id.txtv_director);
        mGenres = (TextView) itemView.findViewById(R.id.tvtv_genres);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        if (cardData.getImage() != null && cardData.getImage().getThumb() != null) {
            picasso.load(ClientManager.getInstance().getImageUrl(cardData.getImage().getThumb(), ImageSize.medium, DisplayMetrics.DENSITY_XHIGH)) //TODO transformation, insert density.
                    .into(mPoster);
        } else {
            mPoster.setVisibility(View.GONE);
        }

        if (cardData.getTitle() != null) {
            mTitle.setText(cardData.getTitle());
            mTitle.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD));
        }

        if (cardData.getInfo() != null) {
            for (Container container : cardData.getInfo()) {
                if (TypeOfContainer.CATALOG.getName().equals(container.getType())) {
                    if (container.getData() != null  && container.getData().length>=1 ) {
                        Catalog containerCatalog=(Catalog)container.getData()[0];
                        if(containerCatalog==null)
                            return;
                        if (containerCatalog.getDirector() != null) {
                            mDirector.setText(containerCatalog.getDirector());
                            mDirector.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD));
                        }

                        if (containerCatalog.getGenres() != null) {
                            StringBuilder sb = new StringBuilder();
                            boolean first = true;
                            for (String genre : containerCatalog.getGenres()) {
                                if (!first) {
                                    sb.append(",");
                                }
                                sb.append(genre);
                            }
                            mGenres.setText(sb.toString());
                            mGenres.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
                        }
                        if (containerCatalog.getYear() > 0) {
                            mYear.setText(containerCatalog.getYear());
                            mYear.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_LIGHT));
                        }
                    }
                }
            }
        }
    }
}
