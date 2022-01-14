package com.kodilla.rpsfx;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class DisplayOfChoices {
    private Image paper = new Image("file:src/main/resources/paper.png");
    private Image rock = new Image("file:src/main/resources/rock.png");
    private Image scissors = new Image("file:src/main/resources/scissors.png");

    public Background paperDisplay() {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(paper, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        return background;
    }

    public Background rockDisplay() {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(rock, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        return background;
    }

    public Background scissorsDisplay() {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(scissors, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        return background;
    }
}
