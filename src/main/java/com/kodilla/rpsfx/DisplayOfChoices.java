package com.kodilla.rpsfx;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class DisplayOfChoices {
    private final Image paper = new Image("file:src/main/resources/paper.png");
    private final Image rock = new Image("file:src/main/resources/rock.png");
    private final Image scissors = new Image("file:src/main/resources/scissors.png");
    private final BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);

    public Background paperDisplay() {
        BackgroundImage backgroundImage = new BackgroundImage(paper, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        return new Background(backgroundImage);
    }

    public Background rockDisplay() {
        BackgroundImage backgroundImage = new BackgroundImage(rock, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        return new Background(backgroundImage);
    }

    public Background scissorsDisplay() {
        BackgroundImage backgroundImage = new BackgroundImage(scissors, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        return new Background(backgroundImage);
    }
}
