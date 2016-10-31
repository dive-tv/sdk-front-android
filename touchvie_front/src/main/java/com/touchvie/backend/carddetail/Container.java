package com.touchvie.backend.carddetail;

import com.touchvie.backend.carddetail.containers.ContainerData;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 06/10/2016.
 */

public class Container implements Serializable {

    String type;
    String content_type;
    ContainerData[] data;

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

    public ContainerData[] getData() {
        return data;
    }

    public void setData(ContainerData[] data) {
        this.data = data;
    }
}
