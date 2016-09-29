package com.touchvie.touchvie_front.logic;

import android.content.Context;
import android.content.res.Resources;

import com.google.gson.GsonBuilder;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.data.CarouselCell;
import com.touchvie.touchvie_front.data.GroupableTree;

import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by Tagsonomy S.L. on 27/09/2016.
 */

public class CarouselLogic {
    private Context context;
    private GroupableTree groupableTree;
    public CarouselLogic(Context context) {
        this.context = context;
    }

    public void processData(CarouselCard[] cards){
        CarouselCard lastCard = null;
        CarouselCard newCard = null;
        CarouselCell cells[] = null;

        for (CarouselCard card:cards){
            newCard = card;
            if (newCard!=null && lastCard!=null && checkGroupableTree(newCard, lastCard)){

            }
            lastCard = newCard;
        }
    }

    private boolean checkGroupableTree(CarouselCard Card, CarouselCard last){


        return false;
    };

    private void loadGroupable(){
        String jsonString = null;
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(R.raw.groupabletree);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            jsonString = new String(b);
        } catch (Exception e) {
            //jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        }
        groupableTree = new GsonBuilder().create().fromJson(jsonString, GroupableTree.class);
        if (groupableTree == null) {
            groupableTree = new GroupableTree();
        }
    }
}
