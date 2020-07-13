package com.q0150_evaluate_reverse_polish_notation;

import java.util.Stack;

/**
 * @author xjn
 * @since 2020-01-23
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String temp = tokens[i];
            if (!isOperator(temp)) {
                stack.push(temp);
            } else {
                int right = Integer.parseInt(stack.pop());
                int left = Integer.parseInt(stack.pop());
                int aux;
                if (temp.equals("+")) {
                    aux = (right + left);
                } else if (temp.equals("-")) {
                    aux = (left - right);
                } else if (temp.equals("*")) {
                    aux = (left * right);
                } else {
                    aux = (left / right);
                }
                res = aux;
                stack.push(aux + "");
            }
        }
        if (stack.isEmpty()) {
            return res;
        } else {
            return Integer.parseInt(stack.pop());
        }
    }

    public boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution test = new Solution();

        System.out.println(test.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(test.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(test.evalRPN(new String[]{"18"}));
    }
}
