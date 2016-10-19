package com.touchvie.backend.carddetail.containers;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class Awards extends ContainerData {
    private String title;
    private Price[] nominee;
    private Price[] winner;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Price[] getNominee() {
        return nominee;
    }

    public void setNominee(Price[] nominee) {
        this.nominee = nominee;
    }

    public Price[] getWinner() {
        return winner;
    }

    public void setWinner(Price[] winner) {
        this.winner = winner;
    }
}
