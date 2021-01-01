package com.lx.proxy.v02;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？ benchmark
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
        long start = System.currentTimeMillis();
        new Tank().move();
        long end = System.currentTimeMillis();
        System.out.println("移动了：" + (end - start));
    }

}

interface Movable{
    void move();
}
