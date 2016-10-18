package com.touchvie.touchvie_front.data;

import com.touchvie.backend.TypeOfCard;

/**
 * Created by Tagsonomy S.L. on 03/10/2016.
 */

public class Tree {
    private String type;
    private Tree[] children;

    public String getTypeOfCard(){
        return type;
    }

    public void setTypeOfCard(String type){
        this.type = type;
    }

    public Tree[] getChildren(){
        return children;
    }

    public void setChildren(Tree[] children){
        this.children = children;
    }
}
