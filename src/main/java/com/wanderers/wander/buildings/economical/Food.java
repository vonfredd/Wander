package com.wanderers.wander.buildings.economical;

import com.wanderers.wander.village.VillageModel;
import javafx.collections.ObservableList;

public class Food extends EconomicalBuildings {

    public Food(int level) {
        super(level,"Farm");
    }

    @Override
    public int getPriceInBricks() {
        return 40 * getLevel();
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
        return 20 * getLevel();
    }

    @Override
    public int getPriceInLumber() {
        return 30 * getLevel();
    }

}
