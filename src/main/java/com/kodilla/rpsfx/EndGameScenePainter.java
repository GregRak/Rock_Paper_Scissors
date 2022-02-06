package com.kodilla.rpsfx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EndGameScenePainter {

    private final BackGrounds backGrounds = new BackGrounds();
    private final Label endGameResult = new Label();
    private final QuitConfirmation quitConfirmation = new QuitConfirmation();
    private final Label playerResult = new Label();
    private final Label computerResult = new Label();

    public void endGame(Stage endStage, Game game) {
        GridPane endGameGrid = new GridPane();
        endGameGrid.setBackground(backGrounds.getGameBackground());
        endGameGrid.setAlignment(Pos.CENTER);

        endGameResult.setFont(new Font("Arial", 20));
        endGameResult.setTextFill(Color.YELLOW);
        endGameResult.setAlignment(Pos.CENTER);
        if(game.getNumberOfPlayerWins() > game.getNumberOfComputerWins()){
            endGameResult.setText("     Congratulations!!!\n           You win!!!");
        } else {
            endGameResult.setText("        You loose!!!\n          Try again!");
        }

        playerResult.setFont(new Font("Arial", 20));
        playerResult.setTextFill(Color.YELLOW);
        playerResult.setMinWidth(23);
        playerResult.setText(game.numberOfPlayerWinsToString());

        computerResult.setFont(new Font("Arial", 20));
        computerResult.setTextFill(Color.YELLOW);
        computerResult.setMinWidth(23);
        computerResult.setAlignment(Pos.CENTER_RIGHT);
        computerResult.setText(game.numberOfComputerWinsToString());

        //Buttons
        Button endNewGameBtn = new Button();
        endNewGameBtn.setText("New game");
        endNewGameBtn.setMinWidth(70);
        endNewGameBtn.setOnAction((event) -> {
            FirstScenePainter firstScenePainter = new FirstScenePainter();
            endStage.setScene(firstScenePainter.paintFirstScene(endStage));
            endStage.setTitle("Rock Paper Scissors");
            endStage.show();
        });

        Button endQuitGameBtn = new Button();
        endQuitGameBtn.setText("Quit");
        endQuitGameBtn.setMinWidth(70);
        endQuitGameBtn.setOnAction((event) -> quitConfirmation.quitAreYouSure());

        //Box with buttons
        HBox endButtonsBox = new HBox(10);
        endButtonsBox.setAlignment(Pos.CENTER);
        endButtonsBox.getChildren().addAll(endNewGameBtn, endQuitGameBtn);

        //adding elements to the end scene grid
        endGameGrid.add(endGameResult, 2, 0);
        endGameGrid.add(playerResult, 1, 0);
        endGameGrid.add(computerResult, 3, 0);
        endGameGrid.add(backGrounds.emptyPane(), 2, 1);
        endGameGrid.add(backGrounds.paperBack(), 0, 2);
        endGameGrid.add(backGrounds.rockBack(), 2, 2);
        endGameGrid.add(backGrounds.scissorsBack(), 4, 2);
        endGameGrid.add(endButtonsBox, 2, 4);

        Scene endGameScene = new Scene(endGameGrid, 800, 450, Color.LIGHTBLUE);
        endStage.setScene(endGameScene);
        endStage.setTitle("Rock Paper Scissors");
        endStage.show();
    }
}
