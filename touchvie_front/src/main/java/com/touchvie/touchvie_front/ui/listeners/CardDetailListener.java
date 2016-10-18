package com.touchvie.touchvie_front.ui.listeners;

import android.os.Parcelable;
import android.support.v4.app.FragmentManager;

import com.touchvie.touchvie_client.interfaces.OauthObjectInterface;
import com.touchvie.touchvie_front.ui.fragments.Section;

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

    /**
     * Go to a different Card Detail
     *
     * @param cardId
     */
    void goToNewCard(String cardId, OauthObjectInterface auth);

    /**
     * Request a new Section to Card Detail, to put it in our view pager
     *
     * @param sectionName
     * @return the newly created Section
     */
    Section requestSectionForTab(String sectionName);

    /**
     * Request the text of the Section, used in the Tab Module
     *
     * @param sectionName
     * @return the text of the Sectoin
     */
    String requestSectionTitleForTab(String sectionName);

    /**
     * Request the fragment manager, used inside viewpager's adapter.
     *
     * @return the fragment manager
     */
    FragmentManager requestFragmentManager();

}
