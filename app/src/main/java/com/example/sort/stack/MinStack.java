package com.example.sort.stack;

import java.util.Stack;

public class MinStack {
    private int min;
    private Stack<Integer> mStack = new Stack<>();

    public void push(int num) {
        if (mStack.isEmpty()) {
            mStack.push(0);
            min = num;
        } else {
            mStack.push(num-min);
            if (num<min) {
                min = num;
            }
        }
    }

    public void pop() {
        if (mStack.isEmpty()) {
            return ;
        }

        int value = mStack.pop();
        if (0>value) {
            min = min-value;
        }
    }

    public int top() {
        if (mStack.isEmpty()) {
            throw new IllegalStateException();
        }

        int value = mStack.peek();
        if (0<value) {
            return (min+value);
        } else {
            return min;
        }
    }

    public int getMin() {
        return min;
    }

}
