package com.q438_find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-20
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] freqS = new int[26];
        int[] freqP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a'] += 1;
        }
        int l = 0;
        int r = -1;
        //s[l...r]
        while (r + 1 < s.length()) {
            r++;
            freqS[s.charAt(r) - 'a'] ++;
            if (r - l + 1 > p.length()) {
                freqS[s.charAt(l++) - 'a'] --;
            }
            if (r - l + 1 == p.length() && isSame(freqS, freqP)) {
                res.add(l);
            }
        }
        return res;
    }

    private boolean isSame(int[] freqS, int[] freqP) {
        for (int i = 0; i < 26; i++) {
            if (freqP[i] != freqS[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.findAnagrams("cbaebabacd", "abc"));
    }
}
