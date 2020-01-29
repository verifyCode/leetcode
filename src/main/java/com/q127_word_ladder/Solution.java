package com.q127_word_ladder;


import java.util.*;

/**
 * @author xjn
 * @since 2020-01-26
 * https://leetcode-cn.com/problems/word-ladder/
 * 127. 单词接龙
 */
public class Solution {
    private class Node {
        String word;
        int step;

        public Node(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    //TODO
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

}
