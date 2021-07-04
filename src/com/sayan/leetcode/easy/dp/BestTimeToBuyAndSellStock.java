package com.sayan.leetcode.easy.dp;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minUptoCurrent=Integer.MAX_VALUE,maxProfit=Integer.MIN_VALUE;
        if(prices.length==1){return 0;}
        for(int i=0;i<prices.length;i++){
            minUptoCurrent=Math.min(minUptoCurrent,prices[i]);
            maxProfit=Math.max(maxProfit,prices[i]-minUptoCurrent);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
        System.out.println("Max profit to be made with the given values is: "+obj.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
