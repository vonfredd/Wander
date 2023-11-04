package com.wanderers.wander.timer;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

public class TimerController extends AnimationTimer {
    private long lastUpdateNanoTime = 0;
    private Label timerLabel;
    private int seconds = 0;

    public TimerController(Label timerLabel) {
        this.timerLabel = timerLabel;
    }

    @Override
    public void handle(long currentNanoTime) {
        if (lastUpdateNanoTime == 0) {
            lastUpdateNanoTime = currentNanoTime;
            return;
        }

        // Calculate the elapsed time since the last frame
        long elapsedTime = currentNanoTime - lastUpdateNanoTime;
    }

}
