package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.utils.Utils;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class SingleModuleHolder  extends ModuleHolder {

    protected TextView mContainerTitle;
    protected ImageView mImage;
    protected TextView mTitle;
    protected TextView mSubtitle;

    /**
     * Default constructor
     *
     * @param itemView
     */

    public SingleModuleHolder(View itemView) {

        super(itemView);
        mContainerTitle = (TextView) itemView.findViewById(R.id.txtv_title);
        mImage = (ImageView) itemView.findViewById(R.id.imgv_smodule_image);
        mTitle = (TextView) itemView.findViewById(R.id.txtv_smodule_title);
        mSubtitle = (TextView) itemView.findViewById(R.id.txtv_smodule_subtitle);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context, FragmentManager fragmentManager, LinearLayout container) {

        mContainerTitle.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
        mTitle.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD));
        mSubtitle.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
    }

}