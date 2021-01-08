package com.lx.builder;

public class Person {
    int id;
    String name;
    int age;
    double weight;
    int score;

    private Person(){}

    public static class PersonBuild {
        Person p = new Person();
        public PersonBuild baseInfo(int id, String name, int age){
            p.id = id;
            p.name = name;
            p.age = age;
            return this;
        }

        public PersonBuild weightInfo(double weight){
            p.weight = weight;
            return this;
        }

        public PersonBuild scoreInfo(int score){
            p.score = score;
            return this;
        }

        public Person build(){
            return p;
        }

    }
}
