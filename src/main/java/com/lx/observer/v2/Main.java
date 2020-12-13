package com.lx.observer.v2;

/**
 * 面向对象傻等
 */
class Child{
    private boolean cry = false;
    public boolean isCry() {
        return cry;
    }
    public void wakeUp(){
        System.out.println("Waked Up! Crying 5555....");
        cry = true;
    }
}
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        while(!child.isCry()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observing...");
        }
    }
}
