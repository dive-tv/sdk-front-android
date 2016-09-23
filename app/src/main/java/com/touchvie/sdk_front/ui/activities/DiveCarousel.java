package com.touchvie.sdk_front.ui.activities;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.LinearLayout;

import com.touchvie.sdk_front.ui.utils.Utils;
import com.touchvie.sdkfront.R;
import com.touchvie.touchvie_front.CarouselThread;
import com.touchvie.touchvie_front.managers.SceneManager;
import com.touchvie.touchvie_front.simulators.ClientSimulator;
import com.touchvie.touchvie_front.ui.fragments.Carousel;

public class DiveCarousel extends FragmentActivity implements Carousel.CarouselListener , Handler.Callback {

    /**
     * The fragment manager of this activity.
     */
    private FragmentManager mManager = null;
    private CarouselThread mCarouselThread=null;
    private Handler mHandler = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.carousel);
        mManager = getSupportFragmentManager();

        mHandler = new Handler(this);

        mCarouselThread = new CarouselThread("CarouselThread", Thread.MAX_PRIORITY);
        mCarouselThread.setCallback(mHandler);

        mCarouselThread.init(getApplicationContext());
        mCarouselThread.start();

        Carousel carousel = new Carousel();
        mManager.beginTransaction().replace(R.id.carousel, carousel).addToBackStack(Utils.CAROUSEL_FLAG).commit();



    }

    @Override
    public boolean handleMessage(Message message) {

        //TODO
        return false;
    }
}
