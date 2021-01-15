package com.example.sort.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
    private int MAX_SIZE = 1000000;
    private ReentrantLock lock = new ReentrantLock();
    private LinkedList<E> mList = new LinkedList<E>();

    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public MyBlockingQueue(int maxSize) {
        MAX_SIZE = maxSize;
    }

    public void enqueue(E value) {
        lock.lock();
        try {
            while (MAX_SIZE == mList.size()) {
                notFull.await();
            }
            mList.add(value);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public E dequeue() {
        E value = null;
        lock.lock();
        try{
            while (0 == mList.size()) {
                notEmpty.await();
            }
            value = mList.removeFirst();
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            return value;
        }
    }
}
