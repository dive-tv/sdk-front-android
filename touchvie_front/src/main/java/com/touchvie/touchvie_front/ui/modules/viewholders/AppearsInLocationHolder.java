package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.relations.DupleRel;
import com.touchvie.backend.carddetail.relations.Relation;
import com.touchvie.backend.carddetail.relations.RelationData;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.modules.data.TextData;

import java.util.ArrayList;

import static com.touchvie.backend.TypeOfRel.AS;
import static com.touchvie.backend.TypeOfRel.FEATURED;
import static com.touchvie.backend.TypeOfRel.FILMED_IN;
import static com.touchvie.backend.carddetail.relations.ContentTypes.MOVIE_LOCATIONS;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class AppearsInLocationHolder extends RectangularImageItemsHolder {

    public AppearsInLocationHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);
        mTitle.setText(context.getResources().getString(R.string.appears_in_location));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_appearsin_location));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.
            }
        });

        ArrayList<ImageRowData> rows = new ArrayList<>();
        for (Relation rel:cardData.getRelations()){
            if (MOVIE_LOCATIONS.equals(rel.getContent_type())){
                for (RelationData relData:rel.getData()){
                    ImageRowData row=new ImageRowData();
                    switch (((DupleRel)relData).getRelType()) {
                        case FILMED_IN:
                            row.setImage(((DupleRel) relData).getTo().getImage().getThumb());
                            TextData title = new TextData();
                            title.setText(context.getResources().getString(R.string.filmed_in));
                            title.setUrl(null);
                            ArrayList<TextData> arrayTitle = new ArrayList<>();
                            arrayTitle.add(title);
                            row.setTitle(arrayTitle);
                            TextData subTitle = new TextData();
                            subTitle.setText(((DupleRel) relData).getTo().getTitle());
                            subTitle.setUrl(null);
                            ArrayList<TextData> arraySubTitle = new ArrayList<>();
                            arrayTitle.add(subTitle);
                            row.setTitle(arraySubTitle);
                            rows.add(row);
                            break;
                        case AS:
                            row.setImage(((DupleRel) relData).getTo().getImage().getThumb());
                            TextData titleAs = new TextData();
                            titleAs.setText(context.getResources().getString(R.string.as));
                            titleAs.setUrl(null);
                            ArrayList<TextData> arrayTitleAs = new ArrayList<>();
                            arrayTitleAs.add(titleAs);
                            row.setTitle(arrayTitleAs);
                            TextData subTitleAs = new TextData();
                            subTitleAs.setText(((DupleRel) relData).getTo().getTitle());
                            subTitleAs.setUrl(null);
                            ArrayList<TextData> arraySubTitleAs = new ArrayList<>();
                            arrayTitleAs.add(subTitleAs);
                            row.setTitle(arraySubTitleAs);
                            rows.add(row);
                            break;
                        case FEATURED:
                            row.setImage(((DupleRel) relData).getFrom().getImage().getThumb());
                            TextData titleFeatured = new TextData();
                            titleFeatured.setText(context.getResources().getString(R.string.featured));
                            titleFeatured.setUrl(null);
                            ArrayList<TextData> arrayTitleFeatured = new ArrayList<>();
                            arrayTitleFeatured.add(titleFeatured);
                            row.setTitle(arrayTitleFeatured);
                            TextData subTitleFeatured = new TextData();
                            subTitleFeatured.setText(((DupleRel) relData).getFrom().getTitle());
                            subTitleFeatured.setUrl(null);
                            ArrayList<TextData> arraySubTitleFeatured = new ArrayList<>();
                            arrayTitleFeatured.add(subTitleFeatured);
                            row.setTitle(arraySubTitleFeatured);
                            rows.add(row);
                            break;
                    }
                }
                break;
            }
        }
        super.setData(rows);
    }

}