package com.wanderers.wander.buildings.economical;

import com.wanderers.wander.buildings.PriceOfThings;

public abstract class EconomicalBuildings implements PriceOfThings {
    protected int level;
    protected int count;


    public EconomicalBuildings(int level) {
        this.level = level;
        this.count = 0;
    }

    public void produce() {
        count += level;
    }

    public int getCount() {
        return count;
    }

    public int getLevel(){
        return level;
    }
    public void setCount(int oldCount){
        this.count = oldCount;
    }
}