package com.lx.prototype.v02;

/**
 * 深克隆的处理
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();
        System.out.println(p2.age + " " + p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc);
        p1.loc.street = "sh";
        System.out.println(p2.loc);
    }

}

class Person implements Cloneable{
    int score = 100;
    int age = 8;

    Location loc = new Location("bj", 33);
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
        p.loc = (Location)loc.clone();
        return p ;
    }
}

class Location implements Cloneable{
    String street;
    int roomNum;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNum=" + roomNum +
                '}';
    }

    public Location(String street, int roomNum) {
        this.street = street;
        this.roomNum = roomNum;
    }
}
