package com.kodilla.rpsfx;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BackGrounds {
    private Image whiteBack = new Image("file:src/main/resources/back_blue2.jpg");
    private DisplayOfChoices displayOfChoices = new DisplayOfChoices();

    BackgroundSize backgroundSizeBef = new BackgroundSize(100, 100, true, true, true, false);
    BackgroundImage backgroundImageBef = new BackgroundImage(whiteBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizeBef);
    Background backgroundBef = new Background(backgroundImageBef);


    BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    BackgroundImage backgroundImage = new BackgroundImage(whiteBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    Background background = new Background(backgroundImage);

    public Pane paperBack() {
      Pane paperPane = new Pane();
      paperPane.setPrefSize(200, 200);
      paperPane.setBackground(displayOfChoices.paperDisplay());
      return paperPane;
    }

    public Pane rockBack() {
        Pane rockPane = new Pane();
        rockPane.setPrefSize(200, 200);
        rockPane.setBackground(displayOfChoices.rockDisplay());
        return rockPane;
    }

    public Pane scissorsBack() {
        Pane scissorsPane = new Pane();
        scissorsPane.setPrefSize(200, 200);
        scissorsPane.setBackground(displayOfChoices.scissorsDisplay());
        return scissorsPane;
    }

    public Pane emptyPane() {
        Pane emptyPane = new Pane();
        emptyPane.setPrefSize(100, 100);
        return emptyPane;
    }

}
