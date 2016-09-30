package com.touchvie.sdk_front.ui.activities;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.touchvie.sdk_front.ui.utils.Utils;
import com.touchvie.sdkfront.R;
import com.touchvie.touchvie_front.CarouselThread;
import com.touchvie.touchvie_front.data.CarouselCellData;
import com.touchvie.touchvie_front.ui.fragments.Carousel;
import com.touchvie.touchvie_front.ui.listeners.CarouselListener;
import com.touchvie.touchvie_front.ui.listeners.TestListener;

public class DiveCarousel extends FragmentActivity  {

    /**
     * The fragment manager of this activity.
     */
    private FragmentManager mManager = null;



    /**
     * Activity creation
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.carousel);
        mManager = getSupportFragmentManager();


        Carousel carousel = new Carousel();
        mManager.beginTransaction().replace(R.id.carousel, carousel).addToBackStack(Utils.CAROUSEL_FLAG).commit();
    }


}
