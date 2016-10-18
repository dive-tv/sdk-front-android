package com.touchvie.backend.carddetail.containers;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class Synchro {
    private boolean is_synchronizable;
    private ArrayList<String> audio_langs;
    private ArrayList<TvEvent> channels;

    public boolean isSynchronizable() {
        return is_synchronizable;
    }

    public void setIsSynchronizable(boolean is_synchronizable) {
        this.is_synchronizable = is_synchronizable;
    }

    public ArrayList<String> getAudioLangs() {
        return audio_langs;
    }

    public void setAudioLangs(ArrayList<String> audio_langs) {
        this.audio_langs = audio_langs;
    }

    public ArrayList<TvEvent> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<TvEvent> channels) {
        this.channels = channels;
    }
}
