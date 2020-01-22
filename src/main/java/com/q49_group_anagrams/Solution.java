package com.q49_group_anagrams;

import java.util.*;

/**
 * @author xjn
 * @since 2020-01-22
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<>();
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            addList(map, chars, strs[i]);
        }

        Set<String> set = map.keySet();
        for (String s : set) {
            List<String> list = map.get(s);
            if (list != null && list.size() > 0) {
                resList.add(list);
            }
        }
        return resList;
    }

    public void addList(Map<String, List<String>> map, char[] chars, String str) {
        String key = new String(chars);
        if (map.containsKey(key)) {
            List<String> list = map.get(key);
            list.add(str);
        } else {
            List<String> list = new ArrayList<>();
            list.add(str);
            map.put(key, list);
        }
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
