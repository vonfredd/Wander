package com.wanderers.wander.buildings.economical;

import com.wanderers.wander.buildings.PriceOfThings;

public class Logs extends EconomicalBuildings implements PriceOfThings {
    public Logs(int level) {
        super(level);
    }

    @Override
    public int getPriceInBricks() {
        return 30 * getLevel();
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