package com.cardgame.view;

import com.cardgame.exceptions.CardGameException;
import com.cardgame.exceptions.MenuSelectionOutOfBoundsException;
import com.cardgame.model.Card;
import com.cardgame.model.CardGame;
import com.cardgame.model.CardPlayer;
import com.cardgame.service.CardGameService;

import java.util.Scanner;

public class CardGameView {
    public void displayCardGameMenu() {
        System.out.println("Which card game would you like to play?");
        System.out.println("   1 - Blackjack\n   2 - Poker\n   3 - Quit");
        System.out.println("Enter Selection: ");
    }

    public void displayCardGameSelection(int menuOption) throws CardGameException {
        if (menuOption == 1) {
            System.out.println("Let's play some Blackjack!");
        } else if (menuOption == 2) {
            System.out.println("Let's play some Poker!");
        } else if (menuOption == 3) {
            System.out.println("Thank you for playing!!!");
        } else {
            throw new MenuSelectionOutOfBoundsException();
        }
    }

    public void displayNumPlayersRequest() {
        System.out.println("Please enter the number of players between 1 and 4 that will participate in the game: ");
    }

    public void displayGamblingOptionMenu() {
        System.out.println("Will you be gambling or just keeping score?");
        System.out.println("   1 - Gambling\n   2 - Just Keeping Score\n   3 - Quit");
        System.out.println("Enter Selection: ");
    }

    public void displayGamblingSelection(int menuOption) {
        if (menuOption == 1) {
            System.out.println("Let's place some bets!");
            System.out.println("Please enter your buy in amount: ");
        } else {
            System.out.println("No betting.  Let's keep score.");
        }
    }

    public void displayPlayerNameRequest(int playerNumber) {
        System.out.println("Please enter the name for Player #" + playerNumber);
    }

    public void displayHandWinner(CardGame cardGame) {
        if(cardGame.getHandWinner() != null) {
            System.out.println("The winner of the hand is " + cardGame.getHandWinner().getName() + "!");
        } else {
            System.out.println("Everyone busts!  No Winner!");
        }
    }
    public void displayScoreBoard(CardGame cardGame) {
        System.out.println("*******************************************");
        System.out.println("               SCOREBOARD:                 ");
        for(int i = 0; i < cardGame.getPlayers().size(); i++) {
            System.out.println("   Player#" + cardGame.getPlayers().get(i).getPlayerNumber() + " -- "
                    + cardGame.getPlayers().get(i).getName() + ": " + cardGame.getPlayers().get(i).getGamesWon());
        }
        System.out.println("*******************************************");
    }

    public void displayNextHandMenu() {
        System.out.println("**********************************************");
        System.out.println("*    Would you like to play another hand?    *");
        System.out.println("*        1 - Yes                             *");
        System.out.println("*        2 - No                              *");
        System.out.println("**********************************************");
    }

    public void displayGameOver() {
        System.out.println("Thank you for playing.  See you next time!");
    }
}
