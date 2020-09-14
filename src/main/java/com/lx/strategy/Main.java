package com.lx.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat(8,8),new Cat(5,5), new Cat(3,3),  new Cat(1,1)};
        Sorter sorter = new Sorter();
        sorter.Sorter(cats, new CatWeightComparator());
        System.out.println(Arrays.toString(cats));
        sorter.Sorter(cats, new CatHeightComparator());
        System.out.println(Arrays.toString(cats));


//        Dog[] dogs = {new Dog(5), new Dog(3), new Dog(1), new Dog(0)};
//        Sorter.Sorter(dogs);
//        System.out.println(Arrays.toString(dogs));
    }


}
