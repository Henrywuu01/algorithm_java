package com.henrywuu.algorithm;


public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 9, 1, 4, 2, 3, 10, 19, 11};
        boolean reverseFlag = false;
        bubbleSort(nums, reverseFlag);
        printNums(nums);
    }

    public static void printNums(int[] nums) {
        for (int i: nums) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] nums, boolean reverseFlag) {
        // 1. 参数检查
        if (null == nums || nums.length <= 1) {
            return;
        }

        // 2. 逻辑实现
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int tmp = nums[i];
                if (reverseFlag) {
                    if (nums[i] < nums[j]) {
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                } else {
                    if (nums[i] > nums[j]) {
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }
        }

    }

}
