package com.q0022_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-01
 * <p>
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 22. 括号生成
 */
public class Solution {

    private static final String LEFT = "(";
    private static final String RIGHT = ")";

    private List<String> resList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        resList.clear();
        generateParenthesis(2 * n, "");
        return resList;
    }

    private void generateParenthesis(int n, String s) {
        if (n <= 0) {
            if (check(s)) {
                resList.add(s);
            }
            return;
        }
        generateParenthesis(n - 1, s + LEFT);
        generateParenthesis(n - 1, s + RIGHT);
    }

    private boolean check(String str) {
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                flag++;
            } else {
                flag--;
            }
            if (flag < 0) {
                return false;
            }
        }
        return flag == 0;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        test.generateParenthesis(3);
    }

}
