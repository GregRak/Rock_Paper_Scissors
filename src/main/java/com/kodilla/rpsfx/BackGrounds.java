package com.kodilla.rpsfx;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BackGrounds {
    private Image whiteBack = new Image("file:src/main/resources/white_back.png");

    BackgroundSize backgroundSizeBef = new BackgroundSize(100, 100, true, true, true, false);
    BackgroundImage backgroundImageBef = new BackgroundImage(whiteBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizeBef);
    Background backgroundBef = new Background(backgroundImageBef);


}
