package com.touchvie.backend.carddetail.containers;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.touchvie.backend.carddetail.ImageData;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true, defaultImpl = Void.class)
@JsonSubTypes({@Type(value = Text.class, name = ContainerTypes.TEXT),
        @Type(value = Listing[].class, name = ContainerTypes.LISTING),
        @Type(value = Rating[].class, name = ContainerTypes.RATING),
        @Type(value = Map.class, name = ContainerTypes.MAP),
        @Type(value = Link[].class, name = ContainerTypes.LINK),
        @Type(value = Awards[].class, name = ContainerTypes.AWARDS),
        @Type(value = Catalog.class, name = ContainerTypes.CATALOG),
        @Type(value = Seasons[].class, name = ContainerTypes.SEASONS),
        @Type(value = ImageData[].class, name = ContainerTypes.IMAGE)
})
/**
 * Created by Tagsonomy S.L. on 16/10/2016.
 */

public class ContainerData {
/*    private String type;
    private String content_type;

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
    }*/
}
