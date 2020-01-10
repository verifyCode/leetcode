package com.recursive.q01_reverseString;


import java.util.Arrays;

/**
 * 递归反转字符串
 *
 * @author xjn
 * @since 2019-12-18
 */
public class Solution {
    public void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
    }

    public void reverseString(char[] s, int l, int r) {
        if (s == null || s.length == 0) {
            return;
        }
        if (l >= r) {
            return;
        }
        swap(s, l, r);
        reverseString(s, l + 1, r - 1);
    }

    public void swap(char[] s, int l, int r) {
        char a = s[l];
        s[l] = s[r];
        s[r] = a;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        char[] chars = "1234".toCharArray();
        test.reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}
