package com.wanderers.wander.buildings.military.buildings;

public class WoodBuff extends HpBuffer{

    Building thisBuilding;

    WoodBuff(Building building){
        thisBuilding = building;
    }



    @Override
    public String getName(){
        return thisBuilding.getName()+" added wooden layer";
    }

    @Override
    public int hp(){
        return thisBuilding.hp() + 20;
    }
}
