package com.sayan.leetcode.arrays.easy;

@SuppressWarnings(value = { "unused" })
public class NumbersWithEvenDigits {
	
	
	//static int result,countOfDigits;
	
	private static int findNumbers(int[] nums) { 
		
		/* result holds the number of numbers with even number of digits
	     * countOfDigits holds the number of digits in each number
	     */
		int result=0,countOfDigits=0;
        
        /* run a loop from start to end of input
         * for each input, check if the number is greater than zero.
         * if yes, divide the number by 10 . The quotient will be one digit less than the input
         * increment countOfDigits by 1.
         */
        for(int index=0;index<nums.length;index++){            
            
            while(nums[index]>0){
                nums[index]/=10;
                countOfDigits++;
            }
            if(countOfDigits%2==0) {result++;}
            
			countOfDigits=0;
        }        
        return result;
    }
	
	private static int findNumbersLog(int[] nums) {
		
		int result=0,countOfDigits=0;
		
		for(int index=0;index<nums.length;index++) {
			/* The number of digits in a non-negative number is 
			 * one more than the integer part (characteristic) of the 
			 * logarithm to the base 10 of the number.
			 */
			countOfDigits=(int)Math.floor(Math.log10((int)nums[index]))+1;
			if(countOfDigits%2==0) {result++;}
			countOfDigits=0;
		}
		return result;		
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 201, 1986, 34250, 897560};
		
		//System.out.println(findNumbers(arr));
		System.out.println(findNumbersLog(arr));
		//NumbersWithEvenDigits numbersWithEvenDigits=new NumbersWithEvenDigits();

	}

}
