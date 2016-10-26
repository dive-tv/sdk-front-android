package com.touchvie.sdk_front.ui.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;

import com.touchvie.sdk_front.ui.utils.Utils;
import com.touchvie.sdkfront.R;
import com.touchvie.touchvie_client.listeners.CarouselCardListener;
import com.touchvie.touchvie_front.ui.fragments.Carousel;
import com.touchvie.touchvie_front.ui.listeners.CarouselFragmentListener;

public class TestCarousel extends FragmentActivity implements CarouselFragmentListener {

    /**
     * The fragment manager of this activity.
     */
    private FragmentManager mManager = null;


    /**
     * Activity creation
     *
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

    @Override
    public void setCarouselCardListener(Handler listener) {

    }
}
