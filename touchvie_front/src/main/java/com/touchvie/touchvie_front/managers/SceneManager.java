package com.touchvie.touchvie_front.managers;

import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_client.listeners.CarouselCardListener;
import com.touchvie.touchvie_front.data.Scene;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Tagsonomy S.L. on 19/09/2016.
 */
public class SceneManager implements CarouselCardListener{

    private HashMap<String, Scene> scenes;
    private String currentScene=null;

    private ArrayList<CarouselCard> orphanedCards;


    public SceneManager(){
        scenes=new HashMap<>();
    }

    /**
     * Listener to receive each card from the client.
     * @param card Card received.
     */
    @Override
    public void onCardReceived(CarouselCard card) {

        if(currentScene==null){
            if(orphanedCards==null){
                orphanedCards= new ArrayList<>();
                orphanedCards.add(card);
            }
        }else{
            Scene scene= scenes.get(currentScene);
            if(scene==null){
                scene= new Scene();
                scenes.put(currentScene,scene );
            }
            scene.addCarouselCard(card);
        }
    }

    /**
     * Listener to be reported about a section end.
     * @param sectionId The id of the section received.
     */
    @Override
    public void onSectionEndReceived(String sectionId) {

        currentScene=null;
        if(orphanedCards !=null){
            Scene scene= scenes.get(sectionId);
            if(scene !=null){
                scene.addCarouselCards(orphanedCards);
            }else{
                scene=new Scene();
                scene.addCarouselCards(orphanedCards);
                scenes.put(sectionId, scene);
            }
            orphanedCards.clear();
        }

    }

    /**
     * Listener to be reported about a section start.
     * @param sectionId The id of the section to be received.
     */

    @Override
    public void onSectionStartReceived(String sectionId) {

        currentScene=sectionId;
        scenes.put(sectionId, new Scene());
    }


}
