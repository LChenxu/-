package com.li.leetcode567;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.li.leetcode567
 * @date 2021/1/6 20:12
 * @example:
 * @Description:
 */
public class SolutionArray {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.equals("") || s2 == null || s2.equals("")) {
            return false;
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1arr[s1.charAt(i) - 'a']++;
        }

        for (int start = 0; start <= s2.length() - s1.length(); start++) {
            int[] s2arr = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                s2arr[s2.charAt(start + i) - 'a']++;
            }
            if (matches(s1arr, s2arr)) {
                return true;
            }
        }
        return false;
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < s1map.length; i++) {
            if (s1map[i] != s2map[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("asdafafa", "fbfdfdgsdgfdsgsd"));
    }

}
