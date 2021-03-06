package com.lx.proxy.v01;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 */
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
        new Tank().move();

    }

}

interface Movable{
    void move();
}
