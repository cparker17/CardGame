package com.cardgame.service;

import com.cardgame.model.CardGame;
import com.cardgame.model.CardPlayer;

import java.util.ArrayList;

public interface CardGameServiceModel {
    void dealHand(CardGame cardGame);
    void setPlayersUnder21(CardGame cardGame, ArrayList<CardPlayer> players);
    void setHandWinner(CardGame cardGame, ArrayList<CardPlayer> playersUnder21);
}
