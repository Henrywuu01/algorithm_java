package com.henrywuu.algorithm;

public class InsertSort {

    public static void main(String[] args) {
        int[] nums = new int[]{9, 5, 4, 1, 3, 6, 10};
        insertSort(nums);
        printNums(nums);
    }

    public static void printNums(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        for (int i : nums) {
            System.out.print(i + "\t");
        }
        System.out.println("\n");
    }

    public static void insertSort(int[] nums) {
        // 1. 参数检查
        if (null == nums || nums.length <= 1) {
            return;
        }

        // 2. 逻辑实现
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                int tmp = nums[i];

                int j;
                for (j = i - 1; j >= 0 && nums[j] > tmp; j--) {
                    nums[j+1] = nums[j];
//                    printNums(nums);
                }
                nums[j+1] = tmp;
            }
        }
    }

}
