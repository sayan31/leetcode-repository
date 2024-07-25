package com.sayan.leetcode.medium.recursion;

import java.util.*;

public class JosephusProblem {

	public static void main(String[] args) {		
		System.out.println(new JosephusProblemSolution().josephus(20, 18));
	}

}

class JosephusProblemSolution{
	public int josephus(int n, int k) {
		List<Integer> persons = new ArrayList<>();
		for(int i=0;i<n;i++) {
			persons.add(i);
		}
		josephusHelper(persons, 0, k-1);
		return persons.get(0)+1;
	}

	private void josephusHelper(List<Integer> persons, int start, int personToBeKilled) {
		if(persons.size()==1) {
			return;
		}
		int killIdx = (start + personToBeKilled)%persons.size();
		persons.remove(killIdx);
		josephusHelper(persons, killIdx, personToBeKilled);
	}
}
