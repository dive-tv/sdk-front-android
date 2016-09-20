package com.touchvie.touchvie_front.ui.listeners;

import android.os.Parcelable;

/**
 * Created by Tagsonomy S.L. on 20/09/2016.
 */
public interface CardDetailListener extends Parcelable {

    /**
     * Interface to go to a determined section through navigation modules
     *
     * @param sectionName
     */
    void goToSection(String sectionName);
}
