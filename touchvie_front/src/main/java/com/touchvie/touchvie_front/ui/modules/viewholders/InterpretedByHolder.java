package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.relations.DupleRel;
import com.touchvie.backend.carddetail.relations.Relation;
import com.touchvie.backend.carddetail.relations.RelationData;
import com.touchvie.backend.carddetail.relations.SingleRel;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.modules.data.TextData;

import java.util.ArrayList;

import static com.touchvie.backend.carddetail.relations.ContentTypes.CASTING;
import static com.touchvie.backend.carddetail.relations.ContentTypes.PLAYED_BY;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class InterpretedByHolder extends SquareImageItemsHolder {

    public InterpretedByHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(final CardDetail cardData, Picasso picasso, final Context context) {

        super.configure(cardData, picasso, context);
        mTitle.setText(context.getResources().getString(R.string.interpreted_by));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_interpreted_by));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.

                     }
        });

        ArrayList<ImageRowData> rows = new ArrayList<>();
        if(cardData.getRelations()==null)
            return;
        for (Relation rel:cardData.getRelations()){
            if (PLAYED_BY.equals(rel.getContent_type())){
                for (RelationData relData:rel.getData()){
                    ImageRowData row=new ImageRowData();
                    row.setImage(((SingleRel)relData).getData().getImage().getThumb());
                    TextData title = new TextData();
                    title.setText(((SingleRel)relData).getData().getTitle());
                    title.setUrl(null);
                    ArrayList<TextData> arrayTitle=new ArrayList<>();
                    arrayTitle.add(title);
                    row.setTitle(arrayTitle);
                    TextData subTitle = new TextData();
                    subTitle.setText(((SingleRel)relData).getData().getSubtitle());
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
