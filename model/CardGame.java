package com.cardgame.model;

import com.cardgame.exceptions.GameOutOfOrderException;
import com.cardgame.exceptions.InputOutOfBoundsException;
import com.cardgame.exceptions.MenuSelectionOutOfBoundsException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class CardGame {
    private final DeckOfCards cardDeck;
    private CardGameModel cardGameModel;
    private String name;
    private ArrayList<CardPlayer> players;
    private CardPlayer handWinner;

    public CardGame() {
        cardDeck = new DeckOfCards();
        players = new ArrayList<CardPlayer>();

    }

    public DeckOfCards getCardDeck() {
        return cardDeck;
    }

    public CardGameModel getCardGameModel() {
        return cardGameModel;
    }

    public void setCardGameModel(CardGameModel cardGameModel) {
        this.cardGameModel = cardGameModel;
    }

    public int getNumPlayers() {
        return cardGameModel.getNumPlayers();
    }

    public void setNumPlayers(int numPlayers) {
        cardGameModel.setNumPlayers(numPlayers);
    }

    public void addPlayer(String playerName) {
        CardPlayer player = new CardPlayer(playerName);
        players.add(player);
    }

    public void setPlayerNumbers() {
        for(int i = 0; i < players.size(); i++) {
            players.get(i).setPlayerNumber(i+1);
        }
    }

    public ArrayList<CardPlayer> getPlayers() {
        return players;
    }

    public CardPlayer getHandWinner() {
        return handWinner;
    }

    public void setHandWinner(CardPlayer cardPlayer) {
        this.handWinner = cardPlayer;
    }
}
