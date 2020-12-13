package com.lx.observer.v4;

/**
 * 加入多个观察者
 */
class Child{
    private boolean cry = false;
    public boolean isCry() {
        return cry;
    }
    private Dad d = new Dad();
    private Mum m = new Mum();
    private Dog dog = new Dog();
    public void wakeUp(){
        System.out.println("Waked Up! Crying 5555....");
        cry = true;
        d.feed();
        m.hug();
        dog.wang();
    }
}

class Dad{
    public void feed(){
        System.out.println("dad feeding...");
    }
}

class Mum{
    public void hug(){
        System.out.println("mum hugging...");
    }
}

class Dog{
    public void wang(){
        System.out.println("dog wang....");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
