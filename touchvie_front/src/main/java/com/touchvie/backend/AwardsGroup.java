package com.touchvie.backend;

/**
 * Created by Tagsonomy S.L. on 11/10/2016.
 */

public class AwardsGroup {

        String title;
        Award[] nominee;
        Award[] winner;

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public Award[] getNominee() {
                return nominee;
        }

        public void setNominee(Award[] nominee) {
                this.nominee = nominee;
        }

        public Award[] getWinner() {
                return winner;
        }

        public void setWinner(Award[] winner) {
                this.winner = winner;
        }


}
