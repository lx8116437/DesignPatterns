package com.lx.factory.factorymethod;

/**
 * 形容词用接口,名词用抽象类
 */
public class Main {
    public static void main(String[] args) {
//        Move c = new Car();
//        c.go();
//
//        Move m = new Plane();
//        m.go();

        // 简单工厂生产汽车
        SimpleVehicleFactory s = new com.lx.factory.factorymethod.SimpleVehicleFactory();
        com.lx.factory.factorymethod.Car c1 = s.createCar();
        c1.go();
    }
}
