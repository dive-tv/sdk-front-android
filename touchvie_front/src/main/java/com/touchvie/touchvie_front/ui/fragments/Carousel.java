package com.touchvie.touchvie_front.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.squareup.picasso.Picasso;
import com.touchvie.touchvie_front.CarouselThread;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.Utils;
import com.touchvie.touchvie_front.data.CarouselCell;
import com.touchvie.touchvie_front.data.Scene;
import com.touchvie.touchvie_front.ui.adapters.CarouselAdapter;
import com.touchvie.touchvie_front.ui.listeners.CarouselListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


public class Carousel extends Fragment implements Handler.Callback, CarouselListener {

    /**
     * The thread to perform all the work to get one carousel row.
     */
    private CarouselThread mCarouselThread = null;


    /**
     * The handler to receive all the messages addressed to the UI thread from the carousel thread.
     */
    private Handler mHandler = null;

    private HashMap<Integer, Scene> receivedScenes = null;
    private HashMap<Integer, Scene> visibleScenes = null;
    private Integer subsceneIndex = 0;

    private CarouselListener mListener;

    private StickyListHeadersListView carouselView = null;
    private ArrayList<CarouselCell> carouselItems = null;

    private CarouselAdapter mAdapter = null;
    private Carousel instance;


    /**
     * Reference to the handler that receives all the messages addressed to the carousel thread.
     */
    private Handler carouselHandler = null;

    /**
     * Button to command the simulator to push a bunch of cards.
     */
    private Button mPushButton = null;
    Random rand = new Random();
    private Picasso mPicasso;

    /**
     * Empty public constructor
     */
    public Carousel() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment
     *
     * @return A new instance of fragment Carousel.
     */
    public static Carousel newInstance() {
        Carousel fragment = new Carousel();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        instance = this;
        super.onCreate(savedInstanceState);
        mPicasso = Picasso.with(getContext());
        mHandler = new Handler(this);

        mCarouselThread = new CarouselThread("CarouselThread", Thread.MAX_PRIORITY);
        mCarouselThread.setCallback(mHandler);

        mCarouselThread.init(getContext(), this);
        mCarouselThread.start();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carousel, container, false);
        receivedScenes = new HashMap<>();
        visibleScenes = new HashMap<>();

        carouselItems = new ArrayList<>();


        mAdapter = new CarouselAdapter(getContext(), carouselItems);

        carouselView = (StickyListHeadersListView) view.findViewById(R.id.carousel_view);
        carouselView.setAdapter(mAdapter);

        mPushButton = (Button) view.findViewById(R.id.btn_push);
        mPushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carouselHandler.sendEmptyMessage(CarouselThread.MSG_PUSH_CARD);
            }
        });
        return view;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    protected void addSubscene(Scene scene) {


    }

    protected void showSubscene(int index) {

    }

    protected void showMoreContent() {

    }


    @Override
    public void onRowsToDraw(ArrayList<CarouselCell> carouselCells) {
        System.out.println("KKKKKKKKK onRowtoDraw " + carouselCells.size());
        carouselItems.addAll(0, carouselCells);
        mAdapter.notifyDataSetChanged();
    }


    /**
     * Handles all the messages addressed to the UI thread.
     *
     * @param msg The message addresed.
     * @return
     */
    @Override
    public boolean handleMessage(Message msg) {
        System.out.println("KKKKKKKKKKKKKK   Carousel push message what: " + msg.what);
        switch (msg.what) {
            case Utils.PUSH:
                System.out.println("KKKKKKKKKKKKKKKKKKK   handler: " + ((ArrayList<CarouselCell>) msg.obj).size());
                onRowsToDraw((ArrayList<CarouselCell>) msg.obj);
                break;
        }
        return false;
    }


    /**
     * Callback that receives  a handler and stores it as the carousel one.
     *
     * @param handler The handler to be stored.
     */

    @Override
    public void setHandler(Handler handler) {
        carouselHandler = handler;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mPushButton.setVisibility(View.VISIBLE);
            }
        });
    }

}

