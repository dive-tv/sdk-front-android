package com.touchvie.touchvie_front.simulators;


import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

import com.google.gson.GsonBuilder;
import com.touchvie.backend.CardData;
import com.touchvie.backend.MiniCard;
import com.touchvie.backend.carddetail.Relation;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_client.listeners.CarouselCardListener;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.Utils;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 22/09/2016.
 * Class to simulate a cards stream and push events.
 */

public class ClientSimulator  {

    /**
     * A reference to the object that will receive all the simulator generated events.
     */
    private CarouselCardListener listener=null;

    /**
     * Index of each section/scene where the cards belong to.
     */
    private int sectionIndex =0;

    /**
     * Last card index that has been sent to be preloaded.
     */
    private int lastCardPreloadedIndex =0; //Index in the cards array. [0...cards.size()-1]

    /**
     * Last card index that has been  pushed.
     */
    private int lastCardPushedIndex=0;

    /**
     * The number of cards that a scene will have. For testing purposes we add the same number of cards on each scene.
     */
    private int cardsPerScene=0;

    /**
     * Runnable to establish when to perform a cards preload.
     */
    private Runnable mTickRunnable;

    /**
     * Handler to manager the cards preload.
     */
    private Handler preloadHandler;

    /**
     * Array containing all the cards that can be used by the simulator.
     */
    private ArrayList<CarouselCard> cards= new ArrayList<>();

    /**
     * Constructor.
     * @param listener The object that will receive the Simulator events.
     * @param context The context to use the library resources in res folder.
     */
    public ClientSimulator(CarouselCardListener listener, Context context){
        this.listener= listener;
        loadTestCards(context); //Load cards from json.
        startSimulator();
    }


    /**
     * Notifies the bunch of cards that must be pushed into the carousel.
     */

    public void pushCards(){

        //We get a random number of cardIds to be pushed. We cannot push a card that has not been already preloaded.

        int cardsToGet = Utils.randInt(1,cardsPerScene);
        if(lastCardPushedIndex >=lastCardPreloadedIndex){
            return;
        }

        if(cardsToGet > lastCardPreloadedIndex -lastCardPushedIndex){
            cardsToGet=lastCardPreloadedIndex -lastCardPushedIndex;
        }

        ArrayList<String> cardsToPush= new ArrayList<>();


        for(int i=0; i<cardsToGet; i++){
            CarouselCard card= cards.get(lastCardPushedIndex +1);
            cardsToPush.add(card.getCardId());
            lastCardPushedIndex++;
        }
        listener.onCardsForPaintReceived(cardsToPush);
        return ;

    }

    /**
     * Start the simulator engine to perform the cards preload. Must be used after the cards has been received/stored in the simulator.
     */
    private void startSimulator(){

        preloadHandler = new Handler();
        mTickRunnable = new Runnable() {
            @Override
            public void run() {
                if (!sendCardsToPreload())
                    preloadHandler.postDelayed(this, 1000);
            }
        };
        preloadHandler.postDelayed(mTickRunnable, 1000);

    }

    /**
     * Notifies the listener the cards that must be preloaded. The number of cards is a random one inside 1 and the max number of cards of a subscene.
     * @return
     */
    private boolean sendCardsToPreload(){

        int cardsToGet = Utils.randInt(1,cardsPerScene);
        int subsceneIndex=-1;
        if(lastCardPreloadedIndex +1>=cards.size()){
            stopSimulator();
            return true;
        }

        if(cardsToGet > cards.size()-(lastCardPreloadedIndex +1)){
            cardsToGet=cards.size()-(lastCardPreloadedIndex +1);
        }

        ArrayList<CarouselCard> cardsToPreload= new ArrayList<>();

        //In this test case we just preload cards that are in the same scene. In real world cards can come from different scenes together.

        for(int i=0; i<cardsToGet; i++){
            CarouselCard card= cards.get(lastCardPreloadedIndex +1);
            if(subsceneIndex ==-1){
                cardsToPreload.add(card);
                lastCardPreloadedIndex++;
                subsceneIndex=card.getSceneId();
                continue;
            }
            if(card.getSceneId()!=subsceneIndex){
                break;
            }
            cardsToPreload.add(card);
        }

        listener.onCardsForPreloadReceived(cardsToPreload);
        return false;
    }

    /**
     * Stops the simulator event of preload.
     */
    public void stopSimulator(){
        preloadHandler.removeCallbacks(mTickRunnable);
    }

    /**
     * Stores all the cards that will be used to simulate the cards stream.
     * @param context context to use the files under the resources directory.
     */
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
        }
        CardData[] miniCards = new GsonBuilder().create().fromJson(jsonString, CardData[].class);
        cardsPerScene= miniCards.length;

        String relationString = null;
        try {
            Resources res = context.getResources();
            InputStream in_s;
            in_s = res.openRawResource(R.raw.relations);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            relationString = new String(b);
        } catch (Exception e) {
            return;
        }

        Relation[] relations = new GsonBuilder().create().fromJson(relationString, Relation[].class); //TODO: By now, just add the same relations


        if(miniCards !=null){
            int id=0;
            for (int i=0; i<10; i++) {
                for (CardData data : miniCards) {
                    CarouselCard carouselCard = new CarouselCard();
                    carouselCard.setCardId(id);
                    carouselCard.setSceneId(sectionIndex);
                    carouselCard.setData(data);
                    carouselCard.setChildren(relations);
                    cards.add(carouselCard);
                    id++;
                }
                sectionIndex++;
            }

        }
    }
}
