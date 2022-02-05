package com.kodilla.rpsfx;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Map;
import java.util.Random;

public class ScenesPainter {

    private static final Label TITLE_LABEL = new Label("Paper Rock Scissors");
    private static final Label ENTER_NAME = new Label("Enter your Name (max. 8 chars)");
    private Label playerLabel = new Label();
    private static final Label COMPUTER_LABEL = new Label("Computer");
    private static final Label RESULT = new Label("Result");
    private Label playerResult = new Label();
    private Label computerResult = new Label();
    private Label numberOfRoundLabel = new Label("Round: 0");
    private Label resultPrintOut = new Label();
    private Label endGameResult = new Label();
    private final ImageView playerAvatar = new ImageView("file:src/main/resources/face_2.png");
    private final ImageView computerAvatar = new ImageView("file:src/main/resources/computer_2.png");
    private Pane computerPane = new Pane();
    private Pane playerPane = new Pane();
    private Random generator = new Random();
    private DisplayOfChoices displayOfChoices = new DisplayOfChoices();
    private Game game = new Game(0, 0, 0, "", 0);
    private BackGrounds backGrounds = new BackGrounds();
    private QuitConfirmation quitConfirmation = new QuitConfirmation();
    private int computerPlay;
    private int playerPlay;
    TextField textField = new TextField();
    private Scene firstScene;

    //Computer "choice" printing method
    public void computerPlayPrinter() {
        int computerPlay = (generator.nextInt(3)) + 1;
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
        this.computerPlay = computerPlay;
    }

    //Method displaying the result and the number of rounds
    public void gamePlayAndResultPrinter() {
        resultPrintOut.setText(game.gamePlay(this.playerPlay, this.computerPlay));
        playerResult.setText(game.numberOfPlayerWinsToString());
        computerResult.setText(game.numberOfComputerWinsToString());
        numberOfRoundLabel.setText("Round: " + game.numberOfRoundsToString());
    }

    //Method that resets the game
    public void resultsReset() {
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

    //Method that checks if the user has entered a name and resets the results for the new game
    public boolean startGame() {
        String playerName = textField.getText();
        if (playerName.isEmpty()) {
            textField.setPromptText("Enter your name, please");
            return false;
        } else {
            if (playerName.length() > 8) {
                playerName = playerName.substring(0, 8);
            }
            game.setPlayerName(playerName);
            playerLabel.setText(game.getPlayerName());
            resultsReset();
            return true;
        }
    }

    public void gameSceneSetter(Stage primaryStage) {
        primaryStage.setScene(paintGameScene(primaryStage));
        primaryStage.setTitle("Rock Paper Scissors");
        primaryStage.show();
    }

    //Method to create a title scene
    public void paintFirstScene(Stage primaryStage){
        Label numberOfRoundsChoice = new Label("Choose the number of wins");
        TITLE_LABEL.setFont(new Font("Arial", 25));
        TITLE_LABEL.setTextFill(Color.BLACK);

        GridPane firstSceneGrid = new GridPane();
        firstSceneGrid.setBackground(backGrounds.getGameBackground());
        firstSceneGrid.setAlignment(Pos.CENTER);

        //Buttons
        Button oneWinBtn = new Button();
        oneWinBtn.setMinWidth(55);
        oneWinBtn.setText("1");
        oneWinBtn.setOnAction((event) -> {
            if (startGame()) {
                game.setNumberOfWinsToEnd(1);
                gameSceneSetter(primaryStage);
            }
        });

        Button fiveWinBtn = new Button();
        fiveWinBtn.setMinWidth(55);
        fiveWinBtn.setText("5");
        fiveWinBtn.setOnAction((event) -> {
            if (startGame()) {
                game.setNumberOfWinsToEnd(5);
                gameSceneSetter(primaryStage);
            }
        });

        Button tenWinBtn = new Button();
        tenWinBtn.setMinWidth(55);
        tenWinBtn.setText("10");
        tenWinBtn.setOnAction((event) -> {
            if (startGame()) {
                game.setNumberOfWinsToEnd(10);
                gameSceneSetter(primaryStage);
            }
        });

        Button infinityBtn = new Button();
        infinityBtn.setMinWidth(55);
        infinityBtn.setText("No limit");
        infinityBtn.setOnAction((event) -> {
            if (startGame()) {
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
            resultsReset();
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
            playerLabel.setText(game.getPlayerName());
            numberOfRoundLabel.setText("Round: " + game.getNumberOfRounds());
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
        firstSceneGrid.add(numberOfRoundsChoice, 1, 6);
        firstSceneGrid.add(numberOfRoundsButtonsBox, 1, 7);
        firstSceneGrid.addRow(8, backGrounds.emptyPane());
        firstSceneGrid.add(functionalButtonsBox, 1, 9);

        Scene firstScene = new Scene(firstSceneGrid, 800, 450, Color.LIGHTBLUE);

        this.firstScene = firstScene;
        primaryStage.setScene(firstScene);
        primaryStage.setTitle("Rock Paper Scissors");
        primaryStage.show();
    }

    //Method to create a game scene
    public Scene paintGameScene(Stage primaryStage) {

        GridPane gameGrid = new GridPane();
        gameGrid.setAlignment(Pos.CENTER);
        gameGrid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gameGrid.setHgap(5.5);
        gameGrid.setVgap(5.5);
        gameGrid.setBackground(backGrounds.getGameBackground());

        //Labels
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

        //Player and computer choice printout
        playerPane.setPrefSize(256, 256);
        computerPane.setPrefSize(256, 256);

        //Buttons
        Button newGameBtn = new Button();
        newGameBtn.setText("New");
        newGameBtn.setMinWidth(60);
        newGameBtn.setOnAction((event) -> {
            primaryStage.setScene(firstScene);
            primaryStage.setTitle("Rock Paper Scissors");
            primaryStage.show();
        });

        Button resetBtn = new Button();
        resetBtn.setText("Reset");
        resetBtn.setMinWidth(60);
        resetBtn.setOnAction((event) -> resultsReset());

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
            computerPlayPrinter();
            gamePlayAndResultPrinter();
            if (game.getNumberOfPlayerWins() == game.getNumberOfWinsToEnd() || game.getNumberOfComputerWins() == game.getNumberOfWinsToEnd()) {
                endGame(primaryStage);
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
            computerPlayPrinter();
            gamePlayAndResultPrinter();
            if (game.getNumberOfPlayerWins() == game.getNumberOfWinsToEnd() || game.getNumberOfComputerWins() == game.getNumberOfWinsToEnd()) {
                endGame(primaryStage);
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
            computerPlayPrinter();
            gamePlayAndResultPrinter();
            if (game.getNumberOfPlayerWins() == game.getNumberOfWinsToEnd() || game.getNumberOfComputerWins() == game.getNumberOfWinsToEnd()) {
                endGame(primaryStage);
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

    //Method to create an end scene
    public void endGame(Stage endStage) {
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

        //Buttons
        Button endNewGameBtn = new Button();
        endNewGameBtn.setText("New game");
        endNewGameBtn.setMinWidth(70);
        endNewGameBtn.setOnAction((event) -> {
            endStage.setScene(firstScene);
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
