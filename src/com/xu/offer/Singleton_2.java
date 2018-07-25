package com.xu.offer;

public class Singleton_2 {

    private Singleton_2() {

    }

    private static class SingletionHolder {
        private static Singleton_2 instance = new Singleton_2();
    }

    public static Singleton_2 getInstance() {
        return SingletionHolder.instance;
    }
}
