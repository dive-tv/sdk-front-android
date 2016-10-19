package com.touchvie.backend.carddetail.relations;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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

public class RelationData {

}

