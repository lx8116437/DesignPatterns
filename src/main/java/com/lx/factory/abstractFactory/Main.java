package com.lx.factory.abstractFactory;


public class Main {
    public static void main(String[] args) {
//        Car c = new Car();
//        c.go();
//        Bread b = new Bread();
//        b.eat();
//        AK47 a = new AK47();
//        a.attack();
        Factory factory = new FantasyFactory();
        factory.creatArms().attack();
        factory.createFood().eat();
        factory.createTravelTool().go();
    }
}
