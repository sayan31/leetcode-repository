package com.sayan.leetcode.dp.medium;

public class MinimumJumps {
    public static void main(String[] args) {
        //int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr = {3,2,1,0,4};
        System.out.println("Minimum jumps required: " + minJumps(arr));
    }

    private static int minJumps(int[] arr) {
        int ans = minJumpsHelperRecursive(arr, 0);
        System.out.println("Minimum jumps required (recursive): " + ans);

        int ansSpaceOptimized = minJumpsHelperSpaceOptimizedDP(arr);
        System.out.println("Minimum jumps required (space optimized): " + ansSpaceOptimized);
        //return ansSpaceOptimized;
        return ans == Integer.MAX_VALUE ? -1 : ans;


    }

    private static int minJumpsHelperSpaceOptimizedDP(int[] arr) {
        int n = arr.length;
        if (n == 0 || arr[0] == 0) return -1; // If the array is empty or the first element is 0, we cannot jump

        int jumps = 0; // Number of jumps made
        int currEnd = 0; // The farthest index we can reach with the current number of jumps
        int currFarthest = 0; // The farthest index we can reach with the next jump

        for (int i = 0; i < n - 1; i++) {
            currFarthest = Math.max(currFarthest, i + arr[i]); // Update the farthest index we can reach

            if (i == currEnd) { // If we have reached the end of the current jump
                jumps++; // Increment the number of jumps made
                currEnd = currFarthest; // Update the end of the current jump

                if (currEnd >= n - 1) break; // If we can reach or exceed the last index, break out of the loop
            }
        }

        return currEnd >= n - 1 ? jumps : -1; // If we can reach or exceed the last index, return the number of jumps made, otherwise return -1
    }

    private static int minJumpsHelperRecursive(int[] arr, int currIdx) {
        
        // If we reach the last index, we can jump to the end
        if (currIdx == arr.length - 1) return 0;

        // If we reach an index with 0, we cannot jump further
        if (arr[currIdx] == 0) return 0;

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
