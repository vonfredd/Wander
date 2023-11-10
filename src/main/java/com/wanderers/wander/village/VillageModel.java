package com.wanderers.wander.village;

import com.wanderers.wander.buildings.economical.EconomicalBuildings;
import com.wanderers.wander.buildings.military.Building;
import com.wanderers.wander.buildings.economical.Brick;
import com.wanderers.wander.buildings.economical.Food;
import com.wanderers.wander.buildings.economical.Logs;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
        materialProduction();
        setLogsTextCounter(String.valueOf(getEconomicalBuildings().get(0).getCount()));
        setFoodTextCounter(String.valueOf(getEconomicalBuildings().get(1).getCount()));
        setBrickTextCounter(String.valueOf(getEconomicalBuildings().get(2).getCount()));
    }

    private void materialProduction() {
        for (EconomicalBuildings e : economicalBuildings) {
            e.produce();
        }
    }

    public void addBuildingToSite(int indexOfBuilding) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var logs = economicalBuildings.get(0);
        var food = economicalBuildings.get(1);
        var brick = economicalBuildings.get(2);

        if (isAffordable(getEconomicalBuildings().get(indexOfBuilding))){
            EconomicalBuildings newBuilding = createEcobuildingOfClass(indexOfBuilding);

            int logsPrice = getEconomicalBuildings().get(indexOfBuilding).getPriceInLumber();
            int foodPrice = getEconomicalBuildings().get(indexOfBuilding).getPriceInFood();
            int brickPrice = getEconomicalBuildings().get(indexOfBuilding).getPriceInBricks();
            int currentCounter = getEconomicalBuildings().get(indexOfBuilding).getCount();
            economicalBuildings.set(indexOfBuilding, newBuilding);
            economicalBuildings.get(indexOfBuilding).setCount(currentCounter);
            economicalBuildings.get(0).setCount(logs.getCount()-logsPrice);
            economicalBuildings.get(1).setCount(food.getCount()-foodPrice);
            economicalBuildings.get(2).setCount(brick.getCount()-brickPrice);

        }
        System.out.println("THE LEVEL IS" + economicalBuildings.get(indexOfBuilding).getLevel());

    }


    private EconomicalBuildings createEcobuildingOfClass(int indexOfBuilding) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<? extends EconomicalBuildings> buildingClass = getEconomicalBuildings().get(indexOfBuilding).getClass();
        Constructor<? extends EconomicalBuildings> constructor = buildingClass.getDeclaredConstructor(int.class);
        return constructor.newInstance(getEconomicalBuildings().get(indexOfBuilding).getLevel()+1);
    }

    private boolean isAffordable(EconomicalBuildings ecoBuilding) {
        if(ecoBuilding.getPriceInLumber() <= getEconomicalBuildings().get(0).getCount() &&
        ecoBuilding.getPriceInFood() <= getEconomicalBuildings().get(1).getCount() &&
        ecoBuilding.getPriceInBricks() <= getEconomicalBuildings().get(2).getCount()){
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
