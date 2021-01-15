package com.example.sort.design;

public class SingleInstance {
    private static final SingleInstance INSTANCE = new SingleInstance();
    public static SingleInstance getInstance() {
        return INSTANCE;
    }

    private SingleInstance() {

    }
}
