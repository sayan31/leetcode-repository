package com.sayan.leetcode.recursion;

import java.util.*;

public class PascalTriangle {

	public static void main(String[] args) {
		
		int n = 100;
		ArrayList<Long> ans = new PascalTriangleSolution().nthRowOfPascalTriangle(n);
		
		for(Long x:ans) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		System.out.println(ans.size());
	}

}

class PascalTriangleSolution{
	public ArrayList<Long> nthRowOfPascalTriangle(int n){
		ArrayList<Long> ans = new ArrayList<>();
		ans.add(1L);
		
		for(int c=1;c<n;c++) {
			//compute co-efficient for this column
			ans.add(nthRowOfPascalTriangleHelper(c, n));
		}
		
		return ans;
	}

	private long nthRowOfPascalTriangleHelper(int col, int row) {
		long m = 1000000007L;
		long finalAns = 1L;
		if(col == 0) {
			return 1L;
		}else {			
			long inter = 1L;
			inter = (inter*nthRowOfPascalTriangleHelper(col-1, row))%m;
			inter = (inter * (row-col))%m;
			
			inter = inter * modularInv(col, m);			
			finalAns = inter % m;
			return finalAns;
		}
	}

	private long modularInv(long col, long m) {
		return power(col, m-2, m);
	}

	private long power(long col, long x, long m) {
		long res = 1;
		col = col%m;
		while(x>0) {
			if((x&1)==1) {
				res = (res*col)%m;
			}
			x=x>>1;
			col = (col*col)%m;
		}
		return res;
	}

}
