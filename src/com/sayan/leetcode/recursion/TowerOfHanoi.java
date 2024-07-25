package com.sayan.leetcode.medium.recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		System.out.println(new TowerOfHanoiSolution().towerOfHanoi(3, 1, 3, 2));

	}

}

class TowerOfHanoiSolution {
	public long towerOfHanoi(int n, int from, int to, int aux) {
		long steps = 1;
		if(n==0) {
			return 0;
		}
		steps += towerOfHanoi(n-1, from, aux, to);
		System.out.println("move disk "+ n + " from rod " + from + " to rod " + to);
		steps += towerOfHanoi(n-1, aux, to, from);
		
		return steps;
	}
}
