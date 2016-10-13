package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.views.Module;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public abstract class ListModule extends Module {

    /**
     * Default constructor
     */
    public ListModule() {
        super();
        setLayout(R.layout.module_list);
    }

}

