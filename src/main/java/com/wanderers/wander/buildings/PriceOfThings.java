package com.wanderers.wander.buildings;

import com.wanderers.wander.buildings.economical.EconomicalBuildings;
import javafx.collections.ObservableList;

public interface PriceOfThings {
    int getPriceInLumber();

    int getPriceInFood();

    int getPriceInBricks();

    boolean isAffordable(ObservableList<EconomicalBuildings> economicalBuildings);
}
