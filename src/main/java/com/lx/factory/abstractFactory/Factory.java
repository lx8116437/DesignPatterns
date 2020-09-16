package com.lx.factory.abstractFactory;

/**
 * 工厂
 */
public abstract class Factory {
    abstract Food createFood();
    abstract Arms creatArms();
    abstract TravelTool createTravelTool();
}
