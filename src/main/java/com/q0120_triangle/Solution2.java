package com.q0120_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-03
 * * https://leetcode-cn.com/problems/triangle/
 * * 120. 三角形最小路径和
 */
public class Solution2 {

    private int m;

    private Integer[][] ans;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        m = triangle.size();
        ans = new Integer[m][m];
        return minimumTotal(triangle, 0, 0);
    }

    public int minimumTotal(List<List<Integer>> list, int x, int y) {
        if (ans[x][y] != null) {
            return ans[x][y];
        }
        if (x == m - 1) {
            return list.get(x).get(y);
        }

        int left = minimumTotal(list, x + 1, y);
        int right = minimumTotal(list, x + 1, y + 1);
        ans[x][y] = Math.min(left, right) + list.get(x).get(y);
        return ans[x][y];
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
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
