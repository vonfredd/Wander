package com.wanderers.wander.village;

import com.wanderers.wander.buildings.economical.EconomicalBuildings;
import com.wanderers.wander.buildings.economical.Brick;
import com.wanderers.wander.buildings.economical.Food;
import com.wanderers.wander.buildings.economical.Logs;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VillageModel {
    private final SimpleStringProperty logsTextCounter = new SimpleStringProperty();
    private final SimpleStringProperty foodTextCounter = new SimpleStringProperty();
    private final SimpleStringProperty brickTextCounter = new SimpleStringProperty();

    private ObservableList<EconomicalBuildings> economicalBuildings;
    private ObservableList<SimpleStringProperty> iconPriceBuildings;

    public ObservableList<SimpleStringProperty> getIconPriceBuildings() {
        return iconPriceBuildings;
    }


    /*
        Sets the pricelabel for the buildings ingame.
     */
    public void setEcoIconPrice() {
        iconPriceBuildings = FXCollections.observableArrayList();
        //Lumber
        iconPriceBuildings.add(new SimpleStringProperty("Logs: " + getEconomicalBuildings().get(0).getPriceInLumber()));
        iconPriceBuildings.add(new SimpleStringProperty("Food: " + getEconomicalBuildings().get(0).getPriceInFood()));
        iconPriceBuildings.add(new SimpleStringProperty("Brick: " + getEconomicalBuildings().get(0).getPriceInBricks()));
        //Food
        iconPriceBuildings.add(new SimpleStringProperty("Logs: " + getEconomicalBuildings().get(1).getPriceInLumber()));
        iconPriceBuildings.add(new SimpleStringProperty("Food: " + getEconomicalBuildings().get(1).getPriceInFood()));
        iconPriceBuildings.add(new SimpleStringProperty("Brick: " + getEconomicalBuildings().get(1).getPriceInBricks()));
        //Brick
        iconPriceBuildings.add(new SimpleStringProperty("Logs: " + getEconomicalBuildings().get(2).getPriceInLumber()));
        iconPriceBuildings.add(new SimpleStringProperty("Food: " + getEconomicalBuildings().get(2).getPriceInFood()));
        iconPriceBuildings.add(new SimpleStringProperty("Brick: " + getEconomicalBuildings().get(2).getPriceInBricks()));

    }

    /*
        Starter production buildings
     */
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

    //Use passed object
    public boolean addToSite(EconomicalBuildings eb, int index) {

        if (eb.isAffordable(this.getEconomicalBuildings())) {
            economicalBuildings.get(index).setLevel(eb.getLevel()+1);

            economicalBuildings.get(0).setCount(economicalBuildings.get(0).getCount() - eb.getPriceInLumber());
            economicalBuildings.get(1).setCount(economicalBuildings.get(1).getCount() - eb.getPriceInFood());
            economicalBuildings.get(2).setCount(economicalBuildings.get(2).getCount() - eb.getPriceInBricks());

            iconPriceBuildings.get(0).setValue("Logs: " + getEconomicalBuildings().get(index).getPriceInLumber());
            iconPriceBuildings.get(1).setValue("Food: " + getEconomicalBuildings().get(index).getPriceInFood());
            iconPriceBuildings.get(2).setValue("Brick: " + getEconomicalBuildings().get(index).getPriceInBricks());
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
