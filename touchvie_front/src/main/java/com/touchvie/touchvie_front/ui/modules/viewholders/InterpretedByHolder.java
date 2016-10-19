package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

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

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class InterpretedByHolder extends SquareImageItemsHolder {

    public InterpretedByHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(final CardDetail cardData, Picasso picasso, final Context context, FragmentManager mFragmentManager, LinearLayout container) {

        super.configure(cardData, picasso, context, mFragmentManager, container);
        mTitle.setText(context.getResources().getString(R.string.interpreted_by));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_interpreted_by));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.

                     }
        });

        ArrayList<ImageRowData> rows = new ArrayList<>();
        ImageRowData row=null;
        for (Relation rel:cardData.getRelations()){
            if (CASTING.equals(rel.getContent_type())){
                for (RelationData relData:rel.getData()){
                    row.setImage(((DupleRel)relData).getTo().getImage().getFull());
                    TextData title = new TextData();
                    title.setText(((DupleRel)relData).getTo().getTitle());
                    title.setUrl(null);
                    ArrayList<TextData> arrayTitle=new ArrayList<>();
                    arrayTitle.add(title);
                    row.setTitle(arrayTitle);
                    TextData subTitle = new TextData();
                    subTitle.setText(((DupleRel)relData).getTo().getSubtitle());
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
