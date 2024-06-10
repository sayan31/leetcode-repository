package com.sayan.leetcode.medium.recursion;

import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {

	public static void main(String[] args) throws IOException
    {
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int
		 * T = Integer.parseInt(br.readLine().trim()); while(T-->0) { int n =
		 * Integer.parseInt(br.readLine().trim()); String[] s1 =
		 * br.readLine().trim().split(" "); int[] nums = new int[n]; for(int i = 0; i <
		 * n; i++)nums[i] = Integer.parseInt(s1[i]); Solution obj = new Solution();
		 * int[][] ans = obj.permuteUnique(nums); for(int i = 0; i < ans.length; i++){
		 * for(int j = 0; j < ans[i].length; j++){ System.out.print(ans[i][j] + " "); }
		 * System.out.println(); } }
		 */
        int[] nums=new int[] {-9,7,-5,3,7,-5,-5,8};
        Solution obj = new Solution();
        int[][] ans = obj.permuteUnique(nums);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution
{
    public int[][] permuteUnique(int[] nums)
    {
        // Code here
        List<int[]> finalAns = new ArrayList<>();      
        permuteUniqueHelper(0, finalAns, nums);
        
        return finalAns.toArray(new int[finalAns.size()][]);
    }
    
    private void permuteUniqueHelper(int currIdx, List<int[]> finalAns, int[] nums){
        
        //base condition
        if(currIdx==nums.length-1){
            finalAns.add(Arrays.copyOf(nums, nums.length));
            
            Collections.sort(finalAns, (a1, a2)->{
            	for(int i=0;i<Math.min(a1.length,a2.length);i++){
                    if(a1[i]!=a2[i]){
                        return a1[i]-a2[i];
                    }
                }
            return a1.length-a2.length;
            });
            
            
            return;
        }
        
        for(int i=currIdx;i<nums.length;i++){
            if(i==currIdx){
                permuteUniqueHelper(currIdx+1, finalAns, nums);
                continue;
            }
            if(nums[i]!=nums[currIdx] && nums[i]!=nums[i-1]){
                swap(currIdx, i, nums);
                permuteUniqueHelper(currIdx+1, finalAns, nums);
                swap(currIdx, i, nums);
            }
        }        
    }
    
    private void swap(int a, int b, int[] nums){
        int x = nums[a];
        nums[a] = nums[b];
        nums[b] = x;
    }
    
}
