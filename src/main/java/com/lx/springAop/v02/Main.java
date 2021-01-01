package com.lx.springAop.v02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app_auto.xml");
        Tank t = (Tank) applicationContext.getBean("tank");
        t.move();
    }
}
