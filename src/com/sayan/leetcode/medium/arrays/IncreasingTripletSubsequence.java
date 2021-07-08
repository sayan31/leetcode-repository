package com.sayan.leetcode.medium.arrays;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        IncreasingTripletSubsequence obj = new IncreasingTripletSubsequence();
        System.out.println(obj.increasingTriplet(new int[]{2,1,5,0,4,6}));
    }

    public boolean increasingTriplet(int[] nums) {
        int firstOfTriplet = Integer.MAX_VALUE, secondOfTriplet = Integer.MAX_VALUE;
        for(int num: nums){
            firstOfTriplet = Math.min(firstOfTriplet, num);
            if(num > firstOfTriplet)
                secondOfTriplet = Math.min(secondOfTriplet, num);
            if(num > secondOfTriplet)
                return true;
        }
        return false;
    }
}
