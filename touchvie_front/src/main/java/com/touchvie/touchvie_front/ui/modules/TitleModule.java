package com.touchvie.touchvie_front.ui.modules;

import android.view.View;
import android.widget.ImageView;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.Module;

/**
 * Created by rodrigo.moral on 16/09/2016.
 */
public class TitleModule extends Module {

    private ImageView mImage;
    /**
     * Default constructor
     */
    public TitleModule(View v) {
        super(v);
        mImage = (ImageView) v.findViewById(R.id.module_image_img);
    }

}
