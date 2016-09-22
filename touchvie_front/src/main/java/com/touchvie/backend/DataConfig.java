package com.touchvie.backend;

import com.touchvie.touchvie_front.builders.ConfigSection;

import java.io.Serializable;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class DataConfig implements Serializable {
    ConfigSection[] sections;

    public ConfigSection[] getSections() {
        return sections;
    }

    public void setSections(ConfigSection[] sections) {
        this.sections = sections;
    }

}
