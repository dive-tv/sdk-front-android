package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.viewholders.TextHolder;
import com.touchvie.touchvie_front.ui.views.Module;

import java.util.zip.Inflater;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

public  abstract class TextModule extends Module {

    /**
     * Default constructor
     */
    public TextModule() {
        super();
        setLayout(R.layout.module_text);
    }


}
