package com.cardgame.model;

import java.util.ArrayList;

public class CardPlayer {
    private String name;
    private int playerNumber;
    private boolean isBust;
    private int initialPotValue;
    private int potValue;
    private int currentBet;
    private ArrayList<Card> cardsInHand;
    private int handValue;
    private int gamesWon;

    public CardPlayer(String name) {
        cardsInHand = new ArrayList<>();
        this.name = name;
        isBust = false;
        handValue = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public boolean isBust() {
        return isBust;
    }

    public void setBust(boolean isBust) {
        this.isBust = isBust;
    }

    //betting portion of the game is not implemented yet
    public int getInitialPotValue() {
        return initialPotValue;
    }

    //betting portion of the game is not implemented yet
    public void setInitialPotValue(int initialPotValue) {
        this.initialPotValue = initialPotValue;
    }

    //betting portion of the game is not implemented yet
    public int getPotValue() {
        return potValue;
    }

    //betting portion of the game is not implemented yet
    public void setPotValue(int potValue) {
        this.potValue = potValue;
    }

    //betting portion of the game is not implemented yet
    public int getCurrentBet() {
        return currentBet;
    }

    //betting portion of the game is not implemented yet
    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    public void addCardToHand(Card card) {
        cardsInHand.add(card);
    }

    public int getHandValue() {
        handValue = 0;
        for(Card card : cardsInHand) {
            handValue += card.getCardValue();
        }

        return handValue;
    }

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void printHand() {
        System.out.println("Player #" + getPlayerNumber() + ":");
        System.out.println(getName() + "'s hand includes:");
        for(Card card : cardsInHand) {
            System.out.print(card.getCardFace());
            System.out.print(card.getSuit() + "  ");
        }
        System.out.println("Score: " + getHandValue());
    }

    public boolean isHandOver21() {
        if(getHandValue() > 21) {
            return true;
        } else {
            return false;
        }
    }
    public int getGamesWon() {
        return gamesWon;
    }

    public void addGameWon() {
        gamesWon++;
    }

}
