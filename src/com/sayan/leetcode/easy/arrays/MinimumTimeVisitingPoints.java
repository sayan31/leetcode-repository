package com.sayan.leetcode.easy.arrays;

public class MinimumTimeVisitingPoints {

	private static int minTimeToVisitAllPoints(int[][] points) {
		//the final return value
        int minTime = 0;
        
        //Run a loop from the first row to the last row of the matrix
        for(int index=0;index<points.length-1;index++){
        	//find the absolute difference of the target and current x co-ordinates
            int absDiffX=Math.abs(points[index+1][0]-points[index][0]);
            //find the absolute difference of the target and current y co-ordinates
            int absDiffY=Math.abs(points[index+1][1]-points[index][1]);
            
            //increment the result variable with the maximum of the above two
            minTime+=Math.max(absDiffX,absDiffY);
        }
        
        return minTime;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[][] { {1,1}, {3, 4}, {-1,0}};
		
		System.out.println(minTimeToVisitAllPoints(arr));
	}

}
