package com.touchvie.touchvie_front.ui.modules;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.viewholders.SingleModuleHolder;
import com.touchvie.touchvie_front.ui.views.Module;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public abstract class SingleModule extends Module {

    public SingleModule(){
        super();
        setLayout(R.layout.module_single_module);
    }

}
