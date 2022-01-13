package com.cardgame.controller;

import com.cardgame.exceptions.CardGameException;
import com.cardgame.exceptions.GameOutOfOrderException;
import com.cardgame.exceptions.InputOutOfBoundsException;
import com.cardgame.exceptions.MenuSelectionOutOfBoundsException;
import com.cardgame.service.CardGameService;
import com.cardgame.view.CardGameView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CardGameController {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //set up contact with service and view
        CardGameService cardGameService = new CardGameService();
        CardGameView cardGameView = new CardGameView();

        //engage with user to select type of card game to play
        int menuOption = 0;
        do {
            //connect with view to display menu
            cardGameView.displayCardGameMenu();
            menuOption = input.nextInt();
            if (menuOption == 3) {
                break;
            }
            try {
                //connect with service to set up card game
                cardGameService.setCardGame(menuOption);

                //connect with view to display user's selection
                cardGameView.displayCardGameSelection(menuOption);

                //connect with view to display request to user for number of players
                cardGameView.displayNumPlayersRequest();

                //connect with service to set the number of players
                cardGameService.setNumPlayers(input.nextInt());

                //loop to add the player's names
                for(int i = 0; i < cardGameService.getNumPlayers(); i++) {
                    cardGameView.displayPlayerNameRequest(i+1);
                    cardGameService.addPlayer(input.next());
                }

                //add Dealer to the list of players
                cardGameService.addPlayer("Dealer");

                //set up player's numbers
                cardGameService.getCardGame().setPlayerNumbers();

                //determine if user wants to place bets
                cardGameView.displayGamblingOptionMenu();
                cardGameService.setIsGambling(input.nextInt());
                if (cardGameService.getIsGambling()) {
                    cardGameView.displayGamblingSelection(1);
                    cardGameService.setInitialPotValue(input.nextInt());
                } else {
                    cardGameService.getCardGame().setPlayerNumbers();
                    cardGameView.displayGamblingSelection(2);
                }

                //run the game selected by the user
                boolean continueLoop = true;
                do {
                    cardGameService.dealHand();
                    cardGameView.displayHandWinner(cardGameService.getCardGame());

                    //collect players' cards and reset the deck
                    cardGameService.resetHandsAndDeck();

                    //ask user if they want to play another hand
                    cardGameView.displayNextHandMenu();
                    if (input.nextInt() == 2) {
                        continueLoop = false;
                    }
                } while (continueLoop);

                //display the scoreboard
                cardGameView.displayScoreBoard(cardGameService.getCardGame());
            } catch (CardGameException e) {
                System.out.println(e.toString());
            }
        } while(menuOption == 1 || menuOption == 2);

        //display end of game notice
        cardGameView.displayGameOver();
    }
}
