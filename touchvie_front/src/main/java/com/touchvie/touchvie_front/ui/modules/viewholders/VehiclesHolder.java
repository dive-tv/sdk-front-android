package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.relations.Relation;
import com.touchvie.backend.carddetail.relations.RelationData;
import com.touchvie.backend.carddetail.relations.SingleRel;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.modules.data.TextData;

import java.util.ArrayList;

import static com.touchvie.backend.carddetail.relations.ContentTypes.MOVIE_VEHICLES;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class VehiclesHolder extends SquareImageItemsHolder {

    public VehiclesHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager fragmentManager, LinearLayout container) {

        super.configure(cardData, picasso, context, fragmentManager, container);
        mTitle.setText(context.getResources().getString(R.string.vehicles_shown));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_vehicles));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.
            }
        });

        ArrayList<ImageRowData> rows = new ArrayList<>();
        ImageRowData row=null;
        for (Relation rel:cardData.getRelations()) {
            if (MOVIE_VEHICLES.equals(rel.getContent_type())) {
                for (RelationData relData : rel.getData()) {
                    row.setImage(((SingleRel) relData).getData().getImage().getFull());
                    TextData title = new TextData();
                    title.setText(((SingleRel) relData).getData().getTitle());
                    title.setUrl(null);
                    ArrayList<TextData> arrayTitle = new ArrayList<>();
                    arrayTitle.add(title);
                    row.setTitle(arrayTitle);
                    TextData subTitle = new TextData();
                    subTitle.setText(((SingleRel) relData).getData().getSubtitle());
                    subTitle.setUrl(null);
                    ArrayList<TextData> arraySubTitle = new ArrayList<>();
                    arrayTitle.add(subTitle);
                    row.setTitle(arraySubTitle);
                    rows.add(row);
                }
                break;
            }
        }

        super.setData(rows);

    }
}
