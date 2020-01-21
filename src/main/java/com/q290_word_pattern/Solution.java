package com.q290_word_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xjn
 * @since 2020-01-21
 * <p>
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * <p>
 * "abba"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        if (strings.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char tmp = pattern.charAt(i);
            if (map.containsKey(tmp)) {
                if (!map.get(tmp).equals(strings[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strings[i])) {
                    return false;
                }
                map.put(tmp, strings[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
//        System.out.println(test.wordPattern("abba", "dog cat cat dog"));
//        System.out.println(test.wordPattern("abba", "dog cat cat fish"));
        System.out.println(test.wordPattern("abba", "dog dog dog dog"));
    }

}
