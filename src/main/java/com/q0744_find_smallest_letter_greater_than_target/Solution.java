package com.q0744_find_smallest_letter_greater_than_target;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * 744. 寻找比目标字母大的最小字母
 */
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (letters[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
//            System.out.println("l:" + l + " r:" + r + " mid:" + mid + " letter[mid]:" + letters[mid]);
        }
        return letters[l % letters.length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));//c
        System.err.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));//f
        System.err.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));//f
    }
}
