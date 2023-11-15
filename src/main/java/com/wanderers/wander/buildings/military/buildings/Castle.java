package com.wanderers.wander.buildings.military.buildings;

public class Castle extends Building{

    Castle(String type){
        name = type;
    }

    @Override
    public int hp() {
        return 1000;
    }
}
