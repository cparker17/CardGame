package com.cardgame.model;

import com.cardgame.exceptions.MenuSelectionOutOfBoundsException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackGame implements CardGameModel {
    private int numPlayers;
    private boolean isGambling;
    private int initialPotValue;
    private int potValue;
    private int currentBet;
    private ArrayList<CardPlayer> playersUnder21;

    public BlackJackGame() {
        playersUnder21 = new ArrayList<>();
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public boolean getIsGambling() {
        return isGambling;
    }

    public void setIsGambling(boolean isGambling) {
        this.isGambling = isGambling;
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
    public void setCurrentBet(int bet) {
        currentBet = bet;
    }

    public ArrayList<CardPlayer> getPlayersUnder21() {
        return playersUnder21;
    }

    public void setPlayersUnder21(ArrayList<CardPlayer> playersUnder21) {
        this.playersUnder21 = playersUnder21;
    }
}