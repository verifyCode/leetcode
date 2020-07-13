package com.q0474_ones_and_zeroes;


import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author xjn
 * @since 2020-02-10
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 * 474. 一和零
 */
public class Solution {

    //m个0  n个1
    private int[][][] memo;
    private Set<String> set = new TreeSet<>();

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0 || (m == 0 && n == 0)) {
            return 0;
        }
        memo = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
//        return dfs(strs, m, n, 0);
        return tryFindMaxForm(strs, m, n, strs.length - 1);
    }

    private int tryFindMaxForm(String[] strs, int m, int n, int index) {
        if (index < 0) {
            return 0;
        }
        if (memo[index][m][n] != -1) {
            return memo[index][m][n];
        }
        int numOf1 = 0;
        int numOf0 = 0;
        String str = strs[index];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                numOf0++;
            } else {
                numOf1++;
            }
        }
        int a = tryFindMaxForm(strs, m, n, index - 1);
        if (m - numOf0 >= 0 && n - numOf1 >= 0) {
            int b = 1 + tryFindMaxForm(strs, m - numOf0, n - numOf1, index - 1);
            a = Math.max(a, b);
        }
        memo[index][m][n] = a;
        return a;
    }
//
//    private int dfs(String[] strs, int m, int n, int index) {
////        System.out.println("m:" + m + " n:" + n);
//        if (index >= strs.length) {
//            return 0;
//        }
//        if (m < 0 || n < 0) {
//            return 0;
//        }
//        if (m == 0 && n == 0) {
//            return 1;
//        }
//
//        int res = Integer.MIN_VALUE;
//        for (int i = index; i < strs.length; i++) {
//            String curStr = strs[i];
//            System.out.println("curStr:" + curStr + " i:" + i);
//            if (set.contains(curStr)) {
//                continue;
//            }
//            int numOf1 = 0;
//            int numOf0 = 0;
//            for (int j = 0; j < curStr.length(); j++) {
//                if (curStr.charAt(j) == '0') {
//                    numOf0++;
//                } else {
//                    numOf1++;
//                }
//            }
//
//            if (m - numOf0 >= 0 && n - numOf1 >= 0) {
//                int b = dfs(strs, m - numOf0, n - numOf1, index + 1) + 1;
//                set.remove(curStr);
//                res = Math.max(res, b);
//            }
//        }
//        return res;
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));//4
        System.out.println(solution.findMaxForm(new String[]{"0", "0", "1", "1"}, 2, 2));//4
    }
}
