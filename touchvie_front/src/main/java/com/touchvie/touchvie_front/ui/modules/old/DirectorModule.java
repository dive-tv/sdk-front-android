package com.touchvie.touchvie_front.ui.modules.old;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.views.Module;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class DirectorModule extends RecyclerView.ViewHolder {

    private ImageView mImage;
    /**
     * Default constructor
     */
    public DirectorModule(View v) {
        super(v);
        mImage = (ImageView) v.findViewById(R.id.module_image_img);
    }
}
