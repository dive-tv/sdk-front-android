package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.relations.DupleRel;
import com.touchvie.backend.carddetail.relations.Relation;
import com.touchvie.backend.carddetail.relations.RelationData;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.adapters.CastAdapter;
import com.touchvie.touchvie_front.ui.modules.data.CastRowData;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.modules.data.TextData;

import java.util.ArrayList;

import static com.touchvie.backend.carddetail.relations.ContentTypes.CASTING;
import static com.touchvie.backend.carddetail.relations.ContentTypes.MOVIE_LOCATIONS;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class CastHolder extends HorizontalListHolder {

    public CastHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);
        mTitle.setText(context.getResources().getString(R.string.cast));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_cast));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.
            }
        });

        ArrayList<CastRowData> rows = new ArrayList<>();
        CastAdapter adapter = new CastAdapter(context, rows);
        for (Relation rel:cardData.getRelations()) {
            if (CASTING.equals(rel.getContent_type())) {
                for (RelationData relData : rel.getData()) {
                    CastRowData row = new CastRowData();
                    row.setImage(((DupleRel) relData).getFrom().getImage().getThumb());
                    row.setPerson(((DupleRel) relData).getFrom().getTitle());
                    TextData character = new TextData();
                    character.setText(((DupleRel) relData).getTo().getTitle());
                    character.setUrl(null);
                    row.setCharacter(character);
                    rows.add(row);

                }
                break;
            }
        }

        mList.setAdapter(adapter);

    }
}
