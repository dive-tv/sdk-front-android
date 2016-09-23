package com.touchvie.touchvie_front;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import com.touchvie.touchvie_front.managers.SceneManager;
import com.touchvie.touchvie_front.simulators.ClientSimulator;

/**
 * Created by Tagsonomy S.L. on 23/09/2016.
 */

public class CarouselThread extends HandlerThread implements  Handler.Callback {


    private Handler handler;
    private Handler callback;

    private Context context;

    /**
     * Constructor
     *
     * @param name     the name
     * @param priority the priority
     */
    public CarouselThread(String name, int priority) {
        super(name, priority);
    }

    /**
     * Sets the handler that will receive this thread messages. In this case will be the UI thread managed in the fragment.
     *
     * @param cb the cb
     */
    public void setCallback(Handler cb) {
        callback = cb;
    }

    /**
     * Initialized the thread. Basically it creates a new Carousel object. //TODO: in version 2.0 will create a CarouselBuilder object.
     *
     * @param context         the context
     */
    public void init(Context context) {

    this.context=context;
    }



    /**
     * Callback when the thread loop has been prepared. Used to start the request of server data. TODO: in carousel 2.0 will start builder requests.
     */
    @Override
    protected void onLooperPrepared() {
        handler = new Handler(getLooper(), this);

        SceneManager sceneManager= new SceneManager();
        ClientSimulator simulator= new ClientSimulator(sceneManager, context);
    }

    /**
     * Handles the messages sent to this thread. Used to forward the messages from inside this thread to the UI thread.
     *
     * @param {Message} msg Message received by the thread.
     * @return
     */

    @Override
    public boolean handleMessage(final Message msg) {

        switch (msg.what) {

        }
        return false;
    }

}
