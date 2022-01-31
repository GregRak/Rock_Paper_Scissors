package com.kodilla.rpsfx;

import java.io.Serializable;

public class Game implements Serializable {
    private int numberOfPlayerWins;
    private int numberOfComputerWins;
    private int numberOfRounds;
    private String playerName;
    private int numberOfWinsToEnd;
    String result = "";

    public Game(int numberOfPlayerWins, int numberOfComputerWins, int numberOfRounds, String playerName, int numberOfWinsToEnd) {
        this.numberOfPlayerWins = numberOfPlayerWins;
        this.numberOfComputerWins = numberOfComputerWins;
        this.numberOfRounds = numberOfRounds;
        this.playerName = playerName;
        this.numberOfWinsToEnd = numberOfWinsToEnd;
    }

    public void setNumberOfPlayerWins(int numberOfPlayerWins) {
        this.numberOfPlayerWins = numberOfPlayerWins;
    }

    public void setNumberOfComputerWins(int numberOfComputerWins) {
        this.numberOfComputerWins = numberOfComputerWins;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setNumberOfWinsToEnd(int numberOfWinsToEnd) {
        this.numberOfWinsToEnd = numberOfWinsToEnd;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getNumberOfPlayerWins() {
        return numberOfPlayerWins;
    }

    public int getNumberOfComputerWins() {
        return numberOfComputerWins;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getNumberOfWinsToEnd() {
        return numberOfWinsToEnd;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public String numberOfPlayerWinsToString() {
        return String.valueOf(this.numberOfPlayerWins);
    }

    public String numberOfComputerWinsToString() {
        return String.valueOf(numberOfComputerWins);
    }

    public String numberOfRoundsToString() {
        return String.valueOf(numberOfRounds);
    }

    public String gamePlay(int playerPlay, int computerPlay) {
            if (playerPlay == computerPlay) {
                this.numberOfRounds++;
                result = "   Draw!!!";
            } else if (playerPlay == 1 && computerPlay == 3 || playerPlay == 2 && computerPlay == 1 || playerPlay == 3 && computerPlay == 2) {
                this.numberOfRounds++;
                this.numberOfPlayerWins++;
                result = "  You win!!!";
            } else {
                this.numberOfComputerWins++;
                this.numberOfRounds++;
                result = " You lose!!!";
            }
        return result;
    }
}
