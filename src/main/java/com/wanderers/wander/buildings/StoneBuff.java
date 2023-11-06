package com.wanderers.wander.buildings;

public class StoneBuff extends Building{

    Building thisBuilding;

    StoneBuff(Building building){
        thisBuilding = building;
    }


    @Override
    public String getName(){
        return thisBuilding.getName()+" added stone layer";
    }

    @Override
    public int hp(){
        return thisBuilding.hp() + 150;
    }
}
