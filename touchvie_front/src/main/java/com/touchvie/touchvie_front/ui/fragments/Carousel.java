package com.touchvie.touchvie_front.ui.fragments;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.backend.Card;
import com.touchvie.backend.CardData;
import com.touchvie.backend.Relation;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.data.Scene;
import com.touchvie.touchvie_front.ui.adapters.CarouselAdapter;
import com.touchvie.touchvie_front.ui.listeners.CarouselCardListener;
import com.touchvie.touchvie_front.ui.views.SceneHeaderItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import eu.davidea.fastscroller.FastScroller;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.utils.Utils;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;



public class Carousel extends Fragment implements CarouselCardListener, FastScroller.OnScrollStateChangeListener {


    private HashMap<Integer, Scene> receivedScenes = null;
    private HashMap<Integer, Scene> visibleScenes = null;
    private Integer subsceneIndex = 0;

    private CarouselListener mListener;

    private StickyListHeadersListView carouselView = null;
    private ArrayList<CarouselCard> carouselItems = null;

    private CarouselAdapter mAdapter = null;
    private Carousel instance;

    Random rand = new Random();

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

        mAdapter = new CarouselAdapter(getContext(), carouselItems);

        carouselView = (StickyListHeadersListView) view.findViewById(R.id.carousel_view);
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

    @Override
    public void onCardsForPreloadReceived(CarouselCard[] cards) {

    }

    @Override
    public void onSectionEndReceived(String sectionId, Double end) {

    }

    @Override
    public void onSectionStartReceived(String sectionId, Double start) {

    }

    @Override
    public void onCardsForPaintReceived(String[] cardIds) {

    }

    @Override
    public void onCarouselSceneChanged(int sceneId) {

    }

    protected void addSubscene(Scene scene) {


    }

    protected void showSubscene(int index) {

    }

    protected void showMoreContent() {

    }

    @Override
    public void onFastScrollerStateChange(boolean scrolling) {

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

    private ArrayList<CarouselCard> getTestCarouselItems() {

        ArrayList<CarouselCard> items = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            SceneHeaderItem sceneHeader = new SceneHeaderItem(i, " SCENE ");

            for (int j = 0; j < 7; j++) {
                items.add(generateRandomCarouselCard(i));
            }
        }
        return items;
    }

    private CarouselCard generateRandomCarouselCard(int sceneNumber) {
        CarouselCard temp = new CarouselCard();
        CardData data = new CardData();
        int rnd = rand.nextInt(13);
        switch (rnd) {
            case 0:
                data.setTitle("Ferrari");
                data.setImage("http://i.imgur.com/7L1egba.jpg");
                break;
            case 1:
                data.setTitle("Mansión");
                data.setImage("http://i.imgur.com/vttzfn4.jpg");
                break;
            case 2:
                data.setTitle("Jordan Belfort");
                data.setImage("http://i.imgur.com/MQ1SWyh.jpg");
                Relation rel1 = new Relation();
                Card relCard1 = new Card();
                relCard1.setTitle("Traje Armani");
                relCard1.setImage("http://i.imgur.com/kNjXkKy.jpg");
                Relation rel2 = new Relation();
                Card relCard2 = new Card();
                relCard2.setTitle("Zapatos");
                relCard2.setImage("http://i.imgur.com/4W8uL80.jpg");
                Relation[] rels = new Relation[2];
                rels[0] = rel1;
                rels[1] = rel2;
                temp.setChildren(rels);
                break;
            case 3:
                data.setTitle("Donnie Azoff");
                data.setImage("http://i.imgur.com/HWAxhwP.png");
                Relation rel10 = new Relation();
                Card relCard10 = new Card();
                relCard10.setTitle("Camisa");
                relCard10.setImage("http://i.imgur.com/9yN9vse.jpg");
                Relation[] rels4 = new Relation[1];
                rels4[0] = rel10;
                temp.setChildren(rels4);
                break;
            case 4:
                data.setTitle("Yate");
                data.setImage("http://i.imgur.com/ZEjJ2T6.jpg");
                Relation rel9 = new Relation();
                Card relCard9 = new Card();
                relCard9.setTitle("Puerto");
                relCard9.setImage("http://i.imgur.com/mRhNiUd.jpg");
                Relation[] rels5 = new Relation[1];
                rels5[0] = rel9;
                temp.setChildren(rels5);
                break;
            case 5:
                data.setTitle("Wall Street");
                data.setImage("http://i.imgur.com/TsqenDf.jpg");
                Relation rel7 = new Relation();
                Card relCard7 = new Card();
                relCard7.setTitle("Bolsa de NY");
                relCard7.setImage("http://i.imgur.com/agM641t.jpg");
                Relation rel8 = new Relation();
                Card relCard8 = new Card();
                relCard8.setTitle("Acciones a centavo");
                relCard8.setImage("http://i.imgur.com/LIWqjvB.jpg");
                Relation[] rels3 = new Relation[2];
                rels3[0] = rel7;
                rels3[1] = rel8;
                temp.setChildren(rels3);
                break;
            case 6:
                data.setTitle("Curiosity card test");
                data.setImage("http://i.imgur.com/vq92crr.jpg");
                break;
            case 7:
                data.setTitle("¿Sabías qué...?");
                data.setImage("http://i.imgur.com/sVJbVDv.jpg");
                break;
            case 8:
                data.setTitle("Nueva York");
                data.setImage("http://i.imgur.com/7xlFXFY.gif");
                break;
            case 9:
                data.setTitle("Los 80");
                data.setImage("http://i.imgur.com/EOSf9EC.jpg");
                break;
            case 10:
                data.setTitle("Mark Hanna");
                data.setImage("http://i.imgur.com/wJYjSyO.jpg");
                Relation rel3 = new Relation();
                Card relCard3 = new Card();
                relCard3.setTitle("Traje");
                relCard3.setImage("http://i.imgur.com/RdllUq3.jpg");
                Relation rel4 = new Relation();
                Card relCard4 = new Card();
                relCard4.setTitle("Zapatos");
                relCard4.setImage("http://i.imgur.com/rms7VaC.jpg");
                Relation[] rels2 = new Relation[4];
                rels2[0] = rel3;
                rels2[1] = rel4;
                temp.setChildren(rels2);
                break;
            case 11:
                data.setTitle("Brad");
                data.setImage("http://i.imgur.com/1LQggOl.jpg");
                break;
            case 12:
                data.setTitle("Helicóptero");
                data.setImage("http://i.imgur.com/vq92crr.jpg");
                break;
        }

        temp.setData(data);
        temp.setSceneNumber(sceneNumber);
        return temp;
    }
}

