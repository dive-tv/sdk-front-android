package com.touchvie.backend.carddetail.containers;

import com.touchvie.backend.carddetail.ImageData;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class Image extends ContainerData {
    private ImageData image;

    public ImageData getImage() {
        return image;
    }

    public void setImage(ImageData image) {
        this.image = image;
    }
}
