package com.sayan.leetcode.dp.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private static int lengthOfLISBinarySearch(int[] nums){
        List<Integer> answerList = new ArrayList<>();
        answerList.add(nums[0]);

        for(int i=1;i<nums.length;i++){
            if (nums[i]>answerList.get(answerList.size()-1)) {
                answerList.add(nums[i]);
            }else{
                int insertIdx = binarySearch(answerList, nums[i]);
                answerList.set(insertIdx, nums[i]);
            }
        }
        return answerList.size();
    }

    private static int binarySearch(List<Integer> answerList, int target) {
        int start=0, end=answerList.size()-1;
        while (start<=end) {
            int middle = start + (end-start)/2;

            if (target==answerList.get(middle)) {
                return middle;
            }else if (target>answerList.get(middle)) {
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        //System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        //System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        //System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
        //System.out.println(lengthOfLIS(new int[]{1,4,1,5,6,5}));
        //System.out.println(lengthOfLIS(new int[]{10}));
        System.out.println(lengthOfLISBinarySearch(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }
}
