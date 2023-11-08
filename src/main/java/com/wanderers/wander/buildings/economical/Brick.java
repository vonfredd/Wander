package com.wanderers.wander.buildings.economical;

public class Brick extends EconomicalBuildings {
    public Brick(int level) {
        super(level);
    }

    @Override
    public int getPriceInBricks() {
        return 20 * getLevel();
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