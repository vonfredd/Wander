package com.wanderers.wander.buildings;

public class Barrack extends Building{

    Barrack(String type){
        name = type;
    }

    @Override
    public int hp() {
        return 10;
    }
}
