package com.lx.springAop.v01;

import java.util.Random;

public class Tank {
    public void move(){
        System.out.println("Tank moving...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
