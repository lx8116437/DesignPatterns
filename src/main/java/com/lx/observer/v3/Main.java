package com.lx.observer.v3;

/**
 * 加入观察者
 */
class Child{
    private boolean cry = false;
    public boolean isCry() {
        return cry;
    }
    private Dad d = new Dad();
    public void wakeUp(){
        System.out.println("Waked Up! Crying 5555....");
        cry = true;
        d.feed();
    }
}

class Dad{
    public void feed(){
        System.out.println("dad feeding...");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
