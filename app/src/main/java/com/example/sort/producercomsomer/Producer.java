package com.example.sort.producercomsomer;

import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private BlockingQueue<Integer> mQueue = null;
    private AtomicInteger mAtomicInteger = new AtomicInteger(1);
    private int mCount = 0;
    public Producer(BlockingQueue<Integer> queue) {
        mQueue = queue;
    }



    @Override
    public void run() {
        while (true) {
            try {
                if (100000 < mAtomicInteger.get()) {
                    break;
                }

//                if (200 < mCount) {
//                    Log.e("darren", "threadName: " + Thread.currentThread().getName() + ", " + Producer.class.getName() + ", break;");
//                    break;
//                }

                mQueue.put(mAtomicInteger.getAndIncrement());
                Log.e("darren", "threadName: " + Thread.currentThread().getName() + ", " + Producer.class.getName() + ", put: " + mAtomicInteger.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.e("darren", "threadName: " + Thread.currentThread().getName() + ", " + Producer.class.getName() + " exception");
            }
        }
    }
}
