package com.kodilla.rpsfx;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class GameScenePainter {
    private final FirstScenePainter firstScenePainter = new FirstScenePainter();
    private final Label playerLabel = new Label();
    private static final Label COMPUTER_LABEL = new Label("Computer");
    private static final Label RESULT = new Label("Result");
    private final Label playerResult = new Label();
    private final Label computerResult = new Label();
    private Label numberOfRoundLabel = new Label("Round: 0");
    private final Label resultPrintOut = new Label();
    private final ImageView playerAvatar = new ImageView("file:src/main/resources/face_2.png");
    private final ImageView computerAvatar = new ImageView("file:src/main/resources/computer_2.png");
    private final Pane computerPane = new Pane();
    private final Pane playerPane = new Pane();
    private final Random generator = new Random();
    private final DisplayOfChoices displayOfChoices = new DisplayOfChoices();
    private final BackGrounds backGrounds = new BackGrounds();
    private final QuitConfirmation quitConfirmation = new QuitConfirmation();
    private int computerPlay;
    private int playerPlay;

    public void computerPlay() {
        this.computerPlay = (generator.nextInt(3)) + 1;
    }

    public void computerPlayPrinter() {
        if (computerPlay == 1) {
            try {
                computerPane.setBackground(displayOfChoices.rockDisplay());
            } catch(Exception e) {
                Label rockExceptionLabel = new Label("File: rock.png not found");
                computerPane.getChildren().add(rockExceptionLabel);
            }
        } else if (computerPlay == 2) {
            try {
                computerPane.setBackground(displayOfChoices.paperDisplay());
            } catch(Exception e) {
                Label paperExceptionLabel = new Label("File: paper.png not found");
                computerPane.getChildren().add(paperExceptionLabel);
            }
        } else {
            try {
                computerPane.setBackground(displayOfChoices.scissorsDisplay());
            } catch(Exception e) {
                Label scissorsExceptionLabel = new Label("File: scissors.png not found");
                computerPane.getChildren().add(scissorsExceptionLabel);
            }
        }
    }

    public void resultsReset(Game game) {
        game.setNumberOfPlayerWins(0);
        game.setNumberOfComputerWins(0);
        game.setNumberOfRounds(0);
        playerResult.setText(game.numberOfPlayerWinsToString());
        computerResult.setText(game.numberOfComputerWinsToString());
        numberOfRoundLabel.setText("Round: " + game.numberOfRoundsToString());
        playerPane.setBackground(backGrounds.choosePane());
        computerPane.setBackground(backGrounds.computerChoosePane());
        resultPrintOut.setText("");
    }

    public void gamePlayAndResultPrinter(Game game) {
        resultPrintOut.setText(game.gamePlay(this.playerPlay, this.computerPlay));
        playerResult.setText(game.numberOfPlayerWinsToString());
        computerResult.setText(game.numberOfComputerWinsToString());
        numberOfRoundLabel.setText("Round: " + game.numberOfRoundsToString());
    }

    public Scene paintGameScene(Stage gameStage, Game game) {

        GridPane gameGrid = new GridPane();
        gameGrid.setAlignment(Pos.CENTER);
        gameGrid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gameGrid.setHgap(5.5);
        gameGrid.setVgap(5.5);
        gameGrid.setBackground(backGrounds.getGameBackground());

        //Labels
        numberOfRoundLabel.setText("Round: " + game.getNumberOfRounds());

        playerLabel.setText(game.getPlayerName());
        playerLabel.setFont(new Font("Arial", 15));
        playerLabel.setTextFill(Color.AQUAMARINE);
        playerLabel.setMinWidth(70);

        COMPUTER_LABEL.setFont(new Font("Arial", 15));
        COMPUTER_LABEL.setTextFill(Color.BLACK);
        COMPUTER_LABEL.setMinWidth(70);

        RESULT.setFont(new Font("Arial", 17));
        RESULT.setTextFill(Color.YELLOW);

        playerResult.setFont(new Font("Arial", 20));
        playerResult.setTextFill(Color.YELLOW);
        playerResult.setMinWidth(23);
        playerResult.setText(game.numberOfPlayerWinsToString());

        computerResult.setFont(new Font("Arial", 20));
        computerResult.setTextFill(Color.YELLOW);
        computerResult.setMinWidth(23);
        computerResult.setAlignment(Pos.CENTER_RIGHT);
        computerResult.setText(game.numberOfComputerWinsToString());

        numberOfRoundLabel.setFont(new Font("Arial", 17));

        resultPrintOut.setFont(new Font("Arial", 20));
        resultPrintOut.setMinWidth(150);

        playerPane.setPrefSize(256, 256);
        computerPane.setPrefSize(256, 256);
        playerPane.setBackground(backGrounds.choosePane());

        //Buttons
        Button newGameBtn = new Button();
        newGameBtn.setText("New");
        newGameBtn.setMinWidth(60);
        newGameBtn.setOnAction((event) -> {
            gameStage.setScene(firstScenePainter.paintFirstScene(gameStage));
            gameStage.setTitle("Rock Paper Scissors");
            gameStage.show();
        });

        Button resetBtn = new Button();
        resetBtn.setText("Reset");
        resetBtn.setMinWidth(60);
        resetBtn.setOnAction((event) -> resultsReset(game));

        Button quitBtn = new Button();
        quitBtn.setMinWidth(60);
        quitBtn.setText("Quit");
        quitBtn.setOnAction((event) -> quitConfirmation.quitAreYouSure());

        Button saveBtn = new Button();
        saveBtn.setMinWidth(60);
        saveBtn.setText("Save");
        saveBtn.setOnAction((e) -> {
            Integer user = 0;
            SaveAndLoadGame saveAndLoadGame = new SaveAndLoadGame();
            saveAndLoadGame.saveGame(user, game);
        });

        Button paperBtn = new Button();
        paperBtn.setMinWidth(70);
        paperBtn.setText("Paper");
        paperBtn.setOnAction((event) -> {
            try {
                playerPane.setBackground(displayOfChoices.paperDisplay());
            } catch(Exception e) {
                Label paperExceptionLabel = new Label("File: paper.png not found");
                playerPane.getChildren().add(paperExceptionLabel);
            }
            this.playerPlay = 2;
            computerPlay();
            computerPlayPrinter();
            gamePlayAndResultPrinter(game);
            if (game.getNumberOfPlayerWins() == game.getNumberOfWinsToEnd() || game.getNumberOfComputerWins() == game.getNumberOfWinsToEnd()) {
                EndGameScenePainter endGameScenePainter = new EndGameScenePainter();
                endGameScenePainter.endGame(gameStage, game);
            }
        });

        Button rockBtn = new Button();
        rockBtn.setMinWidth(70);
        rockBtn.setText("Rock");
        rockBtn.setOnAction((event) -> {
            try {
                playerPane.setBackground(displayOfChoices.rockDisplay());
            } catch(Exception e) {
                Label rockExceptionLabel = new Label("File: rock.png not found");
                playerPane.getChildren().add(rockExceptionLabel);
            }
            this.playerPlay = 1;
            computerPlay();
            computerPlayPrinter();
            gamePlayAndResultPrinter(game);
            if (game.getNumberOfPlayerWins() == game.getNumberOfWinsToEnd() || game.getNumberOfComputerWins() == game.getNumberOfWinsToEnd()) {
                EndGameScenePainter endGameScenePainter = new EndGameScenePainter();
                endGameScenePainter.endGame(gameStage, game);
            }
        });

        Button scissorsBtn = new Button();
        scissorsBtn.setMinWidth(70);
        scissorsBtn.setText("Scissors");
        scissorsBtn.setOnAction((event) -> {
            try {
                playerPane.setBackground(displayOfChoices.scissorsDisplay());
            } catch(Exception e) {
                Label scissorsExceptionLabel = new Label("File: scissors.png not found");
                playerPane.getChildren().add(scissorsExceptionLabel);
            }
            this.playerPlay = 3;
            computerPlay();
            computerPlayPrinter();
            gamePlayAndResultPrinter(game);
            if (game.getNumberOfPlayerWins() == game.getNumberOfWinsToEnd() || game.getNumberOfComputerWins() == game.getNumberOfWinsToEnd()) {
                EndGameScenePainter endGameScenePainter = new EndGameScenePainter();
                endGameScenePainter.endGame(gameStage, game);
            }
        });

        //Arrangement of the player's choice buttons
        GridPane gameButtonsGrid = new GridPane();
        gameButtonsGrid.setAlignment(Pos.CENTER);
        gameButtonsGrid.setHgap(12.0);
        gameButtonsGrid.add(paperBtn, 0, 0);
        gameButtonsGrid.add(rockBtn, 1, 0);
        gameButtonsGrid.add(scissorsBtn, 2, 0);

        //Arrangement of the functional buttons
        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setAlignment(Pos.TOP_LEFT);
        buttonsGrid.setHgap(10.0);
        buttonsGrid.add(newGameBtn, 0, 0);
        buttonsGrid.add(resetBtn, 1, 0);
        buttonsGrid.add(quitBtn, 2, 0);
        buttonsGrid.add(saveBtn, 3, 0);

        //adding elements to the game grid
        gameGrid.add(playerLabel, 0, 1);
        gameGrid.add(COMPUTER_LABEL, 6, 1);
        gameGrid.add(RESULT, 3, 1);
        gameGrid.add(playerResult, 2, 1);
        gameGrid.add(computerResult, 4, 1);
        gameGrid.add(playerAvatar, 1, 1);
        gameGrid.setHalignment(playerAvatar, HPos.CENTER);
        gameGrid.add(computerAvatar, 5, 1);
        gameGrid.setHalignment(computerAvatar, HPos.CENTER);
        gameGrid.add(numberOfRoundLabel, 2, 2, 3, 1);
        gameGrid.add(resultPrintOut, 2, 3, 3, 1);
        gameGrid.add(gameButtonsGrid, 1, 4);
        gameGrid.add(buttonsGrid, 5, 4);
        gameGrid.add(playerPane, 1, 3);
        gameGrid.add(computerPane, 5, 3);

        return new Scene(gameGrid, 800, 450, Color.LIGHTBLUE);
    }
}
