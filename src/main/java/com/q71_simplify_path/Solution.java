package com.q71_simplify_path;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xjn
 * @since 2020-01-23
 * https://leetcode-cn.com/problems/simplify-path/
 */
public class Solution {

    public String simplifyPath(String path) {
        StringBuilder builder = new StringBuilder("/");
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (int i = 0; i < split.length; i++) {
            String temp = split[i];
            if (!isEmpty(temp)) {
                if (temp.equals(".")) {
                    continue;
                } else if (temp.equals("..")) {
                    if(!stack.empty()){
                        stack.pop();
                    }
                } else {
                    stack.push(temp);
                }

            }
        }
        List<String> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            builder.append(list.get(i));
            if (i != 0) {
                builder.append("/");
            }
        }
        return builder.toString();
    }

    private boolean isEmpty(String s) {
        if (s == null) {
            return true;
        }
        return s.trim().length() == 0;
    }

    public static void main(String[] args) {

        Solution test = new Solution();
        System.out.println(test.simplifyPath("/home//"));
        System.out.println(test.simplifyPath("///home"));
        System.out.println(test.simplifyPath("/home//foo/"));
        System.out.println(test.simplifyPath("/a/./b/../../c/"));
        System.out.println(test.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(test.simplifyPath("/a//b////c/d//././/.."));
    }
}
