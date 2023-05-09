package com.henrywuu.algorithm;

public class SelectSort {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 9, 2, 3, 1, 10, 7};
        printNums(nums);
        selectSort(nums);
    }

    public static void printNums(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        for (int i : nums) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }


    public static void selectSort(int[] nums) {
        // 1. 参数检查
        if (null == nums || nums.length <= 1) {
            return;
        }

        // 2. 逻辑实现
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx =j;
                }
            }
            if (i != minIdx) {
                int tmp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = tmp;
            }
            printNums(nums);
        }

    }

}
