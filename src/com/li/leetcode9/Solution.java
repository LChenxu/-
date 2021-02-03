package com.li.leetcode9;

import java.util.LinkedList;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.li.leetcode9
 * @date 2021/1/8 19:19
 * @example:
 * @Description:
 */
public class Solution {
    /**
     * 垃圾解法
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<Character> list1 = new LinkedList<>();

        String s = new Integer(x).toString();
        boolean iso = s.length() % 2 == 1 ? false : true;
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        int quickPointer = 0;
        int slowPointer = 0;
        if (iso) {
            for (; quickPointer < s.length() - 2; ) {
                quickPointer = quickPointer + 2;
                slowPointer++;
            }
        } else {
            for (; quickPointer < s.length() - 1; ) {
                quickPointer = quickPointer + 2;
                slowPointer++;
            }
        }
        for (int i = slowPointer + 1; i < s.length(); i++) {
            list1.addFirst(s.charAt(i));
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list.get(i).equals(list1.get(i))) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome1(int x) {
        //排除负数和个位是0的数字
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        //源数字不断%10然后/10，新数字不断拿余数然后*10，知道源数字<=新数字
        int newNum = 0;
        while (x > newNum) {
            int mod = x % 10;
            x = x / 10;
            newNum = newNum * 10 + mod;
        }
        return newNum == x || newNum / 10 == x;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome1(1234321));
    }
}
