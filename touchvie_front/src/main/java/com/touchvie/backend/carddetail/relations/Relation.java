package com.touchvie.backend.carddetail.relations;


/**
 * Created by Tagsonomy S.L. on 16/10/2016.
 */

public class Relation {
    private String type;
    private String content_type;
    private RelationData[] data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String contentType) {
        this.content_type = contentType;
    }

    public RelationData[] getData() {
        return data;
    }

    public void setData(RelationData[] data) {
        this.data = data;
    }
}

