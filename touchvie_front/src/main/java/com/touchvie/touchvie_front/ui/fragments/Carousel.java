package com.touchvie.touchvie_front.ui.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.backend.Card;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.data.Scene;
import com.touchvie.touchvie_front.ui.adapters.CarouselExampleAdapter;
import com.touchvie.touchvie_front.ui.listeners.CarouselCardListener;
import com.touchvie.touchvie_front.ui.views.CarouselItemCuriosity;
import com.touchvie.touchvie_front.ui.views.CarouselItemGeneric;
import com.touchvie.touchvie_front.ui.views.SceneHeaderItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import eu.davidea.fastscroller.FastScroller;
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;


public class Carousel extends Fragment implements CarouselCardListener, FastScroller.OnScrollStateChangeListener {


    private HashMap<Integer, Scene> receivedScenes = null;
    private HashMap<Integer, Scene> visibleScenes = null;
    private Integer subsceneIndex = 0;

    private CarouselListener mListener;

    private RecyclerView carouselView = null;
    private List<AbstractFlexibleItem> carouselItems = null;

    private CarouselExampleAdapter mAdapter = null;
    private Carousel instance;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carousel, container, false);
        receivedScenes = new HashMap<>();
        visibleScenes = new HashMap<>();
        carouselItems = getTestCarouselItems();//For testing purposes only
        mAdapter = new CarouselExampleAdapter(carouselItems);

        mAdapter.setDisplayHeadersAtStartUp(true)//Show Headers at startUp!
                .setAutoScrollOnExpand(true)
                .setHandleDragEnabled(true)
                .enableStickyHeaders()
                .setNotifyMoveOfFilteredItems(true)//When true, filtering on big list is very slow, not in this case!
                .setNotifyChangeOfUnfilteredItems(true)//We have highlighted text while filtering, so let's enable this feature to be consistent with the active filter
                .setAnimationOnReverseScrolling(true);

        FastScroller fastScroller = (FastScroller) view.findViewById(R.id.fast_scroller);

        carouselView = (RecyclerView) view.findViewById(R.id.carousel_view);
        carouselView.setLayoutManager(new SmoothScrollLinearLayoutManager(getActivity()));
        carouselView.setAdapter(mAdapter);

        //Add FastScroll to the RecyclerView, after the Adapter has been attached the RecyclerView!!!
        mAdapter.setFastScroller(fastScroller, Color.GREEN, instance);


        System.out.println("KKKKKK oncreateview");
        return view;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CarouselListener) {
            mListener = (CarouselListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement CarouselListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Receives a card of the carousel to be shown.
     *
     * @param sceneIndex
     * @param carouselCard
     */
    @Override
    public void onShowCarouselCard(Integer sceneIndex, CarouselCard carouselCard) {

    }

    @Override
    public void onPreloadCarouselCard(String[] imageUrls) {

    }

    @Override
    public void onShowScene(Integer sceneIndex, Scene scene) {

        if (!receivedScenes.containsKey(sceneIndex)) {
            receivedScenes.put(sceneIndex, scene);
        }
    }

    protected void addSubscene(Scene scene) {


    }

    protected void showSubscene(int index) {

    }

    protected void showMoreContent() {

    }

    @Override
    public void onFastScrollerStateChange(boolean scrolling) {
        System.out.println("KKKKKK scrolling " + scrolling);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface CarouselListener {
    }

    /**
     * TODO: for testing pusposes only
     */

    private List<AbstractFlexibleItem> getTestCarouselItems() {

        ArrayList<AbstractFlexibleItem> items = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            SceneHeaderItem sceneHeader = new SceneHeaderItem(i, " SCENE ");

            for (int j = 0; j < 7; j++) {

                items.add(generateRandomCarouselCard(sceneHeader, j));
            }
        }
        return items;
    }

    private AbstractFlexibleItem generateRandomCarouselCard(SceneHeaderItem sceneHeader, int j) {
        Card data = new Card();
        Random r = new Random();
        int rnd = r.nextInt(8);
        switch (rnd) {
            case 0:
                data.setTitle("Ferrari");
                data.setImage("http://i.imgur.com/7L1egba.jpg");
                return new CarouselItemGeneric(j + 1, sceneHeader, data);
            case 1:
                data.setTitle("Mansión");
                data.setImage("http://i.imgur.com/vttzfn4.jpg");
                return new CarouselItemGeneric(j + 1, sceneHeader, data);
            case 2:
                data.setTitle("Suiza");
                data.setImage("http://i.imgur.com/iliue4l.jpg");
                return new CarouselItemGeneric(j + 1, sceneHeader, data);
            case 3:
                data.setTitle("Los 80");
                data.setImage("http://i.imgur.com/EOSf9EC.jpg");
                return new CarouselItemGeneric(j + 1, sceneHeader, data);
            case 4:
                data.setTitle("Nueva York");
                data.setImage("http://i.imgur.com/7xlFXFY.gif");
                return new CarouselItemGeneric(j + 1, sceneHeader, data);
            case 5:
                data.setTitle("¿Sabías qué...?");
                data.setImage("http://i.imgur.com/sVJbVDv.jpg");
                return new CarouselItemCuriosity(j + 1, sceneHeader, data);
            case 6:
                data.setTitle("Brad");
                data.setImage("http://i.imgur.com/1LQggOl.jpg");
                return new CarouselItemCuriosity(j + 1, sceneHeader, data);
            case 7:
                data.setTitle("Helicóptero");
                data.setImage("http://i.imgur.com/vq92crr.jpg");
                return new CarouselItemCuriosity(j + 1, sceneHeader, data);
        }
        return null;
    }


}

