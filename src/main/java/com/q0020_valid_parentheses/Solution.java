package com.q0020_valid_parentheses;

import java.util.Stack;

/**
 * @author xjn
 * @since 2020-01-23
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (pop == '(' && ch != ')') {
                        return false;
                    }
                    if (pop == '[' && ch != ']') {
                        return false;
                    }
                    if (pop == '{' && ch != '}') {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution test = new Solution();
//        System.out.println(test.isValid("()"));
//        System.out.println(test.isValid("()[]{}"));
        System.out.println(test.isValid("{[()]}"));
    }
}
