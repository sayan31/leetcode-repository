package com.sayan.leetcode.medium.recursion;

public class FindMaximumNum {

	public static void main(String[] args) {
		/*
		 * Scanner sc = new Scanner(System.in); int t = sc.nextInt(); while (t-- > 0) {
		 * int k = sc.nextInt(); String str = sc.next(); Unique obj = new Unique();
		 * System.out.println(obj.findMaximumNum(str, k)); }
		 */

		String str = "61892795431";

		System.out.println(FindMaximumNumSolution.findMaximumNum(str, 4));
	}
}

class FindMaximumNumSolution {
	// Function to find the largest number after k swaps.
	public static String findMaximumNum(String str, int k) {
		// code here.

		char[] input = str.toCharArray();

		String ans = findMaximumNumHelper(str, input, 0, k);
		return ans;
	}

	private static String findMaximumNumHelper(String finalAns, char[] input, int currIdx, int swaps) {

		String currInput = new String(input);
		if (finalAns.compareTo(currInput) < 0)
			finalAns = currInput;

		// base condition
		if (swaps == 0 || currIdx == input.length) {
			return finalAns;
		}
		// end base condition

		char currMax = input[currIdx];
		for (int i = currIdx + 1; i < input.length; i++) {
			if (currMax <= input[i]) {
				currMax = input[i];
			}
		}

		if (input[currIdx] != currMax) {
			swaps--;
		}

		for (int j = currIdx; j < input.length; j++) {
			if (input[j] == currMax) {
				swap(input, j, currIdx);
				finalAns = findMaximumNumHelper(finalAns, input, currIdx + 1, swaps);
				swap(input, j, currIdx);
			}
		}

		return finalAns;
	}

	private static void swap(char[] input, int a, int b) {
		char x = input[a];
		input[a] = input[b];
		input[b] = x;
	}
}
