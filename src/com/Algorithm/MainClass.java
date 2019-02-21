package com.Algorithm;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @ClassName: MainClass
 * @Description: 测试两个排序数组的中位数
 * @Author: xinyuan
 * @CreateDate: 2018/9/30 17:47
 */
public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String doubleToString(Double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public int removeDuplicates(int[] nums, int k) {
        int max = 0;    //记录最大值
        int index = 0;  //记录最大值所在的位置
        int length = nums.length;
        for (int a = 0; a < k; a++) {
            int no = 0;   //记录个数
            max = -9999;
            //找到最大值
            for (int j = 0; j < length; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                    index = no;
                }
                no++;
            }
            //将这个最大值删掉
            for (int i = index; i < length; i++) {
                if(i+1<length){
                    nums[i] = nums[i + 1];
                }
            }
            length--;
        }
        return max;
    }


    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[] nums1 = stringToIntegerArray(line);
//            line = in.readLine();
//            int[] nums2 = stringToIntegerArray(line);
//
        MainClass mainClass = new MainClass();
        int[] num = {5,2,4,1,3,6,0};
        int k = 4;
        mainClass.removeDuplicates(num,k);
        double ret = new Solution().findMedianSortedArrays();

        String out = doubleToString(ret);

        System.out.print(out);

    }
}


