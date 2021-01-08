package com.lx.bridge.v04;

public class GG {
    public void chase(MM mm){
        Gift gift = new WarmGift(new Flower());
        give(mm, gift);
    }

    public void give(MM mm, Gift gift){
        System.out.println(gift + "impl");
    }

}
