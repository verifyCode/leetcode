package com.q139_word_break;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xjn
 * @since 2020-02-10
 * https://leetcode-cn.com/problems/word-break/
 * 139. 单词拆分
 */
public class Solution {

    private int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return tryWordBreak(s, new HashSet<String>(wordDict), 0);
    }

    private boolean tryWordBreak(String s, Set<String> wordDict, int start) {
        if (start > s.length()) {
            return false;
        }
        if (memo[start] != -1) {
            return memo[start] == 1;
        }
        if (start == s.length()) {
            return true;
        }
        for (int i = start; i <= s.length(); i++) {
            String subStr = s.substring(start, i);
            System.out.println(subStr);
            if (wordDict.contains(subStr)) {
                if (tryWordBreak(s, wordDict, i)) {
                    memo[start] = 1;
                    return true;
                }
            }
        }
        memo[start] = 0;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
