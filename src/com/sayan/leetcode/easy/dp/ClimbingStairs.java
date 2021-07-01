package com.sayan.leetcode.easy.dp;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] res = new int[n+1];
        res[0]=res[1]=1;
        for(int i=2;i<=n;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        System.out.println("Ways of climbing the given number of stairs: "+obj.climbStairs(10));
    }
}
