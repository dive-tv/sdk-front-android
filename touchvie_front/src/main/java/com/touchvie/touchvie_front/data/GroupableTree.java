package com.touchvie.touchvie_front.data;

import com.touchvie.backend.TypeOfCard;
import com.touchvie.touchvie_client.data.CarouselCard;

import java.lang.reflect.Type;

/**
 * Created by Tagsonomy S.L. on 29/09/2016.
 */

public class GroupableTree {
    private TypeOfCard type;
    private GroupableTree children;

    public TypeOfCard getTypeOfCard(){
        return type;
    }

    public void setTypeOfCard(TypeOfCard type){
        this.type = type;
    }

    public GroupableTree getChildren(){
        return children;
    }

    public void setChildren(GroupableTree children){
        this.children = children;
    }

}
