package com.lx.observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况进行处理
 * 大多数时候，我们处理事件的时候，需要事件原对象
 */
class Child{
    private boolean cry = false;
    public boolean isCry() {
        return cry;
    }
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public void wakeUp(){
        System.out.println("Waked Up! Crying 5555....");
        cry = true;
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed");
        for(Observer o : observers){
            o.actionOnWakeUp(event);
        }
    }
}

interface Observer{
    void actionOnWakeUp(wakeUpEvent event);
}

class wakeUpEvent{
    long timestamp;
    String loc;
    public wakeUpEvent(long timestamp, String loc){
        this.timestamp = timestamp;
        this.loc = loc;
    }
}
class Dad implements Observer{
    public void feed(){
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer{
    public void hug(){
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer{
    public void wang(){
        System.out.println("dog wang....");
    }

    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        wang();
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
