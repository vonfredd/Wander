package com.wanderers.wander.village;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class VillageController {

    public Button siteOne;
    public Button siteTwo;
    public Button siteThree;
    public Button siteFour;
    public Button siteFive;
    public Button siteSix;
    public Button siteSeven;
    @FXML
    private Label logsCounter;
    @FXML
    private Label foodCounter;
    @FXML
    private Label brickCounter;

    VillageModel model = new VillageModel();

    public void initialize() {
        logsCounter.textProperty().bind(model.logsTextCounterProperty());
        foodCounter.textProperty().bind(model.foodTextCounterProperty());
        brickCounter.textProperty().bind(model.brickTextCounterProperty());

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> updateLabel())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateLabel() {
        model.updateMaterialsCountingLabels();

    }


    /*När man trycker på en byggplatsknapp, skall man få möjlighet att bygga olika byggnader.
        en lista skall ges på vad man kan bygga och vad det kostar att bygga.
     */

    public void buildingSites(MouseEvent event){

    }

}