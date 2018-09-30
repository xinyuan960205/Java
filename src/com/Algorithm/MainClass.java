package com.Algorithm;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @ClassName: MainClass
 * @Description: 测试两个排序数组的中位数
 * @Author: xinyuan
 * @CreateDate: 2018/9/30 17:47
 */
public class MainClass{
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String doubleToString(Double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[] nums1 = stringToIntegerArray(line);
//            line = in.readLine();
//            int[] nums2 = stringToIntegerArray(line);
//
            double ret = new Solution().findMedianSortedArrays();

            String out = doubleToString(ret);

            System.out.print(out);

        }
    }


