package com.touchvie.backend;

/**
 * Created by Tagsonomy S.L. on 06/10/2016.
 */

public class Container {

    String type;
    String content_type;
    Data data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentType() {
        return content_type;
    }

    public void setContentType(String content_type) {
        this.content_type = content_type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
