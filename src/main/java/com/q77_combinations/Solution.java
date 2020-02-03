package com.q77_combinations;

import java.util.*;

/**
 * @author xjn
 * @since 2020-01-31
 * <p>
 * https://leetcode-cn.com/problems/combinations/
 * 77. 组合
 */
public class Solution {

    private List<List<Integer>> resList = new ArrayList<>();
    private Set<Integer> used = new TreeSet<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return resList;
        }
        resList.clear();
        used.clear();
        findCombine(n, 1, k, new Stack<Integer>());
        return resList;
    }

    //求解C(n,k),当前已经找到组合存储在c中,需要从start开始搜索新的元素
    private void findCombine(int n, int start, int k, Stack<Integer> stack) {
        if (stack.size() == k) {
            resList.add(new ArrayList<>(stack));
            return;
        }

        //start:1  n:4
        for (int i = start; i <= n; i++) {
            if(!used.contains(i)) {
                stack.add(i);
                used.add(i);
                findCombine(n, i + 1, k, stack);
                stack.pop();
                used.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.combine(4, 2));
    }
}
