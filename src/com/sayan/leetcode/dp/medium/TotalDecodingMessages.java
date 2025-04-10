package com.sayan.leetcode.dp.medium;

public class TotalDecodingMessages {
    public static void main(String[] args) {
        //String s = "36671106";
        //String s = "123";
        String s = "4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948";
        System.out.println(countWays(s)); 
    }

    private static int countWays(String s) {
        int[] memo = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            memo[i] = -1;
        }
        int countWaysMemo = countWaysHelperMemo(memo, s, s.length()-1);
        System.out.println("Memoization answer: " + countWaysMemo);

        int countWaysSpaceOptimized = countWaysHelperSpaceOptimized(s);
        System.out.println("Space Optimized answer: " + countWaysSpaceOptimized);
        return countWaysMemo;
    }

    private static int countWaysHelperSpaceOptimized(String s) {
        int len = s.length();
        
        if(len==0 || s.charAt(0)=='0') return 0;
        
        int second_prev=0, prev=1;
        
        for(int i=0;i<len;i++){
            int curr=0;
            
            if(s.charAt(i)!='0') curr+=prev;
            if(i>=1 && isValid(s, i-1)) curr+=second_prev;
            
            second_prev = prev;
            prev = curr;
        }
        
        return prev;
    }

    private static int countWaysHelperMemo(int[] memo, String s, int currIdx) {

        if (currIdx < 0) {
            return 1; // Base case: if we reach the beginning of the string, we have found a valid decoding.
        }

        if (currIdx == 0) {
            return memo[currIdx] = s.charAt(currIdx) == '0' ? 0 : 1; // If the first character is '0', return 0, else return 1.
        }

        if (memo[currIdx] != -1) {
            return memo[currIdx];           
        }

        int count = 0;
        
        if(s.charAt(currIdx) != '0') {
            count = countWaysHelperMemo(memo, s, currIdx - 1);
        }

        if (isValid(s, currIdx - 1)) {
            count += countWaysHelperMemo(memo, s, currIdx - 2);
        }

        return memo[currIdx] = count;
        
    }

    private static boolean isValid(String s, int i) {
        int num = Integer.parseInt(s.substring(i, i + 2));
        return num >= 10 && num <= 26;
    }
}
