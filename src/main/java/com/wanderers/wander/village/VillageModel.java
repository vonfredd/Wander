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
    private List<Building> buildings = new ArrayList<>();
    private ObservableList<EconomicalBuildings> economicalBuildings;

    public void initializeEcoBuildings() {
        economicalBuildings = FXCollections.observableArrayList();
        economicalBuildings.add(new Logs(0));
        economicalBuildings.add(new Food(0));
        economicalBuildings.add(new Brick(0));
    }

    public ObservableList<EconomicalBuildings> getEconomicalBuildings() {
        return economicalBuildings;
    }

    public void setEconomicalBuildings(ObservableList<EconomicalBuildings> economicalBuildings) {
        this.economicalBuildings = economicalBuildings;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public String getLogsTextCounter() {
        return logsTextCounter.get();
    }

    public SimpleStringProperty logsTextCounterProperty() {
        return logsTextCounter;
    }

    public void setLogsTextCounter(String logsTextCounter) {
        this.logsTextCounter.set(logsTextCounter);
    }

    public String getFoodTextCounter() {
        return foodTextCounter.get();
    }

    public SimpleStringProperty foodTextCounterProperty() {
        return foodTextCounter;
    }

    public void setFoodTextCounter(String foodTextCounter) {
        this.foodTextCounter.set(foodTextCounter);
    }

    public String getBrickTextCounter() {
        return brickTextCounter.get();
    }

    public SimpleStringProperty brickTextCounterProperty() {
        return brickTextCounter;
    }

    public void setBrickTextCounter(String bricksTextCounter) {
        this.brickTextCounter.set(bricksTextCounter);
    }


    public void updateMaterialsCountingLabels() {
        materialProduction();
        setLogsTextCounter(String.valueOf(getEconomicalBuildings().get(0).getCount()));
        setFoodTextCounter(String.valueOf(getEconomicalBuildings().get(1).getCount()));
        setBrickTextCounter(String.valueOf(getEconomicalBuildings().get(2).getCount()));
    }

    private void materialProduction() {
        for(EconomicalBuildings e : economicalBuildings){
            e.produce();
        }
    }

    public void addBuildingToSite(String building) {
        switch (building) {
            case "forester" ->  upgradeEcoBuilding(0);
            case "food" -> upgradeEcoBuilding(1);
            case "masonry" -> upgradeEcoBuilding(2);
        }
    }


    private void upgradeEcoBuilding(int i) {
        var count = economicalBuildings.get(i).getCount();
        var ecoUpgrade = new Logs(economicalBuildings.get(i).getLevel()+1);
        ecoUpgrade.setCount(count);
        economicalBuildings.set(i,ecoUpgrade);
    }


}
