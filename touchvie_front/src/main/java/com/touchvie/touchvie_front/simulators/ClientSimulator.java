package com.touchvie.touchvie_front.simulators;


import android.content.Context;
import android.content.res.Resources;

import com.google.gson.GsonBuilder;
import com.touchvie.backend.Card;
import com.touchvie.backend.Relation;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_client.listeners.CardDataListener;
import com.touchvie.touchvie_client.listeners.CarouselCardListener;
import com.touchvie.touchvie_front.R;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 22/09/2016.
 */

public class ClientSimulator  {


    private CarouselCardListener listener=null;

    private int index=0;

    private ArrayList<CarouselCard> cards= new ArrayList<>();

    public ClientSimulator(CarouselCardListener listener, Context context){
        this.listener= listener;

        loadTestCards(context);
        //Load cards from json.
    }


    public void loadOneMoreCard(){

        CarouselCard card= new CarouselCard(); //TODO: get one carousel card from json.
        listener.onCardReceived(card);

    }

    public void loadOneMoreScene(){

        listener.onSectionEndReceived(index);
        index+=1;
        listener.onSectionStartReceived(index);
    }

    private void loadTestCards(Context context){
        String jsonString = null;
        try {
            Resources res = context.getResources();
            InputStream in_s;
            in_s = res.openRawResource(R.raw.cards);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            jsonString = new String(b);
        } catch (Exception e) {
            return;
            //jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        }
        Card [] cardDatas = new GsonBuilder().create().fromJson(jsonString, Card[].class);

        String relationString = null;
        try {
            Resources res = context.getResources();
            InputStream in_s;
            in_s = res.openRawResource(R.raw.cards);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            relationString = new String(b);
        } catch (Exception e) {
            return;
            //relationString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        }

        Relation[] relations = new GsonBuilder().create().fromJson(relationString, Relation[].class); //TODO: By now, just add the same relations

        if(cardDatas !=null){
            for(Card data: cardDatas){
                CarouselCard carouselCard= new CarouselCard();
                carouselCard.setData(data);
                carouselCard.setChildren(relations);
                cards.add(carouselCard);
            }

        }
    }
}
