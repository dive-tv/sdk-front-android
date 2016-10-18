package com.touchvie.backend.carddetail.containers;

import com.touchvie.backend.carddetail.Source;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class Link extends ContainerData {
    private String url;
    private Source source;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
