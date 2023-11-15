package com.wanderers.wander.buildings.military.buildings;

public class BuildingMaker {
    public static void main(String[] args) {
        Building building = new Barrack("Barrack");
        System.out.println(building.getName() + " " + building.hp());
        Building castle = new Castle("Castle");
        System.out.println(castle.getName() + " " + castle.hp());


         castle = new WoodBuff(new Castle("Castle"));
        System.out.println(castle.getName() + " " + castle.hp());
        castle = new StoneBuff(new Castle("Castle"));
        System.out.println(castle.getName() + " " + castle.hp());
        castle = new StoneBuff(new Castle("Castle"));
        System.out.println(castle.getName() + " " + castle.hp());

    }
}
