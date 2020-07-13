package com.q0401_binary_watch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-01
 * https://leetcode-cn.com/problems/binary-watch/
 * 401. 二进制手表
 */
public class Solution2 {
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    list.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.readBinaryWatch(2));
    }
}
