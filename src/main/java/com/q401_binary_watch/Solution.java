package com.q401_binary_watch;


import java.util.*;

/**
 * @author xjn
 * @since 2020-02-01
 * https://leetcode-cn.com/problems/binary-watch/
 * 401. 二进制手表
 * //TODO
 */
public class Solution {

    private int[] times = new int[]{
            8 * 60, 4 * 60, 2 * 60, 1 * 60,
            32, 16, 8, 4, 2, 1
    };

    private List<String> resList = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        resList.clear();
        if (num == 0) {
            resList.add("0:00");
            return resList;
        }
        readBinaryWatch(num, 0, new ArrayList<>());
        Collections.sort(resList);
        return resList;
    }

    private void readBinaryWatch(int num, int start, List<Integer> list) {
        if (num == list.size()) {
            String convert = convert(list);
            if (convert != null) {
                resList.add(convert);
            }
            return;
        }

        for (int i = start; i < times.length; i++) {
            list.add(times[i]);
            readBinaryWatch(num, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    private String convert(List<Integer> list) {
        int minutes = 0;
        for (Integer m : list) {
            minutes += m;
        }
        int hour = minutes / 60;
        minutes = minutes % 60;
        return String.format("%d:%02d", hour, minutes);
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        List<String> list = test.readBinaryWatch(4);
    }


}

