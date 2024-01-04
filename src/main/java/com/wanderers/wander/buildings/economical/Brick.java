package com.wanderers.wander.buildings.economical;

import javafx.collections.ObservableList;

public class Brick extends EconomicalBuildings {
    public Brick(int level) {
        super(level, "Masonry");
    }

    @Override
    public int getPriceInBricks() {
        return 20 * getLevel();
    }

    @Override
    public boolean isAffordable(ObservableList<EconomicalBuildings> economicalBuildings) {
        if (this.getPriceInLumber() <= economicalBuildings.get(0).getCount() &&
                this.getPriceInFood() <= economicalBuildings.get(1).getCount() &&
                this.getPriceInBricks() <= economicalBuildings.get(2).getCount()) {
            return true;
        }
        return false;
    }

    @Override
    public int getPriceInFood() {
        return 30 * getLevel();
    }

    @Override
    public int getPriceInLumber() {
        return 60 * getLevel();
    }
}