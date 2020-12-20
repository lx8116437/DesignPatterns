package com.lx.proxy.v02;

import java.util.Random;

public class Tank implements Movable{
    @Override
    public void move() {
        System.out.println("Tank moving ..............");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Tank().move();
        long end = System.currentTimeMillis();
        System.out.println("移动了：" + (end - start));
    }

}

interface Movable{
    void move();
}
