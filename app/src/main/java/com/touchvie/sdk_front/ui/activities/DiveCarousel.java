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

import java.util.ArrayList;

public class DiveCarousel extends FragmentActivity implements CarouselListener, Handler.Callback, TestListener {

    /**
     * The fragment manager of this activity.
     */
    private FragmentManager mManager = null;

    /**
     * The thread to perform all the work to get one carousel row.
     */
    private CarouselThread mCarouselThread=null;

    /**
     * The handler to receive all the messages addressed to the UI thread from the carousel thread.
     */
    private Handler mHandler = null;

    /**
     * Reference to the handler that receives all the messages addressed to the carousel thread.
     */
    private Handler carouselHandler=null;

    /**
     * Button to command the simulator to push a bunch of cards.
     */
    private Button mPushButton =null;


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

        mHandler = new Handler(this);

        mCarouselThread = new CarouselThread("CarouselThread", Thread.MAX_PRIORITY);
        mCarouselThread.setCallback(mHandler);

        mCarouselThread.init(getApplicationContext(), this);
        mCarouselThread.start();

        Carousel carousel = new Carousel();
        mManager.beginTransaction().replace(R.id.carousel, carousel).addToBackStack(Utils.CAROUSEL_FLAG).commit();

        mPushButton =(Button)findViewById(R.id.btn_push);
        mPushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carouselHandler.sendEmptyMessage(CarouselThread.MSG_PUSH_CARD);
            }
        });

    }

    /**
     * Handles all the messages addressed to the UI thread.
     * @param msg The message addresed.
     * @return
     */
    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }


    /**
     * Callback that receives  a handler and stores it as the carousel one.
     * @param handler The handler to be stored.
     */
    @Override
    public void setHandler(Handler handler) {
        carouselHandler=handler;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mPushButton.setVisibility(View.VISIBLE);
            }
        });
    }


    @Override
    public void onRowsToDraw(ArrayList<CarouselCellData> carouselCellDatas) {

    }
}
