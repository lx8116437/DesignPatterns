package com.lx.builder;

public class Main {
    public static void main(String[] args) {
        Terrain t = new ComplexTerrainBuilder().buildFort().buildWall().buildMine().build();

        Person p = new Person.PersonBuild()
                .baseInfo(1, "liuxiao", 28)
                .weightInfo(105.9)
                .scoreInfo(800)
                .build();
    }
}
