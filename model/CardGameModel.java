package com.cardgame.model;

import java.util.ArrayList;

public interface CardGameModel {
    boolean getIsGambling();
    void setIsGambling(boolean isGambling);
    int getInitialPotValue();
    ArrayList<CardPlayer> getPlayersUnder21();
    void setPlayersUnder21(ArrayList<CardPlayer> playersUnder21);
    int getNumPlayers();
    void setNumPlayers(int numPlayers);
    void setInitialPotValue(int initialPotValue);
}
