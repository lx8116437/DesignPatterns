package com.lx.Iterator.v03;

public class Main {
    public static void main(String[] args) {
        Collection_ c = new ArrayList_();
        for(int i=0; i < 15 ; i++){
            c.add("s" + i);
        }
        System.out.println(c.size());

        Collection_ cc = new LinkedList_();
        for(int l=0; l < 15 ; l++){
            cc.add("s" + l);
        }
        System.out.println(cc.size());
    }
}
