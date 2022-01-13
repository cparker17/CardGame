package com.cardgame.model;

import java.util.HashMap;

public final class Card {
    private String cardFace;
    private char suit;
    private HashMap<String, Integer> cardValues;

    public Card(String cardFace, char suit) {
        this.cardFace = cardFace;
        this.suit = suit;

        //set up face values of each type of card
        cardValues = new HashMap<>();
        cardValues.put("Ace", 1);
        cardValues.put("Two", 2);
        cardValues.put("Three", 3);
        cardValues.put("Four", 4);
        cardValues.put("Five", 5);
        cardValues.put("Six", 6);
        cardValues.put("Seven", 7);
        cardValues.put("Eight", 8);
        cardValues.put("Nine", 9);
        cardValues.put("Ten", 10);
        cardValues.put("Jack", 10);
        cardValues.put("Queen", 10);
        cardValues.put("King", 10);
    }

    public String getCardFace() {
        return cardFace;
    }

    public void setCardFace(String cardFace) {
        this.cardFace = cardFace;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public int getCardValue() {
        return cardValues.get(cardFace);
    }

}
