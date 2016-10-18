package com.touchvie.backend.carddetail;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 06/10/2016.
 */

public class User implements Serializable {

    private boolean is_liked;

    public boolean isLiked() {
        return is_liked;
    }

    public void setIsLiked(boolean is_liked) {
        this.is_liked = is_liked;
    }

}
