package com.lx.factorymethod;

public class Main {
    public static void main(String[] args) {
        Move c = new Car();
        c.go();

        Move m = new Plane();
        m.go();
    }
}
