package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.relations.Relation;
import com.touchvie.backend.carddetail.relations.RelationData;
import com.touchvie.backend.carddetail.relations.SingleRel;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.adapters.AppearsInAdapter;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.modules.data.ImageTextsRowData;

import java.util.ArrayList;

import static com.touchvie.backend.carddetail.relations.ContentTypes.ART_APEARS_IN;
import static com.touchvie.backend.carddetail.relations.ContentTypes.BUSINESS_APEARS_IN;
import static com.touchvie.backend.carddetail.relations.ContentTypes.CASTING;
import static com.touchvie.backend.carddetail.relations.ContentTypes.FASHION_APEARS_IN;
import static com.touchvie.backend.carddetail.relations.ContentTypes.FAUNA_FLORA_APEARS_IN;
import static com.touchvie.backend.carddetail.relations.ContentTypes.HEALTH_BEAUTY_APEARS_IN;
import static com.touchvie.backend.carddetail.relations.ContentTypes.HISTORIC_APEARS_IN;
import static com.touchvie.backend.carddetail.relations.ContentTypes.HOME_APEARS_IN;
import static com.touchvie.backend.carddetail.relations.ContentTypes.LEISURE_SPORT_APEARS_IN;
import static com.touchvie.backend.carddetail.relations.ContentTypes.TECHNOLOGY_APEARS_IN;
import static com.touchvie.backend.carddetail.relations.ContentTypes.TRIVIA_APEARS_IN;
import static com.touchvie.backend.carddetail.relations.ContentTypes.VEHICLE_APPEARS_IN;
import static com.touchvie.backend.carddetail.relations.ContentTypes.WEAPON_APEARS_IN;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class AppearsInHolder extends HorizontalListHolder {

    public AppearsInHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);
        mTitle.setText(context.getResources().getString(R.string.appears_in));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_appears_in));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.
            }
        });

        ArrayList<ImageTextsRowData> rows = new ArrayList<>();
        for (Relation rel:cardData.getRelations()) {
            if (isRelationAppearsIn(rel)) {
                for (RelationData relData : rel.getData()) {
                    ImageTextsRowData row= new ImageTextsRowData();
                    if(((SingleRel)relData).getData() ==null)
                        continue;
                    if(((SingleRel)relData).getData().getImage() !=null){
                        row.setImage(((SingleRel)relData).getData().getImage().getThumb());
                    }else{
                        row.setImage(null);
                    }
                    row.setTitle(((SingleRel)relData).getData().getTitle());
                    row.setSubtitle(((SingleRel)relData).getData().getSubtitle());
                    row.setCardId(((SingleRel)relData).getData().getCardId());

                }
                break;

            }
        }
        AppearsInAdapter adapter = new AppearsInAdapter(context, rows);
        mList.setAdapter(adapter);

    }

    private boolean isRelationAppearsIn(Relation rel){

        if (VEHICLE_APPEARS_IN.equals(rel.getContent_type()) ||
                FASHION_APEARS_IN.equals(rel.getContent_type()) ||
                TECHNOLOGY_APEARS_IN.equals(rel.getContent_type()) ||
                ART_APEARS_IN.equals(rel.getContent_type()) ||
                HOME_APEARS_IN.equals(rel.getContent_type()) ||
                TRIVIA_APEARS_IN.equals(rel.getContent_type()) ||
                ART_APEARS_IN.equals(rel.getContent_type()) ||
                WEAPON_APEARS_IN.equals(rel.getContent_type()) ||
                LEISURE_SPORT_APEARS_IN.equals(rel.getContent_type()) ||
                HEALTH_BEAUTY_APEARS_IN.equals(rel.getContent_type()) ||
                FAUNA_FLORA_APEARS_IN.equals(rel.getContent_type()) ||
                BUSINESS_APEARS_IN.equals(rel.getContent_type()) ||
                HISTORIC_APEARS_IN.equals(rel.getContent_type()) ) {
            return true;
        }
        return false;

    }
}
