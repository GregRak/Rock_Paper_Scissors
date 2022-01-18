package com.kodilla.rpsfx;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class ScenesPainter {


        private final Label titleLabel = new Label("Paper Rock Scissors");
        private final Label enterName = new Label("Enter your Name (max. 8 chars)");
        private Label playerLabel = new Label();
        private final Label computerLabel = new Label("Computer");
        private final Label result = new Label("Result");
        private Label playerResult = new Label();
        private Label computerResult = new Label();
        private Label numberOfRoundLabel = new Label("Round: 0");
        private Label resultPrintOut = new Label();
        private final ImageView playerAvatar = new ImageView("file:src/main/resources/face_2.png");
        private final ImageView computerAvatar = new ImageView("file:src/main/resources/computer_2.png");
        private Pane computerPane = new Pane();
        private Pane playerPane = new Pane();
        private Random generator = new Random();
        private DisplayOfChoices displayOfChoices = new DisplayOfChoices();
        private Game game = new Game();
        private BackGrounds backGrounds = new BackGrounds();
        private int computerPlay;
        private int playerPlay;


        public void computerPlay() {
            int computerPlay = (generator.nextInt(3)) + 1;
            System.out.println(computerPlay);
            if (computerPlay == 1) {
                computerPane.setBackground(displayOfChoices.rockDisplay());
            } else if(computerPlay == 2) {
                computerPane.setBackground(displayOfChoices.paperDisplay());
            } else {
                computerPane.setBackground(displayOfChoices.scissorsDisplay());
            }
            this.computerPlay = computerPlay;
        }

        public void resultPrinter() {
            resultPrintOut.setText(game.gamePlay(this.playerPlay, this.computerPlay));
            playerResult.setText(game.numberOfPlayerWinsToString());
            computerResult.setText(game.numberOfComputerWinsToString());
            numberOfRoundLabel.setText("Round: " + game.numberOfRoundsToString());
        }

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

        public void painter(Stage primaryStage) {

            //Game Scene
            GridPane gameGrid = new GridPane();
            gameGrid.setAlignment(Pos.CENTER);
            gameGrid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
            gameGrid.setHgap(5.5);
            gameGrid.setVgap(5.5);
            gameGrid.setBackground(backGrounds.gameBackground);

            //Labels
            playerLabel.setFont(new Font("Arial", 15));
            playerLabel.setTextFill(Color.AQUAMARINE);
            playerLabel.setMinWidth(70);

            computerLabel.setFont(new Font("Arial", 15));
            computerLabel.setTextFill(Color.BLACK);
            computerLabel.setMinWidth(70);

            result.setFont(new Font("Arial", 17));
            result.setTextFill(Color.YELLOW);

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

//            gameGrid.setGridLinesVisible(true);

            //Player and computer choice printout
            playerPane.setPrefSize(256, 256);
            computerPane.setPrefSize(256, 256);

            //Buttons
            Button newGameBtn = new Button();
            newGameBtn.setText("New Game");

            Button resetBtn = new Button();
            resetBtn.setText("Reset");
            resetBtn.setMinWidth(70);
            resetBtn.setOnAction((event) -> resultsReset());

            Button quitBtn = new Button();
            quitBtn.setMinWidth(70);
            quitBtn.setText("Quit");
            quitBtn.setOnAction((event) -> Platform.exit());

            Button paperBtn = new Button();
            paperBtn.setText("  Paper ");
            paperBtn.setOnAction((event) -> {
                playerPane.setBackground(displayOfChoices.paperDisplay());
                this.playerPlay = 2;
                computerPlay();
                resultPrinter();
            });

            Button rockBtn = new Button();
            rockBtn.setText("  Rock  ");
            rockBtn.setOnAction((event) -> {
                playerPane.setBackground(displayOfChoices.rockDisplay());
                this.playerPlay = 1;
                computerPlay();
                resultPrinter();
            });

            Button scissorsBtn = new Button();
            scissorsBtn.setText("Scissors");
            scissorsBtn.setOnAction((event) -> {
                playerPane.setBackground(displayOfChoices.scissorsDisplay());
                this.playerPlay = 3;
                computerPlay();
                resultPrinter();
            });

            //Arrangement of the player's choice buttons
            GridPane gameButtonsGrid = new GridPane();
            gameButtonsGrid.setAlignment(Pos.CENTER);
            gameButtonsGrid.setHgap(20.0);
            gameButtonsGrid.add(paperBtn,0,0);
            gameButtonsGrid.add(rockBtn, 1, 0);
            gameButtonsGrid.add(scissorsBtn, 2, 0);

            //Arrangement of the functional buttons
            GridPane buttonsGrid = new GridPane();
            buttonsGrid.setAlignment(Pos.TOP_LEFT);
            buttonsGrid.setHgap(17.0);
            buttonsGrid.add(newGameBtn,0,0);
            buttonsGrid.add(resetBtn, 1, 0);
            buttonsGrid.add(quitBtn, 2, 0);

            //adding elements to the game grid
            gameGrid.add(playerLabel, 0, 1);
            gameGrid.add(computerLabel, 6, 1);
            gameGrid.add(result, 3, 1);
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

            Scene gameScene = new Scene(gameGrid, 800, 450, Color.BLACK);

            //First Scene
            titleLabel.setFont(new Font("Arial", 25));
            titleLabel.setTextFill(Color.BLACK);

            GridPane firstSceneGrid = new GridPane();
            firstSceneGrid.setBackground(backGrounds.firstSceneBackground);
            firstSceneGrid.setAlignment(Pos.CENTER);

            TextField textField = new TextField();

            Button btnOK = new Button();
            btnOK.setText("OK");
            btnOK.setOnAction((event) -> {
                String playerName = textField.getText();
                if(playerName.isEmpty()) {
                    Label nameWarning = new Label();
                    nameWarning.setText("Enter your name, please");
                    nameWarning.setTextFill(Color.BLACK);
                    nameWarning.setFont(new Font("Arial", 15));
                    firstSceneGrid.add(nameWarning, 1, 5);
                } else {
                    if(playerName.length() > 8) {
                        playerName = playerName.substring(0, 8);
                    }
                    game.setPlayerName(playerName);
                    playerLabel.setText(game.getPlayerName());
                    resultsReset();
                    primaryStage.setScene(gameScene);
                    primaryStage.setTitle("Rock Paper Scissors");
                    primaryStage.show();
                }
            });

            Button exitBtn = new Button();
            exitBtn.setMinWidth(70);
            exitBtn.setText("Quit");
            exitBtn.setOnAction((event) -> Platform.exit());

            firstSceneGrid.add(backGrounds.paperBack(), 0, 0);
            firstSceneGrid.add(backGrounds.rockBack(), 1 , 0);
            firstSceneGrid.add(backGrounds.scissorsBack(), 2, 0);
            firstSceneGrid.add(titleLabel, 1, 1);
            firstSceneGrid.addRow(2, backGrounds.emptyPane());
            firstSceneGrid.add(enterName, 1, 3);
            firstSceneGrid.add(textField, 1, 4);
            firstSceneGrid.add(btnOK, 2,4);
            firstSceneGrid.add(exitBtn, 1 , 6);

            Scene firstScene = new Scene(firstSceneGrid, 800, 450, Color.BLACK);

            //Action triggered by a "New Game" button in the game grid
            newGameBtn.setOnAction((event) -> {
                primaryStage.setScene(firstScene);
                primaryStage.setTitle("Rock Paper Scissors");
                primaryStage.show();
            });

            primaryStage.setScene(firstScene);
            primaryStage.setTitle("Rock Paper Scissors");
            primaryStage.show();
        }
}
