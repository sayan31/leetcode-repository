package com.sayan.leetcode.medium.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for (int[] row: dp) {
            Arrays.fill(row,-1);
        }
        return lisHelper(nums,dp,nums.length-1,nums.length);
    }

    private static int lisHelper(int[] nums,int[][] dp, int currIdx, int prevIdx){
        if (currIdx==-1){return 0;}

        if(dp[currIdx][prevIdx]!=-1){return dp[currIdx][prevIdx];}

        int include = 0;
        if(prevIdx==nums.length || nums[prevIdx]>nums[currIdx]){
            include= 1+lisHelper(nums,dp,currIdx-1,currIdx);
        }
        int exclude= lisHelper(nums,dp,currIdx-1,prevIdx);

        dp[currIdx][prevIdx]=Math.max(exclude,include);

        return dp[currIdx][prevIdx];
    }

    public static void main(String[] args) {
        //System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        //System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        //System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
        //System.out.println(lengthOfLIS(new int[]{1,4,1,5,6,5}));
        System.out.println(lengthOfLIS(new int[]{10}));
    }
}
