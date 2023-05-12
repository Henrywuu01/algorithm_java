package com.henrywuu.leetcode;

import java.util.Stack;

public class Code0511 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 6};
        System.out.println(climbStairs(10));
    }

    public static ListNode deleteDuplicate(ListNode head) {
        if (null == head.next) {
            return head;
        }
        if (head.val == head.next.val) {
            head.next = head.next.next;
            deleteDuplicate(head);
        } else {
            deleteDuplicate(head.next);
        }
        return head;
    }

    public static int climbStairs(int n) {
        // 0: 1
        // 1: 1
        // 2: 2
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    public static String addBinary(String a, String b) {
        if (null == a) {
            return b;
        }
        if (null == b) {
            return a;
        }

        int maxLen = a.length();
        if (maxLen < b.length()) {
            maxLen = b.length();
        }

        // 对齐长度
        StringBuilder aBuilder = new StringBuilder(a);
        for (int i = 0; i < maxLen - a.length(); i++) {
            aBuilder.insert(0, "0");
        }
        a = aBuilder.toString();
        StringBuilder bBuilder = new StringBuilder(b);
        for (int i = 0; i < maxLen - b.length(); i++) {
            bBuilder.insert(0, "0");
        }
        b = bBuilder.toString();

        int tmp = 0;
        Stack stack = new Stack();
        for (int i = maxLen - 1; i >= 0; i--) {
            int a1 = Integer.parseInt("" + a.charAt(i));
            int b1 = Integer.parseInt("" + b.charAt(i));
            int sum = a1 + b1 + tmp;
            if (a1 + b1 + tmp >= 2) {
                stack.push(sum % 2);
                tmp = 1;
            } else {
                stack.push(sum);
                tmp = 0;
            }
        }
        if (tmp == 1) {
            stack.push(tmp);
        }

        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;

    }

    public static int[] plusOne(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new int[]{1};
        }

        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] < 9) {
                nums[i] = nums[i] + 1;
                return nums;
            } else {
                nums[i] = 0;
            }
        }

        int[] res = new int[nums.length + 1];
        res[0] = 1;
        res[1] = 0;
        for (int i = 1; i < nums.length; i++) {
            res[i+1] = nums[i];
        }
        return res;
    }

    public static int lengthOfLastWord(String s) {
        if (null == s || "".equals(s.strip())) {
            return 0;
        }
        String[] tmpArray = s.split(" ");
        String tmpStr = tmpArray[tmpArray.length - 1];
        return tmpStr.length();
    }

    public static int searchInsert(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else if (target < nums[i]) {
                return i;
            } else {
                continue;
            }
        }
        return nums.length + 1;

    }


    public static int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    public static int removeDuplicates(int[] nums) {
        // 1. 参数检查
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        // 2. 逻辑实现
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[idx]) {
                continue;
            }
            idx += 1;
            nums[idx] = nums[i];
        }
        return idx + 1;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
