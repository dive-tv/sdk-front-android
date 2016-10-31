package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.relations.Relation;
import com.touchvie.backend.carddetail.relations.RelationData;
import com.touchvie.backend.carddetail.relations.SingleRel;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.adapters.SoundtrackAdapter;
import com.touchvie.touchvie_front.ui.modules.data.TwoTextRowData;

import java.util.ArrayList;

import static com.touchvie.backend.carddetail.relations.ContentTypes.MOVIE_SONGS;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class SoundtrackHolder extends HorizontalListHolder {

    public SoundtrackHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);
        mTitle.setText(context.getResources().getString(R.string.soundtrack));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_soundtrack));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.
            }
        });

        ArrayList<TwoTextRowData> rows= new ArrayList<>();

        for (Relation rel:cardData.getRelations()){
            if (MOVIE_SONGS.equals(rel.getContent_type())) {
                for (RelationData relData : rel.getData()) {
                    TwoTextRowData row = new TwoTextRowData();
                    if(((SingleRel)relData).getData() !=null){
                        row.setText(((SingleRel)relData).getData().getTitle());
                        row.setSubtitle(((SingleRel)relData).getData().getSubtitle());
                    }
                    rows.add(row);
                }
                break;
            }
        }

        SoundtrackAdapter adapter= new SoundtrackAdapter(context,rows);
        mList.setAdapter(adapter);

    }
}