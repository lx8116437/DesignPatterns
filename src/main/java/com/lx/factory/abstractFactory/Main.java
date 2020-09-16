package com.lx.factory.abstractFactory;


public class Main {
    public static void main(String[] args) {
//        Car c = new Car();
//        c.go();
//        Bread b = new Bread();
//        b.eat();
//        AK47 a = new AK47();
//        a.attack();

        // 需要什么工厂在这里创建什么工厂就行
        Factory factory = new FantasyFactory();
        // 这里的方法不需要改
        factory.creatArms().attack();
        factory.createFood().eat();
        factory.createTravelTool().go();
    }
}
