package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.activities.VideoActivity;
import com.touchvie.touchvie_front.ui.utils.Utils;

/**
 * Created by Tagsonomy S.L. on 19/10/2016.
 */

public class VideoHolder extends ModuleHolder {


    protected TextView mTitle;
    protected ImageView mThumbnail;

    private final String API_KEY ="";


    /**
     * Default constructor
     *
     * @param itemView
     */
    public VideoHolder(View itemView) {
        super(itemView);
        mTitle=(TextView)itemView.findViewById(R.id.title);
        mThumbnail=(ImageView) itemView.findViewById(R.id.imgv_video_thumbnail);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        mTitle.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
        mTitle.setText(context.getResources().getString(R.string.video));

        mThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: depending on the data, create one video layout or another one.
            }
        });

        //TODO: load image into thumbnail.



    }

    protected void launchYoutubeVideoPlayer(Context context, String videoId){

        Intent i = new Intent(context, VideoActivity.class);
        Bundle extras = new Bundle();
        extras.putString(Utils.TRAILER_ID, videoId);
        i.putExtras(extras);
        context.startActivity(i);
    }

}
