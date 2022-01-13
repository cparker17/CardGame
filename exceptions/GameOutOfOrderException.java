package com.cardgame.exceptions;

public class GameOutOfOrderException extends CardGameException {
    @Override
    public String toString() {
        return "The game you have selected is out of order at this time.  Please select again.";
    }
}
//