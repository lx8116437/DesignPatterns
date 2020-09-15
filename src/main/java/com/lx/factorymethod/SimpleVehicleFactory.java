package com.lx.factorymethod;

/**
 * 简单工厂模式
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        // 增加前置条件
        // ...
        return new Car();
    }

    public Plane createPlane(){
        // 增加前置条件
        // ...
        return new Plane();
    }
}
