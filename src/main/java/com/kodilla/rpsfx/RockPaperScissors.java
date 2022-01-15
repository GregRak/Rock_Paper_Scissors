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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;


public class RockPaperScissors extends Application {

    private Image backImage = new Image("file:src/main/resources/back.jpg");
    private Image whiteBack = new Image("file:src/main/resources/white_back.png");

    //    private Label playerLabel = new Label("Player");
    private Label playerLabel = new Label();
    private Label computerLabel = new Label("Computer");
    private Label result = new Label("Result");
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

        playerLabel.setFont(new Font("Arial", 15));
        playerLabel.setTextFill(Color.AQUAMARINE);
        playerLabel.setMinWidth(70);

        computerLabel.setFont(new Font("Arial", 15));
        computerLabel.setTextFill(Color.AQUAMARINE);

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

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(whiteBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setGridLinesVisible(true);

        Button newGameBtn = new Button();
        newGameBtn.setText("New Game");
        newGameBtn.setOnAction((event) -> {
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

        playerResult.setText(game.numberOfPlayerWinsToString());
        computerResult.setText(game.numberOfComputerWinsToString());

        grid.setBackground(background);
        grid.add(playerLabel, 0, 1);
        grid.add(computerLabel, 6, 1);
        grid.add(result, 3, 1);
        grid.add(playerResult, 2, 1);
        grid.add(computerResult, 4, 1);
        grid.add(playerAvatar, 1, 1);
        grid.add(computerAvatar, 5, 1);
        grid.add(resultPrintOut, 2, 2, 3, 1);
//        grid.add(playerPlay, 1, 2);
//        grid.add(computerPlay, 5, 2);
        grid.add(newGameBtn,5,3);
        grid.add(exitBtn, 6 , 3);

        Pane playerPane = new Pane();
        playerPane.setPrefSize(256, 256);
        grid.add(playerPane, 1, 2);

        Pane computerPane = new Pane();
        computerPane.setPrefSize(256, 256);
        grid.add(computerPane, 5, 2);

        Button paperBtn = new Button();
        paperBtn.setText("  Paper ");
        paperBtn.setOnAction((event) -> {
            playerPane.setBackground(displayOfChoices.paperDisplay());
            int playerPlay = 2;
            int computerPlay = (generator.nextInt(3)) + 1;
            System.out.println(computerPlay);
            if (computerPlay == 1) {
                computerPane.setBackground(displayOfChoices.rockDisplay());
            } else if(computerPlay == 2) {
                computerPane.setBackground(displayOfChoices.paperDisplay());
            } else if(computerPlay == 3){
                computerPane.setBackground(displayOfChoices.scissorsDisplay());
            }
            resultPrintOut.setText(game.gamePlay(playerPlay, computerPlay));
            playerResult.setText(game.numberOfPlayerWinsToString());
            computerResult.setText(game.numberOfComputerWinsToString());
            System.out.println(game.getPlayerName());
        });

        Button rockBtn = new Button();
        rockBtn.setText("  Rock  ");
        rockBtn.setOnAction((event) -> {
            playerPane.setBackground(displayOfChoices.rockDisplay());
            int playerPlay = 1;
            int computerPlay = (generator.nextInt(3)) + 1;
            System.out.println(computerPlay);
            if (computerPlay == 1) {
                computerPane.setBackground(displayOfChoices.rockDisplay());
            } else if(computerPlay == 2) {
                computerPane.setBackground(displayOfChoices.paperDisplay());
            } else if(computerPlay == 3){
                computerPane.setBackground(displayOfChoices.scissorsDisplay());
            }
        });

        Button scissorsBtn = new Button();
        scissorsBtn.setText("Scissors");
        scissorsBtn.setOnAction((event) -> {
            playerPane.setBackground(displayOfChoices.scissorsDisplay());
            int playerPlay = 3;
            int computerPlay = (generator.nextInt(3)) + 1;
            System.out.println(computerPlay);
            if (computerPlay == 1) {
                computerPane.setBackground(displayOfChoices.rockDisplay());
            } else if(computerPlay == 2) {
                computerPane.setBackground(displayOfChoices.paperDisplay());
            } else if(computerPlay == 3){
                computerPane.setBackground(displayOfChoices.scissorsDisplay());
            }
        });

        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setAlignment(Pos.CENTER);
        buttonsGrid.setHgap(20.0);
        buttonsGrid.add(paperBtn,0,0);
        buttonsGrid.add(rockBtn, 1, 0);
        buttonsGrid.add(scissorsBtn, 2, 0);
        grid.add(buttonsGrid, 1, 3);

        grid.setHalignment(playerAvatar, HPos.CENTER);
        grid.setHalignment(computerAvatar, HPos.CENTER);
        grid.setHalignment(newGameBtn, HPos.CENTER);

        Scene scene = new Scene(grid, 800, 450, Color.BLACK);



//        BackgroundSize backgroundSizeBef = new BackgroundSize(100, 100, true, true, true, false);
//        BackgroundImage backgroundImageBef = new BackgroundImage(whiteBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizeBef);
//        Background backgroundBef = new Background(backgroundImageBef);
        BackGrounds backGrounds = new BackGrounds();
        GridPane pane1 = new GridPane();
        pane1.setBackground(backGrounds.backgroundBef);

        TextField textField = new TextField();
        Button sceneBefBtn = new Button();
        sceneBefBtn.setText("OK");
        sceneBefBtn.setOnAction((event) -> {
            String playerName = textField.getText();
            game.setPlayerName(playerName);
            playerLabel.setText(game.getPlayerName());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Rock Paper Scissors");
            primaryStage.show();
        });

        pane1.add(textField, 1, 1);
        pane1.add(sceneBefBtn, 2,1);

        Scene sceneBef = new Scene(pane1, 800, 450, Color.BLACK);



        primaryStage.setScene(sceneBef);
        primaryStage.setTitle("Rock Paper Scissors");
        primaryStage.show();

//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Rock Paper Scissors");
//        primaryStage.show();
    }
}
