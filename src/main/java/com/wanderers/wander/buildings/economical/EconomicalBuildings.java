package com.wanderers.wander.buildings.economical;

import com.wanderers.wander.buildings.PriceOfThings;

public abstract class EconomicalBuildings implements PriceOfThings {
    protected int level;
    protected int count;
    protected String nameOfBuilding;


    public EconomicalBuildings(int level, String nameOfBuilding) {
        this.level = level;
        this.count = 0;
        this.nameOfBuilding = nameOfBuilding;
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

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNameOfBuilding() {
        return nameOfBuilding;
    }
}