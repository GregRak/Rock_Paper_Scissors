package com.kodilla.rpsfx;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class DisplayOfChoices {
    private Image paper = new Image("file:src/main/resources/paper.png");

    public Background paperDisplay() {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(paper, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        return background;
    }
}
