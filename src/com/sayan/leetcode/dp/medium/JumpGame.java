package com.sayan.leetcode.dp.medium;

public class JumpGame {
    public boolean canJump(int[] nums){
        int[] memo = new int[nums.length+1];
        for(int i:memo)
            memo[i]=-1;
        return canJumpHelper(memo, nums, 0) == 1;
    }

    private int canJumpHelper(int[] memo, int[] nums, int currIdx) {
        if(currIdx==nums.length-1) return 1;
        if(nums[currIdx]==0) return 0;

        if (memo[currIdx] != -1) return memo[currIdx];

        int canReachIdx = Math.min(currIdx+nums[currIdx],nums.length-1);

        for(int jump=currIdx+1;jump<=canReachIdx;jump++){
            if(canJumpHelper(memo,nums,jump)==1)
                return memo[currIdx]=1;
                //return true;
            //memo[currIdx]=canJumpHelper(memo,nums,jump)==1?1:0;
        }

        //return false;
        //memo[currIdx]=false;

        //memo[currIdx]=0;
        return memo[currIdx]=0;
    }



    /*private boolean canJumpHelper(boolean[] memo, int[] nums, int currIdx, int endIdx){
        if(currIdx==endIdx) return true;
        if(nums[currIdx]==0) return false;

        if(memo[currIdx]) return memo[currIdx];
        //boolean isPossible = false;
        for(int jump=currIdx+1;jump<=nums[currIdx];jump++) {
            if (currIdx + jump <= endIdx)
                memo[currIdx] = memo[currIdx] || canJumpHelper(memo,nums, currIdx + jump, endIdx);
        }
        return memo[currIdx];
    }*/

    public static void main(String[] args) {
        JumpGame obj = new JumpGame();
        System.out.println(obj.canJump(new int[]{2,3,1,1,4}));
        System.out.println(obj.canJump(new int[]{3,2,1,0,4}));
        System.out.println(obj.canJump(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
    }
}
