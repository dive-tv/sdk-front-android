package com.touchvie.sdk_front.ui.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.touchvie.sdkfront.R;
import com.touchvie.touchvie_front.ui.fragments.Carousel;

public class DiveCarousel extends AppCompatActivity implements Carousel.CarouselListener {

    private FragmentManager mManager = null;
    LinearLayout mContainer=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.carddetail);
        mContainer = (LinearLayout) findViewById(R.id.carddetail);
        mManager = getSupportFragmentManager();
        Carousel carousel = new Carousel();
        mManager.beginTransaction().replace(this.mContainer.getId(), carousel).addToBackStack("CAROUSEL").commit();
    }
}
