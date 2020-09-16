package com.lx.factory.abstractFactory;

/**
 * 玄幻世界工厂
 */
public class FantasyFactory extends Factory{
    @Override
    Food createFood() {
        return new Elixirs();
    }

    @Override
    Arms creatArms() {
        return new FlySword();
    }

    @Override
    TravelTool createTravelTool() {
        return new Cloud();
    }
}
