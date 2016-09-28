package com.touchvie.sdk_front.ui.activities;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.touchvie.sdk_front.ui.utils.Utils;
import com.touchvie.sdkfront.R;
import com.touchvie.touchvie_front.CarouselThread;
import com.touchvie.touchvie_front.managers.SceneManager;
import com.touchvie.touchvie_front.simulators.ClientSimulator;
import com.touchvie.touchvie_front.ui.fragments.Carousel;
import com.touchvie.touchvie_front.ui.listeners.TestListener;

public class DiveCarousel extends FragmentActivity implements Carousel.CarouselListener , Handler.Callback, TestListener {

    /**
     * The fragment manager of this activity.
     */
    private FragmentManager mManager = null;
    private CarouselThread mCarouselThread=null;
    private Handler mHandler = null;
    private Button mTestButton=null;
    private Button mSceneButton=null;
    private Button mPush=null;
    private Handler carouselHandler=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.carousel);
        mManager = getSupportFragmentManager();

        mHandler = new Handler(this);

        mCarouselThread = new CarouselThread("CarouselThread", Thread.MAX_PRIORITY);
        mCarouselThread.setCallback(mHandler);

        mCarouselThread.init(getApplicationContext(), this);
        mCarouselThread.start();

        Carousel carousel = new Carousel();
        mManager.beginTransaction().replace(R.id.carousel, carousel).addToBackStack(Utils.CAROUSEL_FLAG).commit();
        mTestButton=(Button)findViewById(R.id.btn_more_cards);
        mTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carouselHandler.sendEmptyMessage(CarouselThread.MSG_GET_CARD);
            }
        });
        mTestButton.setVisibility(View.GONE);

        mSceneButton= (Button)findViewById(R.id.btn_new_scene);
        mSceneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carouselHandler.sendEmptyMessage(CarouselThread.MSG_NEW_SCENE);
            }
        });

        mPush=(Button)findViewById(R.id.btn_push);
        mPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carouselHandler.sendEmptyMessage(CarouselThread.MSG_PUSH_CARD);
            }
        });

    }

    @Override
    public boolean handleMessage(Message msg) {

        return false;
    }


    @Override
    public void setHandler(Handler handler) {
        carouselHandler=handler;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTestButton.setVisibility(View.VISIBLE);
            }
        });
    }


}
