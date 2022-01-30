package com.kodilla.rpsfx;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class QuitConfirmation {
    public void quitAreYouSure() {
        Stage stage = new Stage();
        GridPane endGamePane = new GridPane();
        endGamePane.setAlignment(Pos.CENTER);
        endGamePane.setHgap(12);
        endGamePane.setVgap(10);
        Scene areYouSure = new Scene(endGamePane, 400, 150, Color.LIGHTBLUE);

        Label areYouSureLabel = new Label();
        areYouSureLabel.setFont(new Font("Arial", 15));
        areYouSureLabel.setTextFill(Color.BLACK);
        areYouSureLabel.setText("       Are you sure?");

        Button yesBtn = new Button();
        yesBtn.setText("Yes");
        yesBtn.setMinWidth(70);
        yesBtn.setOnAction((e) -> Platform.exit());

        Button noBtn = new Button();
        noBtn.setText("No");
        noBtn.setMinWidth(70);
        noBtn.setOnAction((e) -> stage.close());

        endGamePane.add(areYouSureLabel, 0, 0, 2, 1);
        endGamePane.add(yesBtn, 0, 1);
        endGamePane.add(noBtn, 1, 1);

        stage.setScene(areYouSure);
        stage.setTitle("Rock Paper Scissors");
        stage.setAlwaysOnTop(true);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
