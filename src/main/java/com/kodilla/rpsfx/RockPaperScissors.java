package com.kodilla.rpsfx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class RockPaperScissors extends Application {

    private Image backImage = new Image("file:src/main/resources/back.jpg");
    private Image whiteBack = new Image("file:src/main/resources/white_back.png");

    private Label playerLabel = new Label("Player");
    private Label computerLabel = new Label("Computer");
    private Label result = new Label("Result");
    private Label playerResult = new Label("10");
    private Label computerResult = new Label("10");
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
        playerLabel.setFont(new Font("Arial", 15));
        playerLabel.setTextFill(Color.AQUAMARINE);

        computerLabel.setFont(new Font("Arial", 15));
        computerLabel.setTextFill(Color.AQUAMARINE);

        result.setFont(new Font("Arial", 15));
        result.setTextFill(Color.YELLOW);

        playerResult.setFont(new Font("Arial", 20));
        playerResult.setTextFill(Color.YELLOW);

        computerResult.setFont(new Font("Arial", 20));
        computerResult.setTextFill(Color.YELLOW);

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

        grid.setBackground(background);
        grid.add(playerLabel, 0, 1);
        grid.add(computerLabel, 6, 1);
        grid.add(result, 3, 1);
        grid.add(playerResult, 2, 1);
        grid.add(computerResult, 4, 1);
        grid.add(playerAvatar, 1, 1);
        grid.add(computerAvatar, 5, 1);
//        grid.add(playerPlay, 1, 2);
//        grid.add(computerPlay, 5, 2);
        grid.add(newGameBtn,5,3);

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
        });

        Button rockBtn = new Button();
        rockBtn.setText("  Rock  ");
        rockBtn.setOnAction((event) -> {
            playerPane.setBackground(displayOfChoices.rockDisplay());
        });

        Button scissorsBtn = new Button();
        scissorsBtn.setText("Scissors");
        scissorsBtn.setOnAction((event) -> {
            playerPane.setBackground(displayOfChoices.scissorsDisplay());
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

        primaryStage.setScene(scene);
        primaryStage.setTitle("Rock Paper Scissors");
        primaryStage.show();
    }
}
