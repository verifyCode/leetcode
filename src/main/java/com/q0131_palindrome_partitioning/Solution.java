package com.q0131_palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-05
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 131. 分割回文串
 */
public class Solution {

    private List<List<String>> resList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        resList.clear();
        if (s == null || s.length() == 0) {
            return resList;
        }
        partition(s, 0, new ArrayList<>());
        return resList;
    }

    private void partition(String s, int start, List<String> list) {
        if (start == s.length()) {
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (!check(sub)) {
                continue;
            }
            list.add(sub);
            partition(s, i + 1, list);
            list.remove(list.size() - 1);
        }
    }


    private boolean check(String str) {
        if (null == str) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        test.partition("aab");
    }
}
