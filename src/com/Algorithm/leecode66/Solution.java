package com.Algorithm.leecode66;

/**
 * @ClassName: Solution
 * @Description: java类作用描述
 * @Author: xinyuan
 * @CreateDate: 2019/7/9 10:49
 */
public class Solution {
    public int[] plusOne(int[] digits) {

        //获得总数字
        int i1 = digits.length - 1;
        int i = 0;
        int number = 0;
        while (i < digits.length) {
            number = (int) (number + (digits[i] * Math.pow(10, i1--)));
            i++;
        }
        //加一
        number++;
        //将数字转为数组
        int number1 = number;
        int length = String.valueOf(number1).length();
        int[] digits_output = new int[length];   //输出数组
        int j = 1;
        int num = 0;//取余数
        while (number > 0) {
            num = number % 10;
            digits_output[--length] = num;
            number = (int) (number / 10);
            j++;
        }

        return digits_output;
    }

    public static void main(String[] args) {
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        Solution solution = new Solution();
        int[] digits_output = solution.plusOne(digits);
    }
}
