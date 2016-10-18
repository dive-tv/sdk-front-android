package com.touchvie.backend.carddetail.containers;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class Awards extends ContainerData {
    private String title;
    private price nominee;
    private price winner;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public price getNominee() {
        return nominee;
    }

    public void setNominee(price nominee) {
        this.nominee = nominee;
    }

    public price getWinner() {
        return winner;
    }

    public void setWinner(price winner) {
        this.winner = winner;
    }
}
