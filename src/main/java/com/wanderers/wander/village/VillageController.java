package com.wanderers.wander.village;

import com.wanderers.wander.buildings.economical.EconomicalBuildings;
import com.wanderers.wander.listviewcellfactory.EconomicalBuildingsCell;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class VillageController {

    public Circle siteOne;
    public Circle siteTwo;
    public Circle siteThree;
    public Circle siteFour;
    public Circle siteFive;
    public Circle siteSix;
    public Circle siteSeven;
    @FXML
    private Label farmLogsPrice;
    @FXML
    private Label farmFoodPrice;
    @FXML
    private Label farmBrickPrice;
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
    private ImageView masonryImage;
    @FXML
    private ImageView barrackImage;
    @FXML
    private GridPane buildingChoice;
    @FXML
    private ListView<EconomicalBuildings> myListView;
    VillageModel model = new VillageModel();

    List<Circle> buildingSite;

    public void initialize() {
        Tooltip tooltip = new Tooltip("This cost 100 brick and 20 food");
        Tooltip.install(farmhouseImage, tooltip);
        myListView.setCellFactory(param -> new EconomicalBuildingsCell());

        model.initializeEcoBuildings();

        buildingSite = new ArrayList<>();
        buildingSite.add(siteOne);
        buildingSite.add(siteTwo);
        buildingSite.add(siteThree);
        buildingSite.add(siteFour);
        buildingSite.add(siteFive);
        buildingSite.add(siteSix);
        buildingSite.add(siteSeven);

        model.startingMaterials();
        myListView.setItems(model.getEconomicalBuildings());

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
        myListView.refresh();
    }

    public void mouseAction(MouseEvent event) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        var thingThatWasPressed = event.getSource();

        if (thingThatWasPressed.equals(woodcutterImage)) {
            model.addBuildingToSite(0);
        }
        if (thingThatWasPressed.equals(farmhouseImage)) {
            model.addBuildingToSite(1);
        }
        if (thingThatWasPressed.equals(masonryImage)) {
            model.addBuildingToSite(2);
        }

        if (buildingSite.contains(thingThatWasPressed)) {
            for (Circle b : buildingSite) {
                if (b.equals(thingThatWasPressed))
                    buildingChoice.setVisible(!buildingChoice.isVisible());
            }
        }
    }
}