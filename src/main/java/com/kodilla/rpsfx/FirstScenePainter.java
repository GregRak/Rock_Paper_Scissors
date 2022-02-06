package com.kodilla.rpsfx;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Map;

public class FirstScenePainter {

    private static final Label TITLE_LABEL = new Label("Paper Rock Scissors");
    private static final Label ENTER_NAME = new Label("Enter your Name (max. 8 chars)");
    private static final Label NUMBER_OF_ROUNDS_CHOICE = new Label("Choose the number of wins");
    private Game game = new Game(0, 0, 0, "", 0);
    private final BackGrounds backGrounds = new BackGrounds();
    private final QuitConfirmation quitConfirmation = new QuitConfirmation();
    private final TextField textField = new TextField();

    public boolean getPlayerName() {
        String playerName = textField.getText();
        if (playerName.isEmpty()) {
            textField.setPromptText("Enter your name, please");
            return false;
        } else {
            if (playerName.length() > 8) {
                playerName = playerName.substring(0, 8);
            }
            game.setPlayerName(playerName);
            return true;
        }
    }

    public void gameSceneSetter(Stage primaryStage) {
        primaryStage.setScene(new GameScenePainter().paintGameScene(primaryStage, game));
        primaryStage.setTitle("Rock Paper Scissors");
        primaryStage.show();
    }

    public Scene paintFirstScene(Stage primaryStage){
        TITLE_LABEL.setFont(new Font("Arial", 25));
        TITLE_LABEL.setTextFill(Color.BLACK);

        GridPane firstSceneGrid = new GridPane();
        firstSceneGrid.setBackground(backGrounds.getGameBackground());
        firstSceneGrid.setAlignment(Pos.CENTER);

        Button oneWinBtn = new Button();
        oneWinBtn.setMinWidth(55);
        oneWinBtn.setText("1");
        oneWinBtn.setOnAction((event) -> {
            if (getPlayerName()) {
                game.setNumberOfWinsToEnd(1);
                gameSceneSetter(primaryStage);
            }
        });

        Button fiveWinBtn = new Button();
        fiveWinBtn.setMinWidth(55);
        fiveWinBtn.setText("5");
        fiveWinBtn.setOnAction((event) -> {
            if (getPlayerName()) {
                game.setNumberOfWinsToEnd(5);
                gameSceneSetter(primaryStage);
            }
        });

        Button tenWinBtn = new Button();
        tenWinBtn.setMinWidth(55);
        tenWinBtn.setText("10");
        tenWinBtn.setOnAction((event) -> {
            if (getPlayerName()) {
                game.setNumberOfWinsToEnd(10);
                gameSceneSetter(primaryStage);
            }
        });

        Button infinityBtn = new Button();
        infinityBtn.setMinWidth(55);
        infinityBtn.setText("No limit");
        infinityBtn.setOnAction((event) -> {
            if (getPlayerName()) {
                game.setNumberOfWinsToEnd(Integer.MAX_VALUE);
                gameSceneSetter(primaryStage);
            }
        });

        HBox numberOfRoundsButtonsBox = new HBox(3);
        numberOfRoundsButtonsBox.getChildren().addAll(oneWinBtn, fiveWinBtn, tenWinBtn, infinityBtn);

        Button exitBtn = new Button();
        exitBtn.setMinWidth(70);
        exitBtn.setText("Quit");
        exitBtn.setOnAction((event) -> quitConfirmation.quitAreYouSure());

        Button rulesBtn = new Button();
        rulesBtn.setMinWidth(70);
        rulesBtn.setText("Rules");
        Rules rules = new Rules();
        rulesBtn.setOnAction((event) -> rules.printRulesScene());

        Button loadBtn = new Button();
        loadBtn.setMinWidth(70);
        loadBtn.setText("Load");
        loadBtn.setOnAction((e) -> {
            SaveAndLoadGame saveAndLoadGame = new SaveAndLoadGame();
            saveAndLoadGame.loadGame();
            Map<Integer, Game> currentMap = saveAndLoadGame.map;
            for(Map.Entry<Integer, Game> entry:currentMap.entrySet()) {
                game.setNumberOfPlayerWins(entry.getValue().getNumberOfPlayerWins());
                game.setNumberOfComputerWins(entry.getValue().getNumberOfComputerWins());
                game.setNumberOfWinsToEnd(entry.getValue().getNumberOfWinsToEnd());
                game.setNumberOfRounds(entry.getValue().getNumberOfRounds());
                game.setPlayerName(entry.getValue().getPlayerName());
            }
            gameSceneSetter(primaryStage);
        });

        HBox functionalButtonsBox = new HBox(3);
        functionalButtonsBox.getChildren().addAll(rulesBtn, exitBtn, loadBtn);
        functionalButtonsBox.setAlignment(Pos.CENTER);

        //adding elements to the first scene grid
        firstSceneGrid.add(backGrounds.paperBack(), 0, 0);
        firstSceneGrid.add(backGrounds.rockBack(), 1, 0);
        firstSceneGrid.add(backGrounds.scissorsBack(), 2, 0);
        firstSceneGrid.add(TITLE_LABEL, 1, 1);
        firstSceneGrid.addRow(2, backGrounds.emptyPane()); //emptyPane size to modify
        firstSceneGrid.add(ENTER_NAME, 1, 3);
        firstSceneGrid.add(textField, 1, 4);
        firstSceneGrid.addRow(5, backGrounds.emptyPane());
        firstSceneGrid.add(NUMBER_OF_ROUNDS_CHOICE, 1, 6);
        firstSceneGrid.add(numberOfRoundsButtonsBox, 1, 7);
        firstSceneGrid.addRow(8, backGrounds.emptyPane());
        firstSceneGrid.add(functionalButtonsBox, 1, 9);

        Scene firstScene = new Scene(firstSceneGrid, 800, 450, Color.LIGHTBLUE);

        primaryStage.setScene(firstScene);
        primaryStage.setTitle("Rock Paper Scissors");
        primaryStage.show();
        return firstScene;
    }
}
