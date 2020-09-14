package com.lx.singleton;

/**
 * 枚举,实现单例模式,确保现成安全,且序列化安全
 */
public enum  Singleton6 {
    INSTANCE;

    /**
     * 验证是否线程安全
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton6.INSTANCE.hashCode());
            }).start();
        }
    }
}
