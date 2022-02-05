package com.kodilla.rpsfx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Rules {

    final BackGrounds backGrounds = new BackGrounds();

    public static String rulesPrinter() {
        return "Now we will introduce you to the rules of the game:" +
                "\n- this is a game for two players," +
                "\n- you are playing against the computer.\n" +
                "\nA game round is where both players play one of the moves simultaneously, i.e. stone, paper \nor scissors.\n" +
                "\nRound result:" +
                "\n- there is a draw when both players play the same move," +
                "\n- victory occurs when the beating opponent's move is made, according to the pattern:" +
                "\n    + the stone crushes the scissors," +
                "\n    + scissors cut paper," +
                "\n    + the paper covers the stone.\n" +
                "\nAfter the end of a round, the next round begins until the set number of rounds has been won \nby one of the players.";
    }

    public void printRulesScene() {
        Stage rulesStage = new Stage();
        Pane rulesPane = new Pane();
        rulesPane.setBackground(backGrounds.getGameBackground());

        Label rulesLabel = new Label();
        rulesLabel.setFont(new Font("Arial", 15));
        rulesLabel.setTextFill(Color.BLACK);
        rulesLabel.setText(rulesPrinter());

        Button backBtn = new Button();
        backBtn.setText("Back");
        backBtn.setMinWidth(70);
        backBtn.setOnAction((event) -> rulesStage.close());

        VBox rulesBox = new VBox(10);
        rulesBox.setAlignment(Pos.CENTER);
        rulesBox.getChildren().addAll(rulesLabel, backBtn);
        rulesPane.getChildren().add(rulesBox);

        Scene rulesScene = new Scene(rulesPane, 650, 365, Color.LIGHTBLUE);
        rulesStage.setScene(rulesScene);
        rulesStage.setTitle("Rock Paper Scissors");
        rulesStage.setAlwaysOnTop(true);
        rulesStage.initModality(Modality.APPLICATION_MODAL);
        rulesStage.show();
    }
}
