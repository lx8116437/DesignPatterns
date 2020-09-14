package com.lx.strategy;

public class Cat implements Comparable<Cat>{
    int height, weight;
    public Cat(int height, int weight){
        this.height = height;
        this.weight = weight;
    }

    public int compareTo(Cat c){
        if(this.height > c.height){
            return 1;
        }else if(this.height < c.height){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}
