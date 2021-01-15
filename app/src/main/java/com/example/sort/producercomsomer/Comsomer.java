package com.example.sort.producercomsomer;

import android.util.Log;

import java.util.concurrent.BlockingQueue;

public class Comsomer implements Runnable {
    private BlockingQueue<Integer> mQueue = null;
    public Comsomer(BlockingQueue<Integer> queue) {
        mQueue = queue;
    }

    @Override
    public void run() {
        Integer in = 0;
        while (true) {
            try {
                in = mQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.e("darren", "threadName: " + Thread.currentThread().getName() + ", " + Comsomer.class.getName() + " exception");
                break;
            }
            Log.e("darren", "threadName: " + Thread.currentThread().getName() + ", " + Comsomer.class.getName() + ", in: " + in);
        }
    }
}
