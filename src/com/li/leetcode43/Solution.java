package com.li.leetcode43;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author lichenxu
 *  * @version V1.0
 *  * @Package com.li.leetcode43
 *  * @date 2020/9/21 17:54
 *  * @example:
 *  * @Description:
 *  * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *  *
 *  * 说明：
 *  * num1 和 num2 的长度小于110。
 *  * num1 和 num2 只包含数字 0-9。
 *  * num1 和 num2 均不以零开头，除非是数字 0 本身。
 *  * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *  *
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/multiply-strings
 *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 不能使用BigInteger
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        int arr1_length = arr1.length;
        int arr2_length = arr2.length;
        int numlength = arr1_length+arr2_length-2;
        BigInteger res = new BigInteger("0");

        for (int i=0;i<arr2_length;i++){
            BigInteger mul2 = new BigInteger(String.valueOf(arr2[i]));
            for (int j = 0;j<arr1_length;j++){
                BigInteger mul1 = new BigInteger(String.valueOf(arr1[j]));
                BigInteger power = new BigInteger("1");
                for(int k=0; k<numlength-i-j; k++){
                    power = power.multiply(new BigInteger("10"));
                }
                res = res.add(power.multiply(mul1.multiply(mul2)));
            }
        }

        return res+"";
    }
    public static String multiply1(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
            char[] arr2 = num2.toCharArray();

            int arr1_length = arr1.length;
            int arr2_length = arr2.length;
            int numlength = arr1_length+arr2_length-2;
            StringBuffer res = new StringBuffer();

            for (int i = arr2_length-1;i>=0;i--){
            int mul2 = arr2[i]-'0';
            for (int j = arr1_length-1;j>=0;j--){
                int mul1 =arr1[j]-'0';
                BigInteger power = new BigInteger("1");
                for(int k=0; k<numlength-i-j; k++){
                    power = power.multiply(new BigInteger("10"));
                }
//                res = res.add(power.multiply(mul1.multiply(mul2)));
            }
        }

        return res+"";
    }
    public static void main(String[] args) {
        System.out.println(multiply("123456789","987654321"));
    }
}
