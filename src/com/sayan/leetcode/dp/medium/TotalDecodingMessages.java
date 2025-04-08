package com.sayan.leetcode.dp.medium;

public class TotalDecodingMessages {
    public static void main(String[] args) {
        String s = "90";
        System.out.println(countWays(s)); // Output: 3
    }

    private static int countWays(String s) {
        return countWaysHelper(s, s.length()-1);
    }

    private static int countWaysHelper(String s, int currIdx) {

        if (currIdx < 0) {
            return 0;
        }

        if (currIdx == 0) {
            return s.charAt(currIdx) == '0' ? 0 : 1;
        }

        // if (s.charAt(currIdx) == '0') {
        //     return countWaysHelper(s, currIdx - 1);
        // }

        int count = 0;
        
        if(s.charAt(currIdx) != '0') {
            count = countWaysHelper(s, currIdx - 1);
        }

        if (isValid(s, currIdx - 1)) {
            count += countWaysHelper(s, currIdx - 2);
        }

        return count;
        
    }

    private static boolean isValid(String s, int i) {
        int num = Integer.parseInt(s.substring(i, i + 2));
        return num >= 10 && num <= 26;
    }
}
