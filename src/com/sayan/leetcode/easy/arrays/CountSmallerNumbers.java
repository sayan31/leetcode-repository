package com.sayan.leetcode.easy.arrays;

public class CountSmallerNumbers {
	
	private static int[] smallerNumbersThanCurrent(int[] nums) {
		/*An array that stores the number of times each element occurs in the input.
         *The length of this array should be the upper bound of possible values in the input.
         */
        int[] freqArray=new int[101];
        
        /* Run a loop from the beginning to the end of the input array.
         * For each number in the input, increment corresponding index
         * in freqArray by 1.
         * Each index of the freqArray represents the actual number in the input array.
         * Value at each index in freqArray represents count of the index in the input array.
         */
        for(int counter=0;counter<nums.length;counter++){
            freqArray[nums[counter]]++;
        }
        
        /*Run a loop from the second index to the end of freqArray.
         *Replace the current value at each index with the sum of the current value and the value 
         *at the previous index position.
         *This makes the value at each index equal to the number of elements <= the current index
         *(which represents a number in the input array)
         */
        for(int freqArrayCounter=1;freqArrayCounter<=100;freqArrayCounter++){
            freqArray[freqArrayCounter]=freqArray[freqArrayCounter] + freqArray[freqArrayCounter-1];
        }
        
        /* Run a loop from the beginning to the end of the input array.
         * For each element in input, replace it with the corresponding value in the 
         * freqArray after decrementing it by 1.
         * The decrement is required because we need the count of numbers less than each
         * input, while the freqArray now holds the count of numbers <= each input number.
         */
        for(int index=0;index<nums.length;index++){
            //This check is needed.
            //Reason 1: 0 is the least possible number in the input. We know that no input is less than it.
            //Reason 2: freqArray[nums[index]-1] will give Index out of bounds if any element is 0, w/o this
            //check.
            if(nums[index]!=0){
                nums[index]=freqArray[nums[index]-1];
            }            
        }
        
        //Finally, return the nums array which now contains the required counts.
        return nums;
        
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 1};
		int arrcount[] = smallerNumbersThanCurrent(arr);
		
		for (int i = 0; i < arrcount.length; i++) {
			System.out.print(arrcount[i]);
		}
		
	}

}
