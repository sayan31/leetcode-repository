package com.sayan.leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class DecompressRLEList {

	/*
	 * First solution - w/o using ArrayList.
	 */
	static int[] decompressRLElist(int[] nums) {
		int drleLength = 0;
		for (int index = 0; index <= nums.length - 2; index += 2) {
			drleLength = drleLength + nums[index];
		}

		int[] decompressed = new int[drleLength];
		int dIndex = 0;

		for (int index = 0; index <= nums.length - 2; index += 2) {
			while (nums[index] > 0) {
				// array[index++] -> increment index after executing current statement
				decompressed[dIndex++] = nums[index + 1];
				--nums[index];
			}
		}
		return decompressed;
	}

	/*
	 * Second solution - using ArrayList
	 */
	static int[] decompressRLElistArrayList(int[] nums) {

		// create a list to hold the decompressed output
		List<Integer> outputList = new ArrayList<Integer>();

		// loop from first freq to last freq value, step of 2 since
		// every alternate item is freq.
		for (int index = 0; index <= nums.length - 2; index += 2) {
			int freq = nums[index];
			// loop until current freq becomes 0
			while (freq > 0) {
				// keep adding the same val to the list
				outputList.add(nums[index + 1]);
				// decrement freq to keep the loop running
				--freq;
			}
		}

		int decompressed[] = new int[outputList.size()];

		for (int idx = 0; idx < outputList.size(); idx++) {
			decompressed[idx] = (int) outputList.get(idx);
		}

		return decompressed;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4 };
		int arrdec[] = decompressRLElist(arr);

		for (int i = 0; i < arrdec.length; i++) {
			System.out.print(arrdec[i]);
		}

	}

}
