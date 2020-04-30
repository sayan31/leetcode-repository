package com.sayan.leetcode.arrays.easy;

public class CreateTargetArray {
	
	/**
	 * @param nums: input array of numbers
	 * @param index: input array of indices
	 * @return target array containing with element at index[i] holding the value nums[i]
	 */
	private static int[] createTargetArray(int[] nums, int[] index) {
		/* Create the target array
		 * Target array has the same length as original array 
		 */
		int[] target = new int[nums.length];
		 
		int temp;
		
		/* Run a loop for the length of the nums array  
		 */
		for(int itr=0;itr<nums.length;itr++) {						
			//copy the value in the nums array at current index to the temp variable
			temp=nums[itr];				
			//shift array elements to the right by 1, starting from insert position
			target=shift(target,index[itr]);
			//replace the value at insert position with the value in temp variable
			target[index[itr]]=temp;			
		}
		return target;		
	}

	/**
	 * @param target: array for which elements need to be shifted
	 * @param start: index from which the shifting has to happen
	 * @return the array with the required shifts of places 
	 */
	private static int[] shift(int[] target, int start) {
		//Run a loop from the last but one element in the input array to the insert position
		for(int idx=target.length-2;idx>=start;idx--) {
			//copy over the element at current index to the next index
			target[idx+1]=target[idx];
		}
		return target;
	}

	public static void main(String[] args) {		
		int[] nums =  new int[] {0,1,2,3,4};
		int[] index =  new int[] {0,1,2,2,1};
		
		int[] result = createTargetArray(nums,index);
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}
}
