package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.adapters.SoundtrackAdapter;
import com.touchvie.touchvie_front.ui.modules.data.TwoTextRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class SoundtrackHolder extends HorizontalListHolder {

    public SoundtrackHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager fragmentManager, LinearLayout container) {

        super.configure(cardData, picasso, context, fragmentManager, container);
        mTitle.setText(context.getResources().getString(R.string.soundtrack));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_soundtrack));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.
            }
        });

        ArrayList<TwoTextRowData> rows= new ArrayList<>();
        SoundtrackAdapter adapter= new SoundtrackAdapter(rows);
        mList.setAdapter(adapter);

    }
}