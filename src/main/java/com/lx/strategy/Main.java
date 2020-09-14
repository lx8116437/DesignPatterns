package com.lx.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat(8,8),new Cat(5,5), new Cat(3,3),  new Cat(1,1)};
        Sorter<Cat> sorter = new Sorter();
        // CatWeightComparator 策略模式排序
        sorter.Sorter(cats, new CatWeightComparator());
        System.out.println(Arrays.toString(cats));

        // CatHeightComparator 策略模式排序
//        sorter.Sorter(cats, new CatHeightComparator());
//        System.out.println(Arrays.toString(cats));

        // 使用lambda表达式,实现 CatHeightComparator 策略模式排序
        sorter.Sorter(cats, (o1, o2) ->{
            if(o1.height < o2.height) return -1;
            else if(o1.height > o2.height) return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(cats));


//        Dog[] dogs = {new Dog(5), new Dog(3), new Dog(1), new Dog(0)};
//        Sorter.Sorter(dogs);
//        System.out.println(Arrays.toString(dogs));
    }


}
