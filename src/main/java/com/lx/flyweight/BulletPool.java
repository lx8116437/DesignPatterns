package com.lx.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Bullet{
    public UUID id = UUID.randomUUID();
    boolean living = true;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                ", living=" + living +
                '}';
    }
}


public class BulletPool{
    List<Bullet> list = new ArrayList<>();
    {
        for(int i = 0 ; i<10; i++){
            list.add(new Bullet());
        }
    }

    public Bullet getBullet(){
        for (int i=0; i<list.size(); i++){
            Bullet b = list.get(i);
            if(!b.living){
                return b;
            }
        }
        return new Bullet();
    }

    public static void main(String[] args) {
        BulletPool p = new BulletPool();
        for (int i=0; i<15; i++){
            Bullet b = p.getBullet();
            System.out.println(b);
        }
    }
}


