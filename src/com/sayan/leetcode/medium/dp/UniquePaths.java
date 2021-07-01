package com.sayan.leetcode.medium.dp;

import java.util.Arrays;

public class UniquePaths {
    public static int[][] dp = new int[101][101];

    public int uniquePaths(int m, int n, int[][] dp) {
        if(m==1 || n==1)
            return 1;

        if(dp[m][n]!=-1) return dp[m][n];

        dp[m][n] = uniquePaths(m,n-1,dp)+uniquePaths(m-1,n,dp);

        return dp[m][n];
    }

    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();

        for (int[] row: dp)
            Arrays.fill(row,-1);

        System.out.println(obj.uniquePaths(3,7, dp));
    }
}
