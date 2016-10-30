package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class InterpretedBySingleHolder extends SingleModuleHolder {

    /**
     * Default constructor
     *
     * @param itemView
     */
    public InterpretedBySingleHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);

        mContainerTitle.setText(context.getResources().getString(R.string.interpreted_by));

        //TODO: set image , title and subtitle. remember , they are  defined in parent
    }
}
