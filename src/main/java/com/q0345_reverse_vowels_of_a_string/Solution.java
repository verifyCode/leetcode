package com.q0345_reverse_vowels_of_a_string;


/**
 * @author xjn
 * @since 2020-01-20
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (left < right && !isVowels(s.charAt(left))) {
                left++;
            }
            while (left < right && !isVowels(s.charAt(right))) {
                right--;
            }
            if (isVowels(s.charAt(left)) && isVowels(s.charAt(left))) {
                swap(chars, left, right);
                left ++;
                right --;
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int a, int b) {
        char c = chars[a];
        chars[a] = chars[b];
        chars[b] = c;
    }

    private boolean isVowels(Character c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.reverseVowels("hello"));
        System.out.println(test.reverseVowels("leetcode"));
        System.out.println(test.reverseVowels("aA"));
    }
}
