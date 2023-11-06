package com.wanderers.wander.buildings;

public abstract class Building {
    protected String name = "Building";

    protected int level = 0;

    public String getName() {
        return name;
    }

    public abstract int hp();

    public void setLevel(int level){
        this.level = level;
    }
    public int getLevel( ){
        return level;
    }
}
