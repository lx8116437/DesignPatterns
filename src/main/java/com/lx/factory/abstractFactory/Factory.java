package com.lx.factory.abstractFactory;

/**
 * 工厂   形容词用接口,名词用抽象类
 */
public abstract class Factory {
    abstract Food createFood();
    abstract Arms creatArms();
    abstract TravelTool createTravelTool();
}
