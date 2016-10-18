package com.touchvie.backend.carddetail.containers;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class Map extends ContainerData {
    private float latitude;
    private float longitude;
    private float zoom;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }
}
