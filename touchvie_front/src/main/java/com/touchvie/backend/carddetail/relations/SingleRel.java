package com.touchvie.backend.carddetail.relations;

import com.touchvie.backend.MiniCard;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class SingleRel extends RelationData {
    private MiniCard data;

    public MiniCard getData() {
        return data;
    }

    public void setData(MiniCard data) {
        this.data = data;
    }
}
