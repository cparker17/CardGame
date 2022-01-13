package com.cardgame.service;

import com.cardgame.model.Card;
import com.cardgame.model.CardGame;
import com.cardgame.model.CardPlayer;
import com.cardgame.model.DeckOfCards;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJackGameService implements CardGameServiceModel {
    public void dealHand(CardGame cardGame) {
        //deal 2 cards to each player to start the game
        for (CardPlayer player : cardGame.getPlayers()) {
            dealCard(cardGame.getCardDeck(), player);
            dealCard(cardGame.getCardDeck(), player);
        }

        //loop through each player except dealer to see if they want more cards
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < cardGame.getPlayers().size() - 1; i++) {
            int menuSelection = 0;
            do {
                cardGame.getPlayers().get(i).printHand();
                System.out.println("Do you want another card?");
                System.out.print("     Press 1 for yes and 2 for no: ");
                menuSelection = input.nextInt();
                if (menuSelection == 1) {
                    dealCard(cardGame.getCardDeck(), cardGame.getPlayers().get(i));
                } else {
                    System.out.println(cardGame.getPlayers().get(i).getName() + " holds.");
                }
                if (cardGame.getPlayers().get(i).isHandOver21()) {
                    cardGame.getPlayers().get(i).printHand();
                    System.out.println(cardGame.getPlayers().get(i).getHandValue() + "...Bust!");
                    int dealerIndex = cardGame.getPlayers().size() - 1;
                    cardGame.getPlayers().get(dealerIndex).addGameWon();
                    cardGame.getPlayers().get(i).setBust(true);
                    menuSelection = -1;
                }
            } while (menuSelection == 1);
        }

        //determine how many players are busted
        int playersBusted = 0;
        for (int i = 0; i < cardGame.getPlayers().size() - 1; i++) {
            if (cardGame.getPlayers().get(i).isHandOver21()) {
                playersBusted++;
            }
        }

        //loop through dealing Dealer a card if at least one player isn't bust
        if (playersBusted != cardGame.getPlayers().size() - 1) {
            int dealerIndex = cardGame.getPlayers().size() - 1;
            int dealerHandValue = cardGame.getPlayers().get(dealerIndex).getHandValue();
            cardGame.getPlayers().get(dealerIndex).printHand();
            boolean continueLoop = true;

            do {
                //dealer holds if their hand value is between 16 or 21
                if (dealerHandValue >= 16 && dealerHandValue <= 21) {
                    System.out.println("Dealer holds.");
                    continueLoop = false;
                } else if (dealerHandValue < 16) {
                    dealCard(cardGame.getCardDeck(), cardGame.getPlayers().get(dealerIndex));
                    System.out.println("Dealer takes a card.");
                    dealerHandValue = cardGame.getPlayers().get(dealerIndex).getHandValue();
                    cardGame.getPlayers().get(dealerIndex).printHand();
                } else  {
                    System.out.println("Dealer busts!!!");
                    cardGame.getPlayers().get(dealerIndex).setBust(true);
                    continueLoop = false;
                }
            } while(continueLoop);

            setPlayersUnder21(cardGame, cardGame.getPlayers());
            setHandWinner(cardGame, cardGame.getCardGameModel().getPlayersUnder21());
            //sortPlayersUnder21ByScore(cardGame.getCardGameModel().getPlayersUnder21());
            //cardGame.setHandWinner(cardGame.getCardGameModel().getPlayersUnder21().get(0));

        } else {
            //if all players except dealer are bust then set Dealer as handWinner
            cardGame.setHandWinner(cardGame.getPlayers().get(cardGame.getPlayers().size()-1));
        }
    }

    public void dealCard(DeckOfCards cardDeck, CardPlayer player) {
        Random randomNumber = new Random();
        Card cardDealt;
        if(cardDeck.getUsedCards().size() == 0) {
            cardDealt = cardDeck.getCardDeck()[randomNumber.nextInt(51)];
            cardDeck.getUsedCards().add(cardDealt);
            player.addCardToHand(cardDealt);
        } else {
            do {
                cardDealt = cardDeck.getCardDeck()[randomNumber.nextInt(51)];
                for (Card usedCard : cardDeck.getUsedCards()) {
                    if (cardDealt == usedCard) {
                        cardDealt = null;
                        break;
                    }
                }
            } while (cardDealt == null);
            player.addCardToHand(cardDealt);
            cardDeck.setUsedCards(cardDealt);
        }
    }
    public void setPlayersUnder21(CardGame cardGame, ArrayList<CardPlayer> players) {
        ArrayList<CardPlayer> playersUnder21 = new ArrayList<>();
        for (CardPlayer player : players) {
            if (!player.isHandOver21()) {
                playersUnder21.add(player);
            }
        }
        cardGame.getCardGameModel().setPlayersUnder21(playersUnder21);
    }

    public void sortPlayersUnder21ByScore(ArrayList<CardPlayer> playersUnder21) {
        CardPlayer temp;

        for (int i = 0; i < playersUnder21.size(); i++) {
            for (int j = i + 1; j < playersUnder21.size(); j++) {
                if (playersUnder21.get(i).getHandValue() < playersUnder21.get(j).getHandValue()) {
                    temp = playersUnder21.get(j);
                    playersUnder21.set(j, playersUnder21.get(i));
                    playersUnder21.set(i, temp);
                }
            }
        }
    }

    public void setHandWinner(CardGame cardGame, ArrayList<CardPlayer> playersUnder21) {
        sortPlayersUnder21ByScore(playersUnder21);

        if(playersUnder21.size() > 1) {
            if(playersUnder21.get(0).getHandValue() == playersUnder21.get(1).getHandValue()) {
                cardGame.setHandWinner(null);
                System.out.println("Tie game.  No winner.");
            } else {
                cardGame.setHandWinner(playersUnder21.get(0));
                playersUnder21.get(0).addGameWon();
            }
        } else if (playersUnder21.size() == 1) {
            cardGame.setHandWinner(playersUnder21.get(0));
            playersUnder21.get(0).addGameWon();
        } else {
            cardGame.setHandWinner(null);
        }
    }
}
