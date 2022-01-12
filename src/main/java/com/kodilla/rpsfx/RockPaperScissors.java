package com.kodilla.rpsfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RockPaperScissors extends Application {

    private Image backImage = new Image("file:src/main/resources/back.jpg");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(backImage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        Pane backPane = new Pane();
        backPane.setBackground(background);

        Scene scene = new Scene(backPane, 800, 450, Color.BLACK);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Rock Paper Scissors");
        primaryStage.show();
    }
}
