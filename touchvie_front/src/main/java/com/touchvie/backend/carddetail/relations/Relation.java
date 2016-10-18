package com.touchvie.backend.carddetail.relations;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * Created by Tagsonomy S.L. on 23/09/2016.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true, defaultImpl = Void.class)
@JsonSubTypes({ @Type(value = SingleRel.class, name = RelationTypes.SINGLE),
        @Type(value = DupleRel.class, name = RelationTypes.DUPLE)
})
/**
 * Created by Tagsonomy S.L. on 16/10/2016.
 */

public class Relation {
    private String type;
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
    }
}

