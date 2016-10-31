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

import static com.touchvie.backend.carddetail.relations.ContentTypes.CASTING;
import static com.touchvie.backend.carddetail.relations.ContentTypes.FILMOGRAPHY;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class FilmographyHolder extends RectangularImageItemsHolder {

    public FilmographyHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);
        mTitle.setText(context.getResources().getString(R.string.filmography));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_filmography));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.
            }
        });

        ArrayList<ImageRowData> rows = new ArrayList<>(); //TODO: get all the data.

        if(cardData.getRelations()==null)
            return;
        for (Relation rel:cardData.getRelations()){ //TODO: falta sacar el director.
            if (FILMOGRAPHY.equals(rel.getContent_type())){
                for (RelationData relData:rel.getData()){
                    ImageRowData row=null;
                    row.setImage(((DupleRel)relData).getTo().getImage().getThumb());
                    TextData title = new TextData();
                    title.setText(context.getResources().getString(R.string.interpretes));
                    title.setUrl(null);
                    ArrayList<TextData> arrayTitle=new ArrayList<>();
                    arrayTitle.add(title);
                    row.setTitle(arrayTitle);
                    TextData subTitle = new TextData();
                    subTitle.setText(((DupleRel)relData).getTo().getTitle());
                    subTitle.setUrl(null);
                    ArrayList<TextData> arraySubTitle=new ArrayList<>();
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
