package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Image;
import com.touchvie.backend.TypeOfContainer;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.Container;
import com.touchvie.backend.carddetail.containers.Seasons;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.adapters.AppearsInAdapter;
import com.touchvie.touchvie_front.ui.modules.adapters.GalleryAdapter;
import com.touchvie.touchvie_front.ui.modules.adapters.SeasonsAdapter;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.modules.data.SeasonRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class SeasonsHolder extends HorizontalListHolder {

    protected SeasonsAdapter adapter;
    protected ArrayList<ImageRowData> data;

    public SeasonsHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);
        mTitle.setText(context.getResources().getString(R.string.seasons));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_seasons));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.
            }
        });

        if (cardData.getInfo() != null) {
            boolean found = false;
            for (Container container : cardData.getInfo()) {
                if (TypeOfContainer.SEASONS.getName().equals(container.getContentType()) && container.getData() !=null && container.getData().length>0) {
                    ArrayList<SeasonRowData> rows= new ArrayList<>();
                    int length=container.getData().length;
                    for(int i=0; i<length; i++){
                        Seasons season= (Seasons)container.getData()[i];
                        SeasonRowData rowData= new SeasonRowData();
                        rowData.setImage(season.getImage().getThumb());
                        rowData.setYear(season.getYear());
                        rowData.setSeason(context.getString(R.string.season_number,season.getSeasonIndex()));
                        rows.add(rowData);
                    }
                    SeasonsAdapter adapter = new SeasonsAdapter(context, rows);
                    super.setAdapter(adapter);
                    found = true;
                    break;
                }
            }
            if (!found) {
                mSeeAll.setVisibility(View.GONE);
            }
        }


    }
}
