package com.wanderers.wander.buildings.military;

public class Barrack extends Building{

    Barrack(String type){
        name = type;
    }

    @Override
    public int hp() {
        return 10;
    }
}
