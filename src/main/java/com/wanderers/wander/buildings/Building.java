package com.wanderers.wander.buildings;

public abstract class Building {
    private int level;
    private String name;

    Building(int level,String name){
        this.level = level;
        this.name = name;
    };

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }
}
