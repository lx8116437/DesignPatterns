package com.lx.factorymethod;

public class Main {
    public static void main(String[] args) {
//        Move c = new Car();
//        c.go();
//
//        Move m = new Plane();
//        m.go();

        // 简单工厂生产汽车
        SimpleVehicleFactory s = new SimpleVehicleFactory();
        Car c1 = s.createCar();
        c1.go();
    }
}
