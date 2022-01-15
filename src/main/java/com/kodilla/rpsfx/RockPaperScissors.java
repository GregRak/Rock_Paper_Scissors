package com.kodilla.rpsfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;


public class RockPaperScissors extends Application {

    private final Label titleLabel = new Label("Paper Rock Scissors");
    private final Label enterName = new Label("Enter your Name (max. 8 chars)");
    private Label playerLabel = new Label();
    private final Label computerLabel = new Label("Computer");
    private final Label result = new Label("Result");
    private Label playerResult = new Label();
    private Label computerResult = new Label();
    private Label resultPrintOut = new Label();
    private ImageView playerAvatar = new ImageView("file:src/main/resources/face_2.png");
    private ImageView computerAvatar = new ImageView("file:src/main/resources/computer_2.png");
    private ImageView playerPlay = new ImageView();
    private ImageView paper = new ImageView("file:src/main/resources/paper.png");
    private ImageView computerPlay = new ImageView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DisplayOfChoices displayOfChoices = new DisplayOfChoices();
        Game game = new Game();
        Random generator = new Random();
        BackGrounds backGrounds = new BackGrounds();


        playerLabel.setFont(new Font("Arial", 15));
        playerLabel.setTextFill(Color.AQUAMARINE);
        playerLabel.setMinWidth(70);

        computerLabel.setFont(new Font("Arial", 15));
        computerLabel.setTextFill(Color.BLACK);

        result.setFont(new Font("Arial", 15));
        result.setTextFill(Color.YELLOW);

        playerResult.setFont(new Font("Arial", 20));
        playerResult.setTextFill(Color.YELLOW);
        playerResult.setMinWidth(23);

        computerResult.setFont(new Font("Arial", 20));
        computerResult.setTextFill(Color.YELLOW);
        computerResult.setMinWidth(23);
        computerResult.setAlignment(Pos.CENTER_RIGHT);

        resultPrintOut.setFont(new Font("Arial", 20));
        resultPrintOut.setMinWidth(150);

        Button newGameBtn = new Button();
        newGameBtn.setText("New Game");

        Button resetBtn = new Button();
        resetBtn.setText("Reset");
        resetBtn.setMinWidth(70);
        resetBtn.setOnAction((event) -> {
            game.setNumberOfPlayerWins(0);
            game.setNumberOfComputerWins(0);
            playerResult.setText(game.numberOfPlayerWinsToString());
            computerResult.setText(game.numberOfComputerWinsToString());
        });

        Button exitBtn = new Button();
        exitBtn.setMinWidth(70);
        exitBtn.setText("Quit");
        exitBtn.setOnAction((event) -> {
            Platform.exit();
        });

        //Game Scene
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);


   //     grid.setGridLinesVisible(true);

        playerResult.setText(game.numberOfPlayerWinsToString());
        computerResult.setText(game.numberOfComputerWinsToString());

        grid.setBackground(backGrounds.background);
        grid.add(playerLabel, 0, 1);
        grid.add(computerLabel, 6, 1);
        grid.add(result, 3, 1);
        grid.add(playerResult, 2, 1);
        grid.add(computerResult, 4, 1);
        grid.add(playerAvatar, 1, 1);
        grid.add(computerAvatar, 5, 1);
        grid.add(resultPrintOut, 2, 2, 3, 1);
        grid.add(exitBtn, 6 , 3);

        AtomicReference<Pane> playerPane = new AtomicReference<>(new Pane());
        playerPane.get().setPrefSize(256, 256);
        grid.add(playerPane.get(), 1, 2);

        AtomicReference<Pane> computerPane = new AtomicReference<>(new Pane());
        computerPane.get().setPrefSize(256, 256);
        grid.add(computerPane.get(), 5, 2);



        // pane1.setGridLinesVisible(true);



        Button paperBtn = new Button();
        paperBtn.setText("  Paper ");
        paperBtn.setOnAction((event) -> {
            playerPane.get().setBackground(displayOfChoices.paperDisplay());
            int playerPlay = 2;
            int computerPlay = (generator.nextInt(3)) + 1;
            System.out.println(computerPlay);
            if (computerPlay == 1) {
                computerPane.get().setBackground(displayOfChoices.rockDisplay());
            } else if(computerPlay == 2) {
                computerPane.get().setBackground(displayOfChoices.paperDisplay());
            } else if(computerPlay == 3){
                computerPane.get().setBackground(displayOfChoices.scissorsDisplay());
            }
            resultPrintOut.setText(game.gamePlay(playerPlay, computerPlay));
            playerResult.setText(game.numberOfPlayerWinsToString());
            computerResult.setText(game.numberOfComputerWinsToString());
        });

        Button rockBtn = new Button();
        rockBtn.setText("  Rock  ");
        rockBtn.setOnAction((event) -> {
            playerPane.get().setBackground(displayOfChoices.rockDisplay());
            int playerPlay = 1;
            int computerPlay = (generator.nextInt(3)) + 1;
            System.out.println(computerPlay);
            if (computerPlay == 1) {
                computerPane.get().setBackground(displayOfChoices.rockDisplay());
            } else if(computerPlay == 2) {
                computerPane.get().setBackground(displayOfChoices.paperDisplay());
            } else if(computerPlay == 3){
                computerPane.get().setBackground(displayOfChoices.scissorsDisplay());
            }
            resultPrintOut.setText(game.gamePlay(playerPlay, computerPlay));
            playerResult.setText(game.numberOfPlayerWinsToString());
            computerResult.setText(game.numberOfComputerWinsToString());
        });

        Button scissorsBtn = new Button();
        scissorsBtn.setText("Scissors");
        scissorsBtn.setOnAction((event) -> {
            playerPane.get().setBackground(displayOfChoices.scissorsDisplay());
            int playerPlay = 3;
            int computerPlay = (generator.nextInt(3)) + 1;
            System.out.println(computerPlay);
            if (computerPlay == 1) {
                computerPane.get().setBackground(displayOfChoices.rockDisplay());
            } else if(computerPlay == 2) {
                computerPane.get().setBackground(displayOfChoices.paperDisplay());
            } else if(computerPlay == 3){
                computerPane.get().setBackground(displayOfChoices.scissorsDisplay());
            }
            resultPrintOut.setText(game.gamePlay(playerPlay, computerPlay));
            playerResult.setText(game.numberOfPlayerWinsToString());
            computerResult.setText(game.numberOfComputerWinsToString());
        });

        GridPane gameButtonsGrid = new GridPane();
        gameButtonsGrid.setAlignment(Pos.CENTER);
        gameButtonsGrid.setHgap(20.0);
        gameButtonsGrid.add(paperBtn,0,0);
        gameButtonsGrid.add(rockBtn, 1, 0);
        gameButtonsGrid.add(scissorsBtn, 2, 0);
        grid.add(gameButtonsGrid, 1, 3);

        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setAlignment(Pos.CENTER);
        buttonsGrid.setHgap(20.0);
        buttonsGrid.add(newGameBtn,0,0);
        buttonsGrid.add(resetBtn, 1, 0);
        grid.add(buttonsGrid, 5, 3);

        grid.setHalignment(playerAvatar, HPos.CENTER);
        grid.setHalignment(computerAvatar, HPos.CENTER);
        grid.setHalignment(newGameBtn, HPos.CENTER);

        Scene gameScene = new Scene(grid, 800, 450, Color.BLACK);

        //First Scene
        titleLabel.setFont(new Font("Arial", 25));
        titleLabel.setTextFill(Color.BLACK);

        GridPane pane1 = new GridPane();
        pane1.setBackground(backGrounds.backgroundBef);
        pane1.setAlignment(Pos.CENTER);

        TextField textField = new TextField();
        Button sceneBefBtn = new Button();
        sceneBefBtn.setText("OK");
        sceneBefBtn.setOnAction((event) -> {
            String playerName = textField.getText();
            if(playerName.isEmpty()) {
                Label nameWarning = new Label();
                nameWarning.setText("Enter your name, please");
                nameWarning.setTextFill(Color.BLACK);
                nameWarning.setFont(new Font("Arial", 15));
                pane1.add(nameWarning, 1, 5);
            } else {
                if(playerName.length() > 8) {
                    playerName = playerName.substring(0, 8);
                }
                game.setPlayerName(playerName);
                playerLabel.setText(game.getPlayerName());
                game.setNumberOfPlayerWins(0);
                game.setNumberOfComputerWins(0);
                playerResult.setText(game.numberOfPlayerWinsToString());
                computerResult.setText(game.numberOfComputerWinsToString());
                primaryStage.setScene(gameScene);
                primaryStage.setTitle("Rock Paper Scissors");
                primaryStage.show();
            }
        });

        pane1.add(backGrounds.paperBack(), 0, 0);
        pane1.add(backGrounds.rockBack(), 1 , 0);
        pane1.add(backGrounds.scissorsBack(), 2, 0);
        pane1.add(titleLabel, 1, 1);
        pane1.addRow(2, backGrounds.emptyPane());
        pane1.add(enterName, 1, 3);
        pane1.add(textField, 1, 4);
        pane1.add(sceneBefBtn, 2,4);
        pane1.add(exitBtn, 1 , 6);

        Scene sceneBef = new Scene(pane1, 800, 450, Color.BLACK);

        newGameBtn.setOnAction((event) -> {
            primaryStage.setScene(sceneBef);
            primaryStage.setTitle("Rock Paper Scissors");
            primaryStage.show();
        });

        primaryStage.setScene(sceneBef);
        primaryStage.setTitle("Rock Paper Scissors");
        primaryStage.show();
    }
}
