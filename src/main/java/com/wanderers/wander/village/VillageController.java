package com.wanderers.wander.village;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class VillageController {

    @FXML
    private Label logsCounter;

    public int i = 2;

    VillageModel model = new VillageModel();

    public void initialize() {
        // Create a Timeline in the controller's initialize method
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> updateLabel())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateLabel() {
        int number = Integer.parseInt(String.valueOf(logsCounter.getText()));
        logsCounter.setText(String.valueOf((1 + number)));
        System.out.println(i);
    }
}