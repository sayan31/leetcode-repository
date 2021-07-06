package com.sayan.leetcode.medium.dp;

import java.util.Arrays;

public class CoinChange {
    private static int minNoOfCoins(int[] coins,int amount) {
        int len = coins.length;

        int[][] dp = new int[len +1][amount+1];
        for(int[] row: dp)
            Arrays.fill(row,-1);

        int ans= minNoOfCoinsHelper(dp,coins,amount, len);
        return ans==Integer.MAX_VALUE-1?-1:ans;
    }

    private static int minNoOfCoinsHelper(int[][] dp, int[] coins,int amount,int currLen){

        if(amount==0)
            return 0;

        if(currLen==0)
            return Integer.MAX_VALUE-1;

        if(currLen==1)
            if(amount % coins[currLen-1] != 0)
                return Integer.MAX_VALUE-1;

        if(dp[currLen-1][amount]!=-1)
            return dp[currLen-1][amount];

        if(amount>=coins[currLen-1])
            dp[currLen-1][amount]= Math.min(1+minNoOfCoinsHelper(dp,coins,amount-coins[currLen-1],currLen),
                    minNoOfCoinsHelper(dp,coins,amount,currLen-1));
        else
            dp[currLen-1][amount]=minNoOfCoinsHelper(dp,coins,amount,currLen-1);

        return dp[currLen-1][amount];
    }

    public static void main(String[] args) {
        //System.out.println(minNoOfCoins(new int[]{1,2,5},11));
        //System.out.println(minNoOfCoins(new int[]{2},3));
        //System.out.println(minNoOfCoins(new int[]{1},0));
        //System.out.println(minNoOfCoins(new int[]{1,2,3},5));
        //System.out.println(minNoOfCoins(new int[]{1},1));
        System.out.println(minNoOfCoins(new int[]{7,2,3,6},13));
        //System.out.println(minNoOfCoins(new int[]{3,4,5},4));
        //System.out.println(minNoOfCoins(new int[]{49,22,45,6,11,20,30,10,46,8,32,48,2,41,43,5,39,16,28,44,14,4,27,36},15));
    }

}
