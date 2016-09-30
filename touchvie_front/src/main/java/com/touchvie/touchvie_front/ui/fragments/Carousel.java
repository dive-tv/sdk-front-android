package com.touchvie.touchvie_front.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.backend.CardData;
import com.touchvie.backend.Relation;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.data.CarouselCellData;
import com.touchvie.touchvie_front.data.Scene;
import com.touchvie.touchvie_front.ui.adapters.CarouselAdapter;
import com.touchvie.touchvie_front.ui.listeners.CarouselListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


public class Carousel extends Fragment implements CarouselListener {


    private HashMap<Integer, Scene> receivedScenes = null;
    private HashMap<Integer, Scene> visibleScenes = null;
    private Integer subsceneIndex = 0;

    private CarouselListener mListener;

    private StickyListHeadersListView carouselView = null;
    private ArrayList<CarouselCellData> carouselItems = null;

    private CarouselAdapter mAdapter = null;
    private Carousel instance;

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

    protected void addSubscene(Scene scene) {


    }

    protected void showSubscene(int index) {

    }

    protected void showMoreContent() {

    }


    /**
     * TODO: for testing pusposes only
     */

    private ArrayList<CarouselCard> getTestCarouselItems() {

        ArrayList<CarouselCard> items = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

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
                data.setImage("dde6b9f4-03a2-38a9-95b7-2ae7d8a0e1ed/dde6b9f4-03a2-38a9-95b7-2ae7d8a0e1ed_1_es_ES.jpg");
                break;
            case 1:
                data.setTitle("Mansión");
                data.setImage("bd4f26ba-0c2a-3a16-bb7b-79aa066abf44/bd4f26ba-0c2a-3a16-bb7b-79aa066abf44_0_es_ES.jpg");
                break;
            case 2:
                data.setTitle("Jordan Belfort");
                data.setImage("84727ecb-9936-3fb6-8b42-ef08ef98b6c9/84727ecb-9936-3fb6-8b42-ef08ef98b6c9_0_es_ES.jpg");
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
                data.setImage("1a608a46-72b7-3e3d-ada5-07067da934f0/1a608a46-72b7-3e3d-ada5-07067da934f0_2_es_ES.jpg");
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
                data.setImage("b3785a5b-cf5e-3b2d-b90e-e8e11386e576/b3785a5b-cf5e-3b2d-b90e-e8e11386e576_2_es_ES.jpg");
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
                data.setImage("8c988131-bb76-3683-be50-d2766cc26f36/8c988131-bb76-3683-be50-d2766cc26f36_0_es_ES.jpg");
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
                data.setImage("1438446c-5560-333c-b9c1-25c135c2ffce/1438446c-5560-333c-b9c1-25c135c2ffce_0_es_ES.jpg");
                break;
            case 7:
                data.setTitle("¿Sabías qué...?");
                data.setImage("dc70e291-ec2a-3211-9930-f8c520cf5431/dc70e291-ec2a-3211-9930-f8c520cf5431_2_es_ES.jpg");
                break;
            case 8:
                data.setTitle("Nueva York");
                data.setImage("317d5626-d32e-3dda-a6bf-dd309f60bdb7/317d5626-d32e-3dda-a6bf-dd309f60bdb7_0_es_ES.jpg");
                break;
            case 9:
                data.setTitle("Los 80");
                data.setImage("8ac7678c-92ac-3a3a-8619-5d4838ab99d8/8ac7678c-92ac-3a3a-8619-5d4838ab99d8_2_es_ES.jpg");
                break;
            case 10:
                data.setTitle("Mark Hanna");
                data.setImage("8002b798-acd0-3a39-ae9e-1f61e6faae27/8002b798-acd0-3a39-ae9e-1f61e6faae27_0_es_ES.jpg");
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
                data.setImage("9c5a5b35-34ca-3535-b075-409b9205b705/9c5a5b35-34ca-3535-b075-409b9205b705_0_es_ES.jpg");
                break;
            case 12:
                data.setTitle("Helicóptero");
                data.setImage("20dda288-5b81-3107-a877-d94dccd5dfc5/20dda288-5b81-3107-a877-d94dccd5dfc5_0_es_ES.jpg");
                break;
        }

        mPicasso.load(data.getImage()).fetch();
        temp.setData(data);
        temp.setSceneNumber(sceneNumber);
        return temp;
    }

    @Override
    public void onRowsToDraw(ArrayList<CarouselCellData> carouselCellDatas) {
        carouselItems.addAll(carouselCellDatas);
    }
}

