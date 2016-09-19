package com.touchvie.touchvie_front.ui.modules;

import android.view.View;
import android.widget.TextView;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.Module;

/**
 * Created by rodrigo.moral on 16/09/2016.
 */
public class TitleModule extends Module {

    private TextView mTitle;

    /**
     * Default constructor
     */
    public TitleModule(View v) {
        super(v);
        mTitle = (TextView) v.findViewById(R.id.module_title_txt);
    }

    public TextView getmTitle() {
        return mTitle;
    }

    public void setmTitle(TextView mTitle) {
        this.mTitle = mTitle;
    }

    public void configure(TitleModule titleVH, int position) {
        titleVH.getmTitle().setText("TITLE TEST");
    }
}
