package com.cardgame.service;

import com.cardgame.exceptions.*;
import com.cardgame.model.BlackJackGame;
import com.cardgame.model.CardGame;
import com.cardgame.model.CardPlayer;

public class CardGameService {
    private CardGame cardGame;
    private CardGameServiceModel cardGameServiceModel;

    public CardGameService() {
        cardGame = new CardGame();
    }

    public CardGame getCardGame() {
        return cardGame;
    }

    public void setCardGame(int menuOption) throws GameOutOfOrderException {
        if (menuOption == 1) {
            cardGame.setCardGameModel(new BlackJackGame());
            cardGameServiceModel = new BlackJackGameService();
        } else if (menuOption == 2) {
            throw new GameOutOfOrderException();
        }
    }

    public int getNumPlayers() {
        return cardGame.getNumPlayers();
    }
    public void setNumPlayers(int numPlayers) throws InputOutOfBoundsException {
        boolean continueLoop = true;

        while (continueLoop) {
            if (numPlayers < 1 || numPlayers > 4) {
                throw new InputOutOfBoundsException();
            } else {
                cardGame.setNumPlayers(numPlayers);
                continueLoop = false;
            }
        }
    }

    public void addPlayer(String playerName) {
        cardGame.addPlayer(playerName);
    }

    public boolean getIsGambling() {
        return cardGame.getCardGameModel().getIsGambling();
    }

    public void setIsGambling(int menuOption) throws CardGameException {
        switch (menuOption) {
            case 1:
                cardGame.getCardGameModel().setIsGambling(false);
                throw new BettingNotSetUpException();
            case 2:
                cardGame.getCardGameModel().setIsGambling(false);
                break;
            case 3:
                System.exit(1);
            default:
                throw new MenuSelectionOutOfBoundsException();
        }
    }

    public int getInitialPotValue() {
        return cardGame.getCardGameModel().getInitialPotValue();
    }

    public void setInitialPotValue(int initialPotValue) {
        cardGame.getCardGameModel().setInitialPotValue(initialPotValue);
    }

    public void dealHand() {
        cardGameServiceModel.dealHand(cardGame);
    }

    public void setHandWinner() {
        cardGameServiceModel.setHandWinner(cardGame, cardGame.getCardGameModel().getPlayersUnder21());
    }

    public void resetHandsAndDeck() {
        //collect cards back from each player
        for (CardPlayer player : cardGame.getPlayers()) {
            player.getCardsInHand().clear();
        }

        //reset the deck by removing all cards in the used cards ArrayList
        cardGame.getCardDeck().getUsedCards().clear();
    }
}
