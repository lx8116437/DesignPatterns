package com.lx.prototype.v04;

/**
 * String需要进一步深克隆吗？ 不需要,String有一个常量池,修改后会改变对象的引用地址,但是 stringBuilder 需要进一步深克隆
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();
        System.out.println("p1.loc == p2.loc? " + (p1.loc == p2.loc));

        p1.loc.street.reverse();
        System.out.println(p2.loc.street);
    }

}

class Person implements Cloneable{
    int score = 100;
    int age = 8;

    Location loc = new Location(new StringBuilder("bj"), 22);
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
        p.loc = (Location)loc.clone();
        return p ;
    }
}

class Location implements Cloneable{
    StringBuilder street;
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

    public Location(StringBuilder street, int roomNum) {
        this.street = street;
        this.roomNum = roomNum;
    }
}
