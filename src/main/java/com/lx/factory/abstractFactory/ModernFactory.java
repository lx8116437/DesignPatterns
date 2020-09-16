package com.lx.factory.abstractFactory;

/**
 * 现代世界工厂
 */
public class ModernFactory extends Factory{
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Arms creatArms() {
        return new AK47();
    }

    @Override
    TravelTool createTravelTool() {
        return new Car();
    }
}
