package com.lx.singleton;

/**
 * 懒汉模式
 */
public class Singleton2 {
    private static Singleton2 singleton2;
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        // 判断是空则新增,如果线程1没有完成创建,线程2就进入判断中,就会产生多个实例
        if (singleton2 == null) {
            // 方便验证非现成安全试验代码
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

    /**
     * 验证懒汉模式非现成安全
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton2.getInstance().hashCode());
            }).start();
        }
    }
}
