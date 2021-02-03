package com.li.leetcode567;

import java.util.*;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.li
 * @date 2021/1/6 16:42
 * @example:
 * @Description:
 */
public class Solution {
    /**
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     */
    public static boolean checkInclusion(String s1, String s2) {
        // 做好界线判定
        if (s1 == null || s1.equals("") || s2 == null || s2.equals("")) {
            return false;
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        //排列的意思好像是只要s2中连续s1长度的子串，和s1的元素相同即可，但是不可是和s1中的某一元素多次重复
        int s1Len = s1.length();//这个就是窗口，而且是固定大小的窗口
        HashSet<Integer> set = new HashSet<>();
        Map<Integer, Character> map = new HashMap<>(s1Len);
        for (int i = 0; i < s1Len; i++) {
            map.put(i, s1.charAt(i));
        }
//        int start = 0;
        for (int start = 0; start < s2.length()-s1Len+1; start++) {
            String s = s2.substring(start, start + s1Len);
            if (s.length()<s1Len){return false;}
            for (int i = 0; i < s1Len; i++) {
                for (Integer key : map.keySet()) {
                    if (s.charAt(i) == map.get(key)) {
                        set.add(key);
                        break;
                    }
                }
            }
            if (set.size() == s1Len) {
                return true;
            } else {
                set.clear();
            }

        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(checkInclusion("hello","ooolleoooleh"));
    }
}
