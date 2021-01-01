package com.lx.springAop.v01;

public class TimeProxy {
    public void before(){
        System.out.println("开始....");
    }
    public void after(){
        System.out.println("结束....");
    }
}
