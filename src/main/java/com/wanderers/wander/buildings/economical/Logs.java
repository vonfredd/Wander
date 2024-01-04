package com.wanderers.wander.buildings.economical;

import com.wanderers.wander.buildings.PriceOfThings;
import com.wanderers.wander.village.VillageModel;
import javafx.collections.ObservableList;

public class Logs extends EconomicalBuildings implements PriceOfThings {
    public Logs(int level) {
        super(level,"Forester");
    }

    @Override
    public int getPriceInBricks() {
        return 30 * getLevel();
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
        return 20 * getLevel();
    }
}