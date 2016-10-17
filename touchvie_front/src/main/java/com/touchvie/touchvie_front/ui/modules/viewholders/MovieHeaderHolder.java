package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.backend.CatalogData;
import com.touchvie.backend.carddetail.Container;
import com.touchvie.backend.TypeOfContainer;
import com.touchvie.touchvie_client.data.ImageSize;
import com.touchvie.touchvie_client.manager.ClientManager;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.utils.Utils;

/**
 * Created by Tagsonomy S.L. on 05/10/2016.
 */

public class MovieHeaderHolder extends ModuleHolder {

    protected ImageView mBackground;
    protected TextView mTitle;
    protected TextView mYear;
    protected TextView mDirector;
    protected TextView mGenres;
    protected LinearLayout mTimeLay;
    protected TextView mTime;
    protected ImageView mPoster;
    protected TextView mButton;


    /**
     * Default constructor
     *
     * @param itemView
     */
    public MovieHeaderHolder(View itemView) {
        super(itemView);
     /*   mBackground =(ImageView)itemView.findViewById(R.id.imgv_mheader_background);
        mTitle =(TextView)itemView.findViewById(R.id.txtv_mheader_title);
        mYear=(TextView)itemView.findViewById(R.id.txtv_mheader_year);
        mDirector =(TextView)itemView.findViewById(R.id.txtv_mheader_director);
        mGenres =(TextView)itemView.findViewById(R.id.txtv_mheader_genres);
        mTimeLay =(LinearLayout) itemView.findViewById(R.id.lay_mheader_time);
        mTime=(TextView)itemView.findViewById(R.id.txtv_mheader_time);
        mPoster=(ImageView) itemView.findViewById(R.id.imgv_mheader_poster);
        mButton=(TextView)itemView.findViewById(R.id.txtv_mheader_divein);*/

    }

    @Override
    public void configure(Card cardData, Picasso picasso, Context context) {

        if(cardData.getImage() !=null){
            picasso.load(ClientManager.getInstance().getImageUrl(cardData.getImage().getFull(), ImageSize.medium, DisplayMetrics.DENSITY_XHIGH)) //TODO transformation, insert density.
                    .into(mPoster);

        }else{
           mPoster.setVisibility(View.GONE);
        }
        if(cardData.getTitle() !=null){
            mTitle.setText(cardData.getTitle());
            mTitle.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_BOLD));
        }

       /* if(cardData.getContainers()!=null){

            for(Container container : cardData.getContainers()){
                if(TypeOfContainer.CATALOG.getName().equals(container.getType())){
                    if(container.getData()!=null){
                        if(((CatalogData)container.getData()).getDirector() !=null){
                            mDirector.setText(((CatalogData)container.getData()).getDirector());
                            mDirector.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD));
                        }

                        if(((CatalogData)container.getData()).getRuntime() !=null){
                            mTimeLay.setVisibility(View.VISIBLE);
                           mTime.setText(Utils.getTime(((CatalogData)container.getData()).getRuntime(), context));
                            mTime.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
                        }else{
                            mTimeLay.setVisibility(View.GONE);
                        }

                        if(((CatalogData)container.getData()).getSync() !=null && ((CatalogData)container.getData()).getSync().isInteractive()==true){
                            mButton.setVisibility(View.VISIBLE);
                        }else{
                            mButton.setVisibility(View.GONE);
                        }

                        if(((CatalogData)container.getData()).getBackgroundImage() !=null){
                            picasso.load(ClientManager.getInstance().getImageUrl(((CatalogData)container.getData()).getBackgroundImage(), ImageSize.medium, DisplayMetrics.DENSITY_XHIGH)) //TODO transformation, insert density.
                                    .into(mBackground);
                        }

                        if(((CatalogData)container.getData()).getGenres() !=null){
                            StringBuilder sb = new StringBuilder();
                            boolean first=true;
                            for(String genre: ((CatalogData)container.getData()).getGenres()){
                                if(!first){
                                    sb.append(",");
                                }
                                sb.append(genre);
                            }
                            mGenres.setText(sb.toString());
                            mGenres.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
                        }

                        if(((CatalogData)container.getData()).getYear() !=null){
                            mYear.setText(((CatalogData)container.getData()).getYear());
                            mYear.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_LIGHT));
                        }

                    }
                }else{
                    mTimeLay.setVisibility(View.GONE);
                    mButton.setVisibility(View.GONE);
                }
            }
        }*/

    }
}
