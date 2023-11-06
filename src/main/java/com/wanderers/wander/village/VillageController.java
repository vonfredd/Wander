package com.wanderers.wander.village;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

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

    @FXML
    private ImageView farmhouseImage;
    @FXML
    private ImageView woodcutterImage;
    @FXML
    private ImageView barrackImage;
    @FXML
    private GridPane buildingChoice;
    VillageModel model = new VillageModel();

    List<Button> buildingSite;

    public void initialize() {
        Tooltip tooltip = new Tooltip("This cost 100 brick and 20 food");
        Tooltip.install(farmhouseImage, tooltip);
        buildingSite = new ArrayList<>();
        buildingSite.add(siteOne);
        buildingSite.add(siteTwo);
        buildingSite.add(siteThree);
        buildingSite.add(siteFour);
        buildingSite.add(siteFive);
        buildingSite.add(siteSix);
        buildingSite.add(siteSeven);


        logsCounter.textProperty().bind(model.logsTextCounterProperty());
        foodCounter.textProperty().bind(model.foodTextCounterProperty());
        brickCounter.textProperty().bind(model.brickTextCounterProperty());

        startingTheTimeline();
    }

    private void startingTheTimeline() {
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

    public void buildingSites(MouseEvent event) {

    }

    public void mouseAction(MouseEvent event) {
        var thingThatWasPressed = event.getSource();
        if (thingThatWasPressed.equals(farmhouseImage))
            System.out.println("FARMEN JAO");
        if (thingThatWasPressed.equals(barrackImage))
            System.out.println("BARRACK JAO");
        if (thingThatWasPressed.equals(woodcutterImage))
            System.out.println("VEDHUGG JAO");

        if (buildingSite.contains(thingThatWasPressed)) {
            for (Button b : buildingSite) {
                if (b.equals(thingThatWasPressed))
                    if (buildingChoice.isVisible()) {
                        buildingChoice.setVisible(false);
                    } else
                        buildingChoice.setVisible(true);
            }
        }
    }

}