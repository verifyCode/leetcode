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

    private static final char LEFT = '(';
    private static final char RIGHT = ')';

    private List<String> resList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        resList.clear();
        dfs(n, "");
        return resList;
    }

    private void dfs(int n, String s) {
        if (n <= 0) {
            if (check(s)) {
                resList.add(s);
            }
            return;
        }
        dfs(n - 1, s + LEFT);
        dfs(n - 1, s + RIGHT);
    }

    private boolean check(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == LEFT) {
                ans++;
            }
            if (s.charAt(i) == RIGHT) {
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
