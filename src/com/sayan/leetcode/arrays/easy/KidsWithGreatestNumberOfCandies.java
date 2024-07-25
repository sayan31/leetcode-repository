package com.sayan.leetcode.arrays.easy;

import java.util.*;

public class KidsWithGreatestNumberOfCandies {
	
	private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		/*Initialize the maxCandy variable to hold the max value in the candies array
		 *Initialize the result boolean list to hold the final result. 
		 */
        int maxCandy=Integer.MIN_VALUE;
        List<Boolean> result =  new ArrayList<>();
        
        //Loop over all values of the candies array
        for(int candy:candies){
        	/* update the maxCandy variable to the current value of candy
        	 * if it is greater than maxCandy        
        	 */        	
            if(maxCandy<candy){maxCandy=Math.max(maxCandy,candy);}
        }
      //Loop over all values of the candies array
        for(int candy:candies){
        	/* append true to result if the difference of maxCandy & extraCandies
        	 * is less than or equal to the current value of candy.
        	 * This is equivalent to calculating if the sum of candy and extraCandies 
        	 * is greater than or equal to maxCandy.
        	 */
            result.add(maxCandy-extraCandies<=candy);
        }
        return result;
    }

	public static void main(String[] args) {
		int[] arr = new int[] { 4,2,1,1,2};
		int num = 1;
		
		System.out.println(kidsWithCandies(arr,num));
	}

}
