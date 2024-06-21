package com.sayan.leetcode.medium.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatInAMaze {

	public static void main(String[] args) {
		//int[][] matrix = {{1,0,0,1,1}, {1,1,1,1,1}, {1,1,0,0,1}, {0,1,0,1,1}, {0,1,1,1,1}};
		int[][] matrix = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
		RatInAMazeSolution obj = new RatInAMazeSolution();
		List<String> ans = obj.findPath(matrix, matrix.length);
		
		if(!ans.isEmpty()) {
			for(String s:ans) {
				System.out.print(s + " ");
			}
			System.out.println();
		}else {
			System.out.println(-1);
		}		
	}
}

class RatInAMazeSolution{
	public List<String> findPath(int[][] matrix, int length){
		List<String> finalAns = new ArrayList<>();
		
		//If source or destination is blocked, return not possible
		if(matrix[length-1][length-1]==0 || matrix[0][0]==0)
			return finalAns;
		
		findPathHelper(matrix, length, finalAns, new StringBuilder(), 0, 0);
		
		return finalAns;
	}

	private void findPathHelper(int[][] matrix, int length, 
			List<String> finalAns, StringBuilder path, int row, int col) {
		
		if(row==length-1 && col==length-1) {
			finalAns.add(path.toString());
			
			Collections.sort(finalAns,(l1,l2)->{
	            for(int i=0;i<Math.min(l1.length(),l2.length());i++){
	                if(l1.charAt(i)!=l2.charAt(i)){
	                    return l1.charAt(i)-l2.charAt(i);
	                }
	            }
	            return l1.length()-l2.length();
	        });
			
			return;
		}
		
		if (matrix[row][col]==1) {
			
			if (col < length - 1 && 
					matrix[row][col + 1] != 0 && matrix[row][col + 1] != -1) {
				matrix[row][col]*=-1;
				path.append("R");
				findPathHelper(matrix, length, finalAns, path, row, col + 1);
				path.deleteCharAt(path.length()-1);
				matrix[row][col]*=-1;
			}
			
			if (row < length - 1 && 
					matrix[row + 1][col] != 0 && matrix[row + 1][col] != -1) {
				matrix[row][col]*=-1;
				path.append("D");
				findPathHelper(matrix, length, finalAns, path, row + 1, col);
				path.deleteCharAt(path.length()-1);
				matrix[row][col]*=-1;
			}
			
			if(col >= 1 && row < length-1 &&
					matrix[row][col - 1] != 0 && matrix[row][col - 1] != -1) {
				matrix[row][col]*=-1;
				path.append("L");
				findPathHelper(matrix, length, finalAns, path, row, col - 1);
				path.deleteCharAt(path.length()-1);
				matrix[row][col]*=-1;
			}
			
			if(row >= 1 && col < length-1 &&
					matrix[row - 1][col] != 0 && matrix[row - 1][col] != -1) {
				matrix[row][col]*=-1;
				path.append("U");
				findPathHelper(matrix, length, finalAns, path, row-1, col);
				path.deleteCharAt(path.length()-1);
				matrix[row][col]*=-1;
			}
		}
	}
}


//r<length-1 &&
//c<length-1 && 