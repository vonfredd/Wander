package com.wanderers.wander.buildings.economical;

public class Food extends EconomicalBuildings {
    public Food(int level) {
        super(level);
    }

    @Override
    public int getPriceInBricks() {
        return 40 * getLevel();
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
