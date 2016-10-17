package com.touchvie.backend.carddetail.containers;

import com.touchvie.backend.MiniCard;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class TvEvent {
    private String channel_id;
    private String channel_name;
    private int start_data;
    private MiniCard card;
    private int alarm_minutes_before;

    public String getChannelId() {
        return channel_id;
    }

    public void setChannelId(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannelName() {
        return channel_name;
    }

    public void setChannelName(String channel_name) {
        this.channel_name = channel_name;
    }

    public int getStartData() {
        return start_data;
    }

    public void setStartData(int start_data) {
        this.start_data = start_data;
    }

    public MiniCard getCard() {
        return card;
    }

    public void setCard(MiniCard card) {
        this.card = card;
    }

    public int getAlarMinutesBefore() {
        return alarm_minutes_before;
    }

    public void setAlarmMinutesBefore(int alarm_minutes_before) {
        this.alarm_minutes_before = alarm_minutes_before;
    }
}
