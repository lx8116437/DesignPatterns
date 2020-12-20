package com.lx.proxy.v07;

import java.util.Random;

/**
 * 静态代理,多类实现相同接口,互为代理
 */
public class Tank implements Movable {
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
        new TankLogProxy(new TankTimeProxy(new Tank())).move();
    }

}

class TankTimeProxy implements Movable {
    Movable movable;

    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Movable {
    Movable movable;

    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("开始移动。。。");
        movable.move();
        System.out.println("移动结束!");
    }
}

interface Movable {
    void move();
}
