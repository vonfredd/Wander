package com.wanderers.wander.village;

import com.wanderers.wander.material.Brick;
import com.wanderers.wander.material.Food;
import com.wanderers.wander.material.Logs;
import javafx.beans.property.SimpleStringProperty;

public class VillageModel {
    private final SimpleStringProperty logsTextCounter = new SimpleStringProperty();
    private final SimpleStringProperty foodTextCounter = new SimpleStringProperty();
    private final SimpleStringProperty brickTextCounter = new SimpleStringProperty();
    private Brick brick = new Brick(1);
    private Food food = new Food(1);
    private Logs logs = new Logs(1);

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

    public Brick getBrick() {
        return brick;
    }

    public void setBrick(Brick brick) {
        this.brick = brick;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Logs getLogs() {
        return logs;
    }

    public void setLogs(Logs logs) {
        this.logs = logs;
    }

    public void updateMaterialsCountingLabels() {
        materialProduction();
        setLogsTextCounter(String.valueOf(getLogs().getCount()));
        setFoodTextCounter(String.valueOf(getFood().getCount()));
        setBrickTextCounter(String.valueOf(getBrick().getCount()));
    }

    private void materialProduction() {
        brick.produce();
        logs.produce();
        food.produce();
    }
}
