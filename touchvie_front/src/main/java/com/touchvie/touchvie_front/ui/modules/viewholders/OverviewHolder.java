package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.TypeOfContainer;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.Container;
import com.touchvie.backend.carddetail.containers.Text;
import com.touchvie.touchvie_client.data.ImageSize;
import com.touchvie.touchvie_client.manager.ClientManager;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.listeners.ExpandableListener;
import com.touchvie.touchvie_front.ui.utils.Utils;

import static android.view.View.GONE;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class OverviewHolder extends TextHolder implements ExpandableListener {

    public OverviewHolder(View view) {
        super(view);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        title.setText(context.getResources().getString(R.string.synopsis));
        title.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
        //TODO: get data

    }

    @Override
    public void onActionDone(boolean expanded) {
        more.setVisibility(expanded ? GONE : View.VISIBLE);
    }
}
