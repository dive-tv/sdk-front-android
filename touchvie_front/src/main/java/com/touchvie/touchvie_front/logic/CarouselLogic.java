package com.touchvie.touchvie_front.logic;

import android.content.Context;
import android.content.res.Resources;

import com.google.gson.GsonBuilder;
import com.google.gson.internal.Streams;
import com.touchvie.backend.TypeOfCard;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.data.CarouselCellData;
import com.touchvie.touchvie_front.data.GroupableTree;
import com.touchvie.touchvie_front.ui.fragments.Carousel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Tagsonomy S.L. on 27/09/2016.
 */

public class CarouselLogic {
    private Context context;
    private GroupableTree groupableTree;
    private HashMap<String,HashMap<String,String>> tree;
    private HashMap<String,String> tree1;

    public CarouselLogic(Context context) {
        this.context = context;
        loadGroupable();
    }

    public void processData(ArrayList<CarouselCard> cards) {
        CarouselCard lastCard = null;
        CarouselCard newCard = null;
        ArrayList<CarouselCellData> cells = new ArrayList<>();

        for (CarouselCard card : cards) {
            newCard = card;
            if (newCard != null && lastCard != null && checkGroupableTree(newCard, lastCard)) {

            }
            lastCard = newCard;
        }
        //Carousel.onRowsToDraw(cells);
    }

    private boolean checkGroupableTree(CarouselCard Card, CarouselCard last) {


        return false;
    }

    ;

    private void loadGroupable() {
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

        tree = new HashMap<>();
        tree1 = new HashMap<>();
        if (groupableTree.getChildren() != null ) {
            if (groupableTree.getChildren().getChildren()!=null){
                tree1.put(groupableTree.getChildren().getTypeOfCard().toString(), groupableTree.getChildren().getChildren().toString());
            } else {
                tree1.put(groupableTree.getChildren().getTypeOfCard().toString(), null);
            }
            tree.put(groupableTree.getTypeOfCard().toString(),tree1);
        }


    }
}
