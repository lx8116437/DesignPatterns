package com.lx.singleton;

/**
 * 加锁单例
 */
public class Singleton3 {
    private static Singleton3 singleton2;

    private Singleton3() {
    }

    /**
     * 加锁,效率会变低
     *
     * @return
     */
    public synchronized static Singleton3 getInstance() {
        if (singleton2 == null) {

//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            singleton2 = new Singleton3();
        }
        return singleton2;
    }

    /**
     * 验证是否线程安全
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton3.getInstance().hashCode());
            }).start();
        }
    }
}
