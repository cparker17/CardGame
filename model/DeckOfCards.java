package com.cardgame.model;

import java.util.ArrayList;
import java.util.Random;

public final class DeckOfCards {
    private static final String[] CARDFACES = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private static final char[] SUITS = {'\u2660', '\u2662', '\u2665', '\u2663'};
    private Card[] cardDeck;
    private ArrayList<Card> usedCards;

    public DeckOfCards() {
        cardDeck = new Card[52];
        usedCards = new ArrayList<>();

        //populate the card deck
        int i = 0;
        for (char suit : SUITS) {
            for (String cardFace : CARDFACES) {
                Card card = new Card(cardFace, suit);
                cardDeck[i++] = card;
            }
        }
    }

    public Card[] getCardDeck() {
        return cardDeck;
    }

    public ArrayList<Card> getUsedCards() {
        return usedCards;
    }

    public void setUsedCards(Card cardDealt) {
        usedCards.add(cardDealt);
    }
}


