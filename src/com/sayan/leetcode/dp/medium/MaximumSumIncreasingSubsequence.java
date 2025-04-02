package com.sayan.leetcode.dp.medium;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        //System.out.println(maxSumIS(new int[]{1,101,2,3,100}));
        //System.out.println("Memoized answer: "+maxSumISMemo(new int[]{1,101,2,3,100}));

        System.out.println(maxSumIS(new int[]{ 1, 8, 3, 12, 2, 10, 4, 14, 2, 6, 6, 13, 2, 10}));
        System.out.println("Memoized answer: "+maxSumISMemo(new int[]{1, 8, 3, 12, 2, 10, 4, 14, 2, 6, 6, 13, 2, 10}));
    }

    private static int maxSumISMemo(int[] arr) {
        int[][] memo = new int[arr.length+1][arr.length+1];
        for (int[] row: memo) {
            Arrays.fill(row,-1);
        }
        return maxSumISHelperMemo(arr, memo, arr.length-1, arr.length);
    }

    private static int maxSumISHelperMemo(int[] arr, int[][] memo, int prevIdx, int currIdx){
        
        if (prevIdx == -1) {
            return 0;
        }

        if (memo[prevIdx][currIdx] != -1) {
            return memo[prevIdx][currIdx];
        }

        int sumIncludingCurr = 0;
        if (currIdx == arr.length || arr[prevIdx]<arr[currIdx]) {
            sumIncludingCurr = arr[prevIdx] + maxSumISHelperMemo(arr, memo, prevIdx-1, prevIdx);;           
        }

        int sumExcludingCurr = maxSumISHelperMemo(arr, memo, prevIdx-1, currIdx);;
        
        return memo[prevIdx][currIdx] = Math.max(sumIncludingCurr, sumExcludingCurr);
    }

    public static int maxSumIS(int[] arr){
        return maxSumISHelper(arr, 0, arr.length-1, arr.length);
    }

    private static int maxSumISHelper(int[] arr, int sum, int prevIdx, int currIdx){
        
        if (prevIdx == -1) {
            return sum;
        }

        int sumIncludingCurr = sum;
        if (currIdx == arr.length || arr[prevIdx]<arr[currIdx]) {
            sumIncludingCurr = maxSumISHelper(arr, sum+arr[prevIdx], prevIdx-1, prevIdx);;           
        }

        int sumExcludingCurr = maxSumISHelper(arr, sum, prevIdx-1, currIdx);;
        
        return Math.max(sumIncludingCurr, sumExcludingCurr);
    }
}
