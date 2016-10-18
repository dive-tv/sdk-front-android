package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.view.View;
import android.widget.LinearLayout;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.views.LinearListLayout;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public abstract class VerticalListHolder extends ModuleHolder {

    protected LinearLayout mContainer;
    protected LinearListLayout mList;

    /**
     * Default constructor
     *
     * @param itemView
     */

    public VerticalListHolder(View itemView) {

        super(itemView);

        mContainer = (LinearLayout) itemView.findViewById(R.id.lay_container);
        mList = (LinearListLayout) itemView.findViewById(R.id.lllay_list_list);
    }

}
