package com.wanderers.wander.buildings.economical;

public abstract class EconomicalBuildings {
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