package com.example.sort.design;

public class LazySingleInstance {
    private static LazySingleInstance INSTANCE = null;
    private LazySingleInstance() {

    }

    public static LazySingleInstance getInstance() {
        if (null == INSTANCE) {
            synchronized (INSTANCE){
                if (null == INSTANCE) {
                    INSTANCE = new LazySingleInstance();
                }
            }
        }

        return INSTANCE;
    }
}
