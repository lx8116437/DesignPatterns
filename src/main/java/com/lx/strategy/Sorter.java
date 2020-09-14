package com.lx.strategy;

public class Sorter {
    public static void Sorter(Comparable[] c) {
        for (int i = 0; i < c.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < c.length; j++) {
                minPos = c[j].compareTo(c[minPos]) == -1 ? j : minPos;
            }
            swap(c, i, minPos);
        }
    }

    static void swap(Comparable[] c, int i, int j) {
        Comparable temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }


}
