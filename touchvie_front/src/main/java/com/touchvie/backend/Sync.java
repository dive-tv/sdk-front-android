package com.touchvie.backend;

/**
 * Created by Tagsonomy S.L. on 10/10/2016.
 */

public class Sync {

    boolean is_interactive;
    String[] audio_langs;
    Channel [] channels;

    public boolean isInteractive() {
        return is_interactive;
    }

    public void setIsInteractive(boolean is_interactive) {
        this.is_interactive = is_interactive;
    }

    public String[] getAudioLangs() {
        return audio_langs;
    }

    public void setAudioLangs(String[] audio_langs) {
        this.audio_langs = audio_langs;
    }

    public Channel[] getChannels() {
        return channels;
    }

    public void setChannels(Channel[] channels) {
        this.channels = channels;
    }
}
