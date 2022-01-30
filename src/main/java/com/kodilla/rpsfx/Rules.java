package com.kodilla.rpsfx;

public class Rules {
    public static String rulesPrinter() {
        String rulesText = "Now we will introduce you to the rules of the game:" +
                "\n- this is a game for two players," +
                "\n- you are playing against the computer.\n" +
                "\nA game round is where both players play one of the moves simultaneously, i.e. stone, paper or scissors.\n" +
                "\nRound result:" +
                "\n- there is a draw when both players play the same move," +
                "\n- victory occurs when the beating opponent's move is made, according to the pattern:" +
                "\n    + the stone crushes the scissors," +
                "\n    + scissors cut paper," +
                "\n    + the paper covers the stone.\n" +
                "\nAfter the end of a round, the next round begins until the set number of rounds has been won by one of the players.";
        return rulesText;
    }
}
