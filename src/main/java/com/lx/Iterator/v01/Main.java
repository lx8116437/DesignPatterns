package com.lx.Iterator.v01;

/**
 * 构建一个容器，可以添加对象
 */
public class Main {
    public static void main(String[] args) {
        ArrayList_ arrayList_ = new ArrayList_();
        for(int i=0; i<15; i++){
            arrayList_.add("s" + i);
            System.out.println(arrayList_.getSize());
        }
    }
}

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
class ArrayList_ {
    Object[] objects = new Object[10];
    //objects中下一个空的位置在哪儿,或者说，目前容器中有多少个元素
    private int index = 0;

    public void add(Object o) {
        if (index == objects.length) {
            Object[] newObject = new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObject, 0, objects.length);
            objects = newObject;
        }
        objects[index] = o;
        index++;
    }

    public int getSize(){
        return objects.length;
    }

}
