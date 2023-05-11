package com.henrywuu.leetcode;

import javax.xml.stream.FactoryConfigurationError;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Code0509 {

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String str) {
        // 1. 参数检查
        if (null == str || "".equals(str.strip())) {
            return true;
        }
        if (!str.contains("(") && !str.contains(")")
                && !str.contains("[") && !str.contains("]")
                && !str.contains("{") && !str.contains("}")) {
            return true;
        }

        Stack stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (c == '(' || c== ')' || c == '[' || c == ']' || c == '{' || c == '}') {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    char tmp = (char) stack.pop();
                    String tmpStr = "" + tmp + c;
                    if ("()".equals(tmpStr) || "[]".equals(tmpStr) || "{}".equals(tmpStr)) {
                    } else {
                        stack.push(tmp);
                        stack.push(c);
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static String getCommonPrefix(String[] strs) {
        // 1. 参数检查
        if (null == strs || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        // 2. 逻辑实现
        int len = strs[0].length();
        for (String s: strs) {
            if (s.length() < len) {
                len = s.length();
            }
        }
        for (int i = 0; i <= len; i++) {
            boolean flag = true;
            String tmp = strs[0].substring(0, i);
            for (String s: strs) {
                if (!s.startsWith(tmp)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                return strs[0].substring(0, i-1);
            }
        }
        return  strs[0].substring(0, len);
    }


    public static int romanToInt(String s) {
        Map<Character, Integer> symbolValue = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int value = symbolValue.get(s.charAt(i));
            if (i < n - 1 && value < symbolValue.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    public static boolean isPalindrome(int num) {
        // 1. 参数检查
        if (num < 0) {
            return false;
        } else if (num < 10) {
            return true;
        }

        // 2. 逻辑实现
        String numOri = "" + num;
        char[] charsOri = numOri.toCharArray();
        int length = charsOri.length;

        char[] charsReverse = new char[length];
        for (int i = length - 1; i >= 0; i--) {
            int idx = length - 1 - i;
            charsReverse[idx] = charsOri[i];
        }
        String numReverse = new String(charsReverse);
        if (numReverse.equals(numOri)) {
            return true;
        }

        return false;
    }

    public static int[] getSumIndexV2(int[] nums, int target) {
        // 1. 参数检查
        if (null == nums || nums.length < 2) {
            return null;
        }

        // 2. 逻辑实现
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public static int[] getSumIndex(int[] nums, int target) {
        // 1. 参数检查
        if (null == nums || nums.length < 2) {
            return null;
        }

        // 2. 逻辑实现
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }



    public static int countTime(String time) {
        // 1. 参数检查
        if (null == time || "".equals(time.strip())) {
            return 0;
        }
        if (time.length() != 5 || time.indexOf(":") != 2) {
            return 0;
        }
        if (!time.contains("?")) {
            return 1;
        }

        // 2. 逻辑实现
        int count = 1;
        char h1 = time.charAt(0);
        char h2 = time.charAt(1);
        char m1 = time.charAt(3);
        char m2 = time.charAt(4);
        if ('?' == h1 && '?' == h2) {
            count *= 24;
        } else if ('?' == h1) {
            if (h2 >= '4') {
                count *= 2;
            } else {
                count *= 3;
            }
        } else if ('?' == h2) {
            if ('2' == h1) {
                count *= 4;
            } else {
                count *= 10;
            }
        }
        if ('?' == m1 && '?' == m2) {
            count *= 60;
        } else if ('?' == m1) {
            count *= 6;
        } else if ('?' == m2) {
            count *= 10;
        }

        return count;
    }

}
