package com.lx.proxy.v10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
        Tank tank = new Tank();
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        // 低版本使用下面这个类,高版本使用上面的
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new TimeProxy(tank));
        movable.move();
    }

}

class TimeProxy implements InvocationHandler{
    Movable m;

    public TimeProxy(Movable m) {
        this.m = m;
    }

    public void before(){
        System.out.println("开始...");
    }

    public void after(){
        System.out.println("结束...");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(m, args);
        after();
        return 0;
    }
}

interface Movable {
    void move();
}
