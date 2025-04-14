package com.sayan.leetcode.dp.medium;

public class JumpGame {
    public boolean canJump(int[] nums){
        boolean canJumpRecursive = canJumpHelperRecursive(nums, 0)==1;
        System.out.println("Can jump recursive output: "+canJumpRecursive);

        int[] memo = new int[nums.length];
        for(int i=0;i<memo.length;i++)
            memo[i]=-1;
        boolean canJumpMemoized = canJumpHelper(memo, nums, 0)==1;
        System.out.println("Can jump memoized output: "+canJumpMemoized);

        return canJumpMemoized;
    }

    private int canJumpHelperRecursive(int[] nums, int currIdx) {
        
        // If we reach the last index, we can jump to the end
        if (currIdx == nums.length - 1) return 1;

        // If we reach an index with 0, we cannot jump further
        if (nums[currIdx] == 0) return 0;

        for(int i=1;i<=nums[i];i++){
            // Check if we can jump to the next index
            // and if we can reach the end from there
            // We are using currIdx+i<nums.length to avoid ArrayIndexOutOfBoundsException
            if(currIdx+i<nums.length && canJumpHelperRecursive(nums, currIdx+i)==1)
                return 1;           
        }

        // If we reach here, it means we cannot jump to the end from this index
        return 0;
    }

    private int canJumpHelper(int[] memo, int[] nums, int currIdx) {
        if(currIdx==nums.length-1) return 1;
        if(nums[currIdx]==0) return 0;

        if (memo[currIdx] != -1) return memo[currIdx];

        for(int i=1;i<=nums[currIdx];i++){
            if(currIdx+i<nums.length && canJumpHelper(memo, nums, currIdx+i)==1)
                return memo[currIdx]=1;
        }
        return memo[currIdx]=0;
    }

    public static void main(String[] args) {
        JumpGame obj = new JumpGame();
        //System.out.println(obj.canJump(new int[]{2,3,1,1,4}));
        System.out.println(obj.canJump(new int[]{3,2,1,0,4}));
        System.out.println(obj.canJump(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
    }
}
