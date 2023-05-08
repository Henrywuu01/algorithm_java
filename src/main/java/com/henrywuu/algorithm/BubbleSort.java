package com.henrywuu.algorithm;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 9, 2, 7, 4, 3, 15};
        printArray(nums);
        bubbleSortV1(nums);
        printArray(nums);

    }

    public static void printArray(int[] arrays) {
        for (int i: arrays) {
            System.out.println(i);
        }
    }

    public static void bubbleSortV1(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

}
