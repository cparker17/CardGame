package com.cardgame.exceptions;

public class MenuSelectionOutOfBoundsException extends CardGameException {
    @Override
    public String toString() {
        return "Menu Selection Out of Bounds. Please try again.";
    }
}
//