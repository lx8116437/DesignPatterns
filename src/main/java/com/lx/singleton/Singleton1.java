package com.lx.singleton;

import javax.sound.midi.Soundbank;

/**
 * 饿汉模式
 */
public class Singleton1 {
    // 主动创建类对象
    private static Singleton1 singleton1 = new Singleton1();
    // 私有构造方法,外部不可new
    private Singleton1(){}
    // 获取实例
    public static Singleton1 getInstance(){
        return singleton1;
    }
}
