package com.touchvie.sdk_front.ui.activities;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

import com.touchvie.sdkfront.R;
import com.touchvie.touchvie_front.ui.fragments.Carousel;

public class DiveCarousel extends FragmentActivity implements Carousel.CarouselListener {

    private FragmentManager mManager = null;
    LinearLayout mContainer=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.carousel);
        mContainer = (LinearLayout) findViewById(R.id.carousel);
        mManager = getSupportFragmentManager();
        Carousel carousel = new Carousel();
        mManager.beginTransaction().replace(this.mContainer.getId(), carousel).addToBackStack("CAROUSEL").commit();
    }
}
