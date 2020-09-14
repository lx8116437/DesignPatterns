package com.lx.singleton;

/**
 * 双重检查
 */
public class Singleton4 {
    // volatile 禁止指令重排序
    private static volatile Singleton4 singleton4;

    private Singleton4() {}

    public  static Singleton4 getInstance() {
        if (singleton4 == null) {
            System.out.println("第一次判断null,理论只能输出一次");
            synchronized (Singleton4.class){
                if(singleton4 == null){
                    System.out.println("实例化,必须输出1次");
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }

    /**
     * 验证是否线程安全
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Singleton4.getInstance();
            }).start();
        }
    }
}
