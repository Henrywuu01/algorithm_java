package com.henrywuu.algorithm;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 9, 3, 2, 4, 7, 1};
        quickSort(nums, 0, nums.length-1);
        printNums(nums);
    }

    public static void printNums(int[] nums) {
        if (null == nums) {
            return;
        }

        for (int i : nums) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void quickSort(int[] nums, int idxBegin, int idxEnd) {
        // 1. 参数检查
        if (null == nums || nums.length <=1) {
            return;
        }
        if (idxBegin >= idxEnd) {
            return;
        }

        // 2. 逻辑实现
        int tmpBegin = idxBegin;
        int tmpEnd = idxEnd;
        int baseValue = nums[idxBegin];
        while (tmpBegin < tmpEnd) {
            while (tmpBegin < tmpEnd && nums[tmpEnd] >= baseValue) {
                tmpEnd --;
            }
            nums[tmpBegin] = nums[tmpEnd];

            while (tmpBegin < tmpEnd && nums[tmpBegin] <= baseValue) {
                tmpBegin ++;
            }
            nums[tmpEnd] = nums[tmpBegin];
        }
        nums[tmpBegin] = baseValue;
        quickSort(nums, idxBegin, tmpBegin);
        quickSort(nums, tmpBegin + 1, idxEnd);
    }

}
