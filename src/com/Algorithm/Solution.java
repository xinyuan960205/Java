package com.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * @ClassName: javatest
 * @Description: 测试两个排序数组的中位数
 * @Author: xinyuan
 * @CreateDate: 2018/9/30 17:45
 */
public class Solution {
    public double findMedianSortedArrays() {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        int lengthAll = nums1.length+nums2.length;
        int[] nums = new int[lengthAll];
        int No1=0;
        int No2=0;
        int nums1No=0;
        int nums2No=0;
        if(lengthAll%2 != 0){
            No1 = lengthAll/2;
            No2 = lengthAll/2;
        }else{
            No1 = (lengthAll/2)-1;
            No2 = lengthAll/2;
        }
        for(int i=0;i<No2+1;i++){
            if(nums1No >= nums1.length){
                nums[i]=nums2[nums2No];
                nums2No++;
            }else if(nums2No >= nums2.length){
                nums[i]=nums1[nums1No];
                nums1No++;
            }
            else{
                if(nums1[nums1No]<=nums2[nums2No]){
                    nums[i]=nums1[nums1No];
                    nums1No++;
                }else{
                    nums[i]=nums2[nums2No];
                    nums2No++;
                }
            }
        }
        double middleNum = ((double) nums[No1] + nums[No2])/2;
        return middleNum;
    }
}