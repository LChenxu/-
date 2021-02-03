package com.li.leetcode1;

import sun.applet.Main;

import java.util.HashMap;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.li.leetcode1
 * @date 2020/10/29 14:52
 * @example:
 * @Description:
 */
public class Demo {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{2, 7, 11, 15};
        int target = 13;
        int[] res = twoSum(arrays, target);
        if (res.length > 0){
            System.out.println("["+res[0]+", "+res[1]+"]");
        }
    }
}
