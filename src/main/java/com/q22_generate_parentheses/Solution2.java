package com.q22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-15
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 22. 括号生成
 */
public class Solution2 {

    private List<String> resList = new ArrayList<>();
    private static final String LEFT = "(";
    private static final String RIGHT = ")";

    public List<String> generateParenthesis(int n) {
        resList.clear();
        if (n == 0) {
            return resList;
        }
        dfs("", 0, 0, n);
        return resList;
    }

    private void dfs(String s, int left, int right, int n) {
        if (left < right) {
            return;
        }
        if (left == n && right == n) {
            if (check(s)) {
                resList.add(s);
            }
            return;
        }
        if (left < n) {
            dfs(s + LEFT, left + 1, right, n);
        }
        if (right < n) {
            dfs(s + RIGHT, left, right + 1, n);
        }
    }

    private boolean check(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == LEFT.charAt(0)) {
                ans++;
            }
            if (s.charAt(i) == RIGHT.charAt(0)) {
                ans--;
            }
            if (ans < 0) {
                return false;
            }
        }
        return ans == 0;
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.generateParenthesis(3));
    }
}
