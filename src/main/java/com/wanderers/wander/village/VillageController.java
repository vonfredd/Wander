package com.wanderers.wander.village;

import com.wanderers.wander.buildings.economical.EconomicalBuildings;
import com.wanderers.wander.listviewcellfactory.EconomicalBuildingsCell;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
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
    public ImageView myTestingImageTwo;
    public ImageView myTestingImageThree;
    public ImageView myTestingImageFour;
    public ImageView myTestingImageFive;
    public ImageView myTestingImageSix;
    public ImageView myTestingImageSeven;
    @FXML
    private ImageView myTestingImage;
    @FXML
    private Label farmLogsPrice;
    @FXML
    private Label farmFoodPrice;
    @FXML
    private Label farmBrickPrice;
    @FXML
    private Label foresterLogsPrice;
    @FXML
    private Label foresterFoodPrice;
    @FXML
    private Label foresterBrickPrice;
    @FXML
    private Label masonryLogsPrice;
    @FXML
    private Label masonryFoodPrice;
    @FXML
    private Label masonryBrickPrice;
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


    @FXML
    private void handleEvent(ImageView myImage, Circle circle, String imageName) {
        int x = (int) circle.getTranslateX();
        int y = (int) circle.getTranslateY();

        Image image = new Image("/" + imageName);

        myImage.setImage(image);
        myImage.setX(x);
        myImage.setY(y);

        circle.setVisible(false);

        myImage.setVisible(true);
    }

    List<Circle> buildingSite;

    public void initialize() {
        Tooltip tooltip = new Tooltip("This is a tooltip");
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
        model.setEcoIconPrice();

        foresterLogsPrice.textProperty().bind(model.getIconPriceBuildings().get(0));
        foresterFoodPrice.textProperty().bind(model.getIconPriceBuildings().get(1));
        foresterBrickPrice.textProperty().bind(model.getIconPriceBuildings().get(2));

        farmLogsPrice.textProperty().bind(model.getIconPriceBuildings().get(3));
        farmFoodPrice.textProperty().bind(model.getIconPriceBuildings().get(4));
        farmBrickPrice.textProperty().bind(model.getIconPriceBuildings().get(5));

        masonryLogsPrice.textProperty().bind(model.getIconPriceBuildings().get(6));
        masonryFoodPrice.textProperty().bind(model.getIconPriceBuildings().get(7));
        masonryBrickPrice.textProperty().bind(model.getIconPriceBuildings().get(8));

        startingTheTimeline();
    }


    private void startingTheTimeline() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(100), event -> updateLabel())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Timeline timelineProduce = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> model.materialProduction())
        );
        timelineProduce.setCycleCount(Timeline.INDEFINITE);
        timelineProduce.play();
    }

    private void updateLabel() {
        model.updateMaterialsCountingLabels();
        myListView.refresh();
    }

    public void mouseAction(MouseEvent event) {
        var thingThatWasPressed = event.getSource();

        if (buildingSite.contains(thingThatWasPressed)) {
            for (Circle b : buildingSite) {
                if (b.equals(thingThatWasPressed))
                    buildingChoice.setVisible(!buildingChoice.isVisible());

            }
        }

        if (thingThatWasPressed.equals(woodcutterImage)) {
            if (model.isAffordable(model.getEconomicalBuildings().get(0))) {
                model.addBuildingToSite(0);
                handleEvent(myTestingImage, buildingSite.get(0), "woodcutter.png");
            }
        }

        if (thingThatWasPressed.equals(farmhouseImage)) {
            if (model.isAffordable(model.getEconomicalBuildings().get(1))) {
                model.addBuildingToSite(1);
                handleEvent(myTestingImageTwo, buildingSite.get(1), "farmHouse.png");
            }
        }
        if (thingThatWasPressed.equals(masonryImage)) {
            if (model.isAffordable(model.getEconomicalBuildings().get(2))) {
                model.addBuildingToSite(2);
                handleEvent(myTestingImageThree, buildingSite.get(2), "bricks.png");
            }
        }

    }
}