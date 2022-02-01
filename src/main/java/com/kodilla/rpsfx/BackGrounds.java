package com.kodilla.rpsfx;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BackGrounds {
    private final Image windowBack = new Image("file:src/main/resources/back_blue2.jpg");
    private final Image chooseImage = new Image("file:src/main/resources/choose_back.png");
    private final Image blank = new Image("file:src/main/resources/blank.png");
    private final BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    private DisplayOfChoices displayOfChoices = new DisplayOfChoices();

    public Background getGameBackground()  {
            BackgroundImage backgroundImage = new BackgroundImage(windowBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
            return new Background(backgroundImage);
    }

    public Background choosePane() {
        BackgroundImage backgroundChooseImage = new BackgroundImage(chooseImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        return new Background(backgroundChooseImage);
    }

    public Background computerChoosePane() {
        BackgroundImage backgroundComputerChooseImage = new BackgroundImage(blank, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        return new Background(backgroundComputerChooseImage);
    }

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
        emptyPane.setPrefSize(100, 30);
        return emptyPane;
    }
}
