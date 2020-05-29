package com.q42;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author xjn
 * @since 2020-05-28
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 42. 接雨水
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < height.length; i++) {
            if (!stack.isEmpty() || stack.peek() > height[i]) {
                stack.push(height[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < height[i]) {
                    stack.pop();
                }
                stack.push(height[i]);
            }
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
