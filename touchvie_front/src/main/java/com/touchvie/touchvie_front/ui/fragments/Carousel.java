package com.touchvie.touchvie_front.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.ui.listeners.CarouselCardListener;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.data.Scene;
import com.touchvie.touchvie_front.ui.views.CarouselItem;
import com.touchvie.touchvie_front.ui.views.SceneHeaderItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;


public class Carousel extends Fragment implements CarouselCardListener {


    private HashMap<Integer, Scene> receivedScenes= null;
    private HashMap<Integer, Scene> visibleScenes=null;
    private Integer subsceneIndex=0;

    private CarouselListener mListener;

    private RecyclerView carouselView=null;
    private List<AbstractFlexibleItem>  carouselItems = null;

    private FlexibleAdapter<AbstractFlexibleItem> mAdapter =null;

    /**
     * Empty public constructor
     */
    public Carousel() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment
     * @return A new instance of fragment Carousel.
     */
    public static Carousel newInstance() {
        Carousel fragment = new Carousel();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carousel, container, false);
        receivedScenes= new HashMap<>();
        visibleScenes= new HashMap<>();
        carouselItems=getTestCarouselItems();//For testing purposes only
        mAdapter = new FlexibleAdapter<>(carouselItems);
        mAdapter.setDisplayHeadersAtStartUp(true)//Show Headers at startUp!
                .enableStickyHeaders();

        carouselView=(RecyclerView) view.findViewById(R.id.carousel_view);
        carouselView.setLayoutManager(new SmoothScrollLinearLayoutManager(getActivity()));
        carouselView.setAdapter(mAdapter);
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

        if(!receivedScenes.containsKey(sceneIndex)){
            receivedScenes.put(sceneIndex, scene);
        }
    }

    protected void addSubscene(Scene scene){


    }

    protected void showSubscene(int index){

    }

    protected  void showMoreContent(){

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

    private  List<AbstractFlexibleItem> getTestCarouselItems(){

        ArrayList<AbstractFlexibleItem> items= new ArrayList<>();
        for (int i=0; i<4; i++){
            SceneHeaderItem sceneHeader= new SceneHeaderItem(i, " SCENE ");

            for (int j = 0; j < 7; j++) {
                items.add(new CarouselItem(j + 1, sceneHeader));
            }
        }
        return items;
    }

}