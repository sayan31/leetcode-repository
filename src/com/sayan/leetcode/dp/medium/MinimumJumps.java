package com.sayan.leetcode.dp.medium;

public class MinimumJumps {
    public static void main(String[] args) {
        //int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr = {3,2,1,0,4};
        System.out.println("Minimum jumps required: " + minJumps(arr));
    }

    private static int minJumps(int[] arr) {
        return minJumpsHelperRecursive(arr, 0);
    }

    private static int minJumpsHelperRecursive(int[] arr, int currIdx) {
        
        // If we reach the last index, we can jump to the end
        if (currIdx == arr.length - 1) return 0;

        // If we reach an index with 0, we cannot jump further
        if (arr[currIdx] == 0) return -1;

        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[currIdx]; i++) {
            // Check if we can jump to the next index
            // and if we can reach the end from there
            // We are using currIdx+i<nums.length to avoid ArrayIndexOutOfBoundsException
            if (currIdx + i < arr.length) {
                minJumps = Math.min(minJumps, 1 + minJumpsHelperRecursive(arr, currIdx + i));
            }
        }

        return minJumps;
    }
}
