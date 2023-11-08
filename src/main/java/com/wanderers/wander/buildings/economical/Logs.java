package com.wanderers.wander.buildings.economical;

public class Logs extends EconomicalBuildings {
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