package com.cardgame.exceptions;

import com.cardgame.model.Card;

public class BettingNotSetUpException extends CardGameException {
    @Override
    public String toString() {
        return "Betting is not set up yet.  Game will proceed without betting.";
    }
}
