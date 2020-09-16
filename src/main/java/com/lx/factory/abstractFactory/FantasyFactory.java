package com.lx.factory.abstractFactory;

public class FantasyFactory extends Factory{
    @Override
    Food createFood() {
        return new Elixirs();
    }

    @Override
    Arms creatArms() {
        return new Sword();
    }

    @Override
    TravelTool createTravelTool() {
        return new Cloud();
    }
}
