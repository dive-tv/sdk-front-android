package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
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
        mBackground =(ImageView)itemView.findViewById(R.id.imgv_mheader_background);
        mTitle =(TextView)itemView.findViewById(R.id.txtv_mheader_title);
        mDirector =(TextView)itemView.findViewById(R.id.txtv_mheader_director);
        mGenres =(TextView)itemView.findViewById(R.id.txtv_mheader_genres);
        mTimeLay =(LinearLayout) itemView.findViewById(R.id.lay_mheader_time);
        mTime=(TextView)itemView.findViewById(R.id.txtv_mheader_time);
        mPoster=(ImageView) itemView.findViewById(R.id.imgv_mheader_poster);
        mButton=(TextView)itemView.findViewById(R.id.txtv_mheader_divein);

    }

    @Override
    public void configure(Card cardData, Picasso picasso, Context context) {

        if(cardData.getImage() !=null){
            picasso.load(ClientManager.getInstance().getImageUrl(cardData.getImage().getFull(), ImageSize.medium, DisplayMetrics.DENSITY_XHIGH)) //TODO transformation, insert density.
                    .into(mBackground);
        }
        if(cardData.getTitle() !=null){
            mTitle.setText(cardData.getTitle());
            mTitle.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_BOLD));
        }

        if(cardData.getSubtitle() !=null){

        }


    }
}
