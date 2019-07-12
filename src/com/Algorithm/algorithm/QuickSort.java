package com.Algorithm.algorithm;

/**
 * @ClassName: QuickSort
 * @Description: 实现快速排序
 * @Author: xinyuan
 * @CreateDate: 2019/7/10 15:59
 */
public class QuickSort {
    /***
     * 快速排序算法
     * @param arr
     * @param begin
     * @param end
     */
    public void quickSort(int[] arr, int begin, int end) {

        //基线条件，数组为空或者就是一个或者起始小于结束
        if (arr == null || arr.length <= 1 || begin >= end) {
            return;
        }
        //指定一个基准值
        int mid = arr[begin];
        //把begin和end存下来，作为递归的赋值
        int left = begin;
        int right = end;
        while (left < right) {
            while (left < right && arr[right] >= mid) {
                right--;
            }
            if (left < right && arr[right] < mid) {
                arr[left] = arr[right];
                left++;
            }
            while(left < right && arr[left] <= mid){
                left++;
            }
            if(left < right && arr[left] > mid){
                arr[right] = arr[left];
                right--;
            }
        }
        //不要忘记最后还有中间的一个坑需要填上
        arr[left] = mid;
        quickSort(arr, begin, left-1);
        quickSort(arr, left+1,end);
    }


    public void print(int[] arr){
        String s = "";
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 3, 2, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr,0,5);
        quickSort.print(arr);
    }
}
