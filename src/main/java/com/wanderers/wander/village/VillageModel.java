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

    public void initializeEcoBuildings() {
        economicalBuildings = FXCollections.observableArrayList();
        economicalBuildings.add(new Logs(0));
        economicalBuildings.add(new Food(0));
        economicalBuildings.add(new Brick(0));
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
        materialProduction();
        setLogsTextCounter(String.valueOf(getEconomicalBuildings().get(0).getCount()));
        setFoodTextCounter(String.valueOf(getEconomicalBuildings().get(1).getCount()));
        setBrickTextCounter(String.valueOf(getEconomicalBuildings().get(2).getCount()));
    }

    private void materialProduction() {

        System.out.println(getEconomicalBuildings().get(1).getPriceInBricks());
        for (EconomicalBuildings e : economicalBuildings) {
            e.produce();
        }
    }

    public void addBuildingToSite(String building) {
        if (isAffordable(building)) {
            switch (building) {
                case "forester" -> upgradeEcoBuilding(0, "forester");
                case "food" -> upgradeEcoBuilding(1, "food");
                case "masonry" -> upgradeEcoBuilding(2, "masonry");
            }
        }
    }

    private boolean isAffordable(String building) {
        switch (building) {
            case "forester" -> {
                return myAnswer(0);
            }
            case "food" -> {
                return myAnswer(1);
            }
            case "masonry" -> {
                return myAnswer(2);
            }
        }
        return false;
    }

    private boolean myAnswer(int i) {
        if (getEconomicalBuildings().get(i).getPriceInBricks() <= getEconomicalBuildings().get(2).getCount()
        && getEconomicalBuildings().get(i).getPriceInFood() <= getEconomicalBuildings().get(1).getCount()
        && getEconomicalBuildings().get(i).getPriceInLumber() <= getEconomicalBuildings().get(0).getCount())
            return true;
        return false;
    }


    private void upgradeEcoBuilding(int i, String type) {
        if (type.equals("forester")) {
            var count = economicalBuildings.get(i).getCount();
            var ecoUpgrade = new Logs(economicalBuildings.get(i).getLevel() + 1);
            ecoUpgrade.setCount(count);
            economicalBuildings.set(i, ecoUpgrade);
            editPrice(ecoUpgrade.getPriceInBricks(), ecoUpgrade.getPriceInFood(),ecoUpgrade.getPriceInLumber());
            return;
        }
        if (type.equals("food")) {
            var count = economicalBuildings.get(i).getCount();
            var ecoUpgrade = new Food(economicalBuildings.get(i).getLevel() + 1);
            ecoUpgrade.setCount(count);
            economicalBuildings.set(i, ecoUpgrade);
            editPrice(ecoUpgrade.getPriceInBricks(), ecoUpgrade.getPriceInFood(),ecoUpgrade.getPriceInLumber());
            return;
        }
        if (type.equals("masonry")) {
            var count = economicalBuildings.get(i).getCount();
            var ecoUpgrade = new Brick(economicalBuildings.get(i).getLevel() + 1);
            ecoUpgrade.setCount(count);
            economicalBuildings.set(i, ecoUpgrade);
            editPrice(ecoUpgrade.getPriceInBricks(), ecoUpgrade.getPriceInFood(),ecoUpgrade.getPriceInLumber());
            return;
        }
    }

    private void editPrice(int priceBricks, int priceFood, int priceLumber) {
        int count1 = getEconomicalBuildings().get(0).getCount();
        int count2 = getEconomicalBuildings().get(1).getCount();
        int count3 = getEconomicalBuildings().get(2).getCount();
        getEconomicalBuildings().get(0).setCount(count1-priceLumber);
        getEconomicalBuildings().get(1).setCount(count2-priceFood);
        getEconomicalBuildings().get(2).setCount(count3-priceBricks);
    }


    public void startingMaterials() {
        for (EconomicalBuildings e : economicalBuildings) {
            e.setCount(100);
        }
    }
}
