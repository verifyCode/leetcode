package com.q0120_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-03
 * https://leetcode-cn.com/problems/triangle/
 * 120. 三角形最小路径和
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int level = triangle.size();
        for (int i = level - 2; i >= 0; i--) {
            int c = triangle.get(i).size();
            for (int j = 0; j < c; j++) {
                int root = triangle.get(i).get(j);
                int left = triangle.get(i + 1).get(j);
                int right = triangle.get(i + 1).get(j + 1);
                int min = Math.min(root + left, root + right);
                triangle.get(i).set(j, min);
            }
        }
        return triangle.get(0).get(0);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        System.out.println(solution.minimumTotal(lists));

    }


}
