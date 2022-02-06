package com.kodilla.rpsfx;

import javafx.application.Application;
import javafx.stage.Stage;

public class RockPaperScissors extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FirstScenePainter firstScenePainter = new FirstScenePainter();
        firstScenePainter.paintFirstScene(primaryStage);
    }
}
