package com.henrywuu.algorithm;

public class ShellSort {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 9, 4, 2, 1, 5, 5, 10, 13};
        shellSort(nums);
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

    public static void shellSort(int[] nums) {
        // 1. 参数检查
        if (null == nums || nums.length <= 1) {
            return;
        }

        // 2. 逻辑实现
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < nums.length; j += gap) {
                    if (nums[j] < nums[j - gap]) {
                        int k;
                        int tmp = nums[j];
                        for (k = j - gap; k >= 0 && nums[k] > tmp; k -= gap) {
                            nums[k + gap] = nums[k];
                        }
                        nums[k + gap] = tmp;
                    }
                }
            }
        }


    }

}
