package com.lx.springAop.v02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeProxy {
    @Before("execution(void com.lx.springAop.v02.Tank.*())")
    public void before(){
        System.out.println("开始....");
    }

    @After("execution(void com.lx.springAop.v02.Tank.*())")
    public void after(){
        System.out.println("结束....");
    }
}
