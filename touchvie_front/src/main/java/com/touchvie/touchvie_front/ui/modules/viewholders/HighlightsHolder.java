package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.relations.Relation;
import com.touchvie.backend.carddetail.relations.RelationData;
import com.touchvie.backend.carddetail.relations.SingleRel;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.modules.data.TextData;

import java.util.ArrayList;

import static com.touchvie.backend.carddetail.relations.ContentTypes.MOVIE_HIGHLIGHTED;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class HighlightsHolder extends SquareImageItemsHolder {

    public HighlightsHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);
        mTitle.setText(context.getResources().getString(R.string.highlights));

        mSeeAll.setVisibility(View.GONE);

        ArrayList<ImageRowData> rows = new ArrayList<>();
        for (Relation rel:cardData.getRelations()) {
            if (MOVIE_HIGHLIGHTED.equals(rel.getContent_type())) {
                for (RelationData relData : rel.getData()) {
                    ImageRowData row=null;
                    row.setImage(((SingleRel) relData).getData().getImage().getThumb());
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
