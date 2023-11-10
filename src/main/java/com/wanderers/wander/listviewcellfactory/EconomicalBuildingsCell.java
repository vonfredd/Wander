package com.wanderers.wander.listviewcellfactory;

import com.wanderers.wander.buildings.economical.EconomicalBuildings;
import javafx.scene.control.ListCell;

public class EconomicalBuildingsCell extends ListCell<EconomicalBuildings> {

    @Override
    protected void updateItem(EconomicalBuildings item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
        } else {
            setText(item.getNameOfBuilding() + ", LVL: " + item.getLevel() + ", Production: " + item.getLevel()+"/sec");
        }
    }
}