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
 * Created by Tagsonomy S.L. on 19/10/2016.
 */

public class MoreLooksHolder extends SquareImageItemsHolder {

    public MoreLooksHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(final CardDetail cardData, Picasso picasso, final Context context, FragmentManager fragmentManager, LinearLayout container) {

        super.configure(cardData, picasso, context, fragmentManager, container);
        mTitle.setText(context.getResources().getString(R.string.more_look_like_this));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_more_looks));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.

            }
        });

        ArrayList<ImageRowData> rows = new ArrayList<>();
        super.setData(rows);
    }
}

