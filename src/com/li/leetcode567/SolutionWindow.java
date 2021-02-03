package com.li.leetcode567;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.li.leetcode567
 * @date 2021/1/6 20:36
 * @example:
 * @Description:
 */
public class SolutionWindow {
    /**
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            佛祖保佑       永无BUG
**/
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1arr = new int[26];
        int[] s2arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1arr[s1.charAt(i) - 'a']++;
            s2arr[s2.charAt(i) - 'a']++;
        }

        for (int start = 0; start < s2.length() - s1.length(); start++) {
            if (matches(s1arr, s2arr)) {
                return true;
            }
            s2arr[s2.charAt(start + s1.length()) - 'a']++;
            s2arr[s2.charAt(start) - 'a']--;
        }
        return matches(s1arr, s2arr);
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
