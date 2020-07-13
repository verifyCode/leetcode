package com.q0155;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author xjn
 * @since 2020-05-31
 * https://leetcode-cn.com/problems/min-stack/
 * 155. 最小栈
 * 时间复杂度O(1)
 * 空间复杂度O(n)
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    private Deque<Integer> dataStack, minStack;

    public MinStack() {
        dataStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("'Your stack is Empty");
        }
        Integer pop = dataStack.pop();
        if (!minStack.isEmpty() && Objects.equals(pop, minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("'Your stack is Empty");
        }
        return dataStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("'Your stack is Empty");
        }
        return minStack.peek();
    }
}
