package com.lx.singleton;

/**
 * 静态内部类
 */
public class Singleton5 {
    private Singleton5() {
    }

    /**
     * 静态内部类
     * Singleton5 类在加载时,不会加载 SingletonInstance 静态内部类,
     * 在需要实例化时,调用 Singleton5.getInstance()方法时,才会被加载到内存中,
     * 保证线程安全,且懒加载,效率高
     */
    private static class SingletonInstance {
        private static final Singleton5 SINGLETON5 = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonInstance.SINGLETON5;
    }

    /**
     * 验证是否线程安全
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton5.getInstance().hashCode());
            }).start();
        }
    }
}
