package com.q42;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author xjn
 * @since 2020-05-28
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 42. 接雨水
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            //当前值大于栈顶值,则pop,这样stack中的元素总是大于等于当前值
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                //pop出来的值是比当前值小的元素
                int cur = stack.pop();
                System.out.println("i:" + i + " height[i]:" + height[i] + " cur:" + cur + " height[cur]:" + height[cur]);
                if (stack.isEmpty()) {
                    break;
                }
                //距离差
                int dis = i - stack.peek() - 1;
                //面积
                int h = Math.min(height[stack.peek()], height[i]) - height[cur];
                ans += h * dis;
            }
            //当前值小于等于栈顶值
            stack.push(i);

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] array = new int[]{2, 1, 2, 4, 3};
//        solution.test1(array);
//        solution.test2(array);
        //6
//        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        1
        System.out.println(solution.trap(new int[]{4, 2, 3}));
    }

    //https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/dan-tiao-zhan
    public void test1(int[] array) {
        //存放结果数组
        int[] tempArray = new int[array.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = array.length - 1; i >= 0; i--) {
            //判定大小
            while (!stack.isEmpty() && stack.peek() <= array[i]) {
                //小的直接pop丢弃
                stack.pop();
            }
            tempArray[i] = stack.isEmpty() ? -1 : stack.peek();
            System.out.println(tempArray[i]);
            stack.push(array[i]);
        }
        System.out.println(Arrays.toString(tempArray));
    }

    public void test2(int[] array) {
        //存放结果数组
        int[] tempArray = new int[array.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            //判定大小
            while (!stack.isEmpty() && stack.peek() <= array[i]) {
                //小的直接pop丢弃
                stack.pop();
//                System.out.println(pop);
            }
            tempArray[i] = stack.isEmpty() ? -1 : stack.peek();
            System.out.println(tempArray[i]);
            stack.push(array[i]);
        }
        System.out.println(Arrays.toString(tempArray));
    }
}
