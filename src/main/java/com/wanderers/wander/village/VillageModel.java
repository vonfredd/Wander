package com.wanderers.wander.village;

import com.wanderers.wander.buildings.economical.EconomicalBuildings;
import com.wanderers.wander.buildings.military.Building;
import com.wanderers.wander.buildings.economical.Brick;
import com.wanderers.wander.buildings.economical.Food;
import com.wanderers.wander.buildings.economical.Logs;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;

public class VillageModel {
    private final SimpleStringProperty logsTextCounter = new SimpleStringProperty();
    private final SimpleStringProperty foodTextCounter = new SimpleStringProperty();
    private final SimpleStringProperty brickTextCounter = new SimpleStringProperty();

    private final List<Building> buildings = new ArrayList<>();
    private ObservableList<EconomicalBuildings> economicalBuildings;
    private ObservableList<SimpleStringProperty> iconPriceBuildings;

    public ObservableList<SimpleStringProperty> getIconPriceBuildings() {
        return iconPriceBuildings;
    }

    public void setIconPriceBuildings(ObservableList<SimpleStringProperty> iconPriceBuildings) {
        this.iconPriceBuildings = iconPriceBuildings;
    }

    public void setEcoIconPrice(){
        iconPriceBuildings = FXCollections.observableArrayList();
        iconPriceBuildings.add(new SimpleStringProperty("Logs: " + getEconomicalBuildings().get(0).getPriceInLumber()));
        iconPriceBuildings.add(new SimpleStringProperty("Food: " + getEconomicalBuildings().get(0).getPriceInFood()));
        iconPriceBuildings.add(new SimpleStringProperty("Brick: " + getEconomicalBuildings().get(0).getPriceInBricks()));

        iconPriceBuildings.add(new SimpleStringProperty("Logs: " + getEconomicalBuildings().get(1).getPriceInLumber()));
        iconPriceBuildings.add(new SimpleStringProperty("Food: " + getEconomicalBuildings().get(1).getPriceInFood()));
        iconPriceBuildings.add(new SimpleStringProperty("Brick: " + getEconomicalBuildings().get(1).getPriceInBricks()));

        iconPriceBuildings.add(new SimpleStringProperty("Logs: " + getEconomicalBuildings().get(2).getPriceInLumber()));
        iconPriceBuildings.add(new SimpleStringProperty("Food: " + getEconomicalBuildings().get(2).getPriceInFood()));
        iconPriceBuildings.add(new SimpleStringProperty("Brick: " + getEconomicalBuildings().get(2).getPriceInBricks()));
    }

    public void initializeEcoBuildings() {
        economicalBuildings = FXCollections.observableArrayList();
        economicalBuildings.add(new Logs(1));
        economicalBuildings.add(new Food(1));
        economicalBuildings.add(new Brick(1));
    }

    public ObservableList<EconomicalBuildings> getEconomicalBuildings() {
        return economicalBuildings;
    }

    public SimpleStringProperty logsTextCounterProperty() {
        return logsTextCounter;
    }

    public void setLogsTextCounter(String logsTextCounter) {
        this.logsTextCounter.set(logsTextCounter);
    }

    public SimpleStringProperty foodTextCounterProperty() {
        return foodTextCounter;
    }

    public void setFoodTextCounter(String foodTextCounter) {
        this.foodTextCounter.set(foodTextCounter);
    }

    public SimpleStringProperty brickTextCounterProperty() {
        return brickTextCounter;
    }

    public void setBrickTextCounter(String bricksTextCounter) {
        this.brickTextCounter.set(bricksTextCounter);
    }


    public void updateMaterialsCountingLabels() {
        setLogsTextCounter(String.valueOf(getEconomicalBuildings().get(0).getCount()));
        setFoodTextCounter(String.valueOf(getEconomicalBuildings().get(1).getCount()));
        setBrickTextCounter(String.valueOf(getEconomicalBuildings().get(2).getCount()));
    }

    public void materialProduction() {
        for (EconomicalBuildings e : economicalBuildings) {
            e.produce();
        }
    }

    public void addBuildingToSite(int indexOfBuilding){
        var logs = economicalBuildings.get(0);
        var food = economicalBuildings.get(1);
        var brick = economicalBuildings.get(2);

        if (isAffordable(getEconomicalBuildings().get(indexOfBuilding))) {

            int offsetOne = 0;
            int offsetTwo = 1;
            int offsetThree = 2;

            switch(indexOfBuilding){
                case 0 -> {
                }
                case 1 -> { offsetOne = 3; offsetTwo = 4; offsetThree = 5;}
                case 2 -> { offsetOne = 6; offsetTwo = 7; offsetThree = 8;}
            }

            int logsPrice = getEconomicalBuildings().get(indexOfBuilding).getPriceInLumber();
            int foodPrice = getEconomicalBuildings().get(indexOfBuilding).getPriceInFood();
            int brickPrice = getEconomicalBuildings().get(indexOfBuilding).getPriceInBricks();
            economicalBuildings.get(indexOfBuilding).setLevel(getEconomicalBuildings().get(indexOfBuilding).getLevel() + 1);

            economicalBuildings.get(0).setCount(logs.getCount() - logsPrice);
            economicalBuildings.get(1).setCount(food.getCount() - foodPrice);
            economicalBuildings.get(2).setCount(brick.getCount() - brickPrice);

            iconPriceBuildings.get(offsetOne).setValue("Logs: " + getEconomicalBuildings().get(indexOfBuilding).getPriceInLumber());
            iconPriceBuildings.get(offsetTwo).setValue("Food: " + getEconomicalBuildings().get(indexOfBuilding).getPriceInFood());
            iconPriceBuildings.get(offsetThree).setValue("Brick: " + getEconomicalBuildings().get(indexOfBuilding).getPriceInBricks());
        }
    }

    public boolean isAffordable(EconomicalBuildings ecoBuilding) {
        if (ecoBuilding.getPriceInLumber() <= getEconomicalBuildings().get(0).getCount() &&
                ecoBuilding.getPriceInFood() <= getEconomicalBuildings().get(1).getCount() &&
                ecoBuilding.getPriceInBricks() <= getEconomicalBuildings().get(2).getCount()) {
            return true;
        }
        return false;
    }


    public void startingMaterials() {
        for (EconomicalBuildings e : economicalBuildings) {
            e.setCount(100);
        }
    }
}
