package com.sayan.leetcode.recursion;

import java.util.*;


public class WordsFromPhoneDigits {

	public static void main(String[] args) {
		int[] a = new int[] {5,6,7};
		WordsFromPhoneDigitsSolution obj = new WordsFromPhoneDigitsSolution();
		ArrayList<String> ans = obj.possibleWords(a);
		
		for(String i:ans)System.out.print(i + " ");
		System.out.println();
	}

}

class WordsFromPhoneDigitsSolution{
	public ArrayList <String> possibleWords(int a[]){
		Map<Integer, String> lookup = new HashMap<>();
		lookup.put(2, "abc");
		lookup.put(3, "def");
		lookup.put(4, "ghi");
		lookup.put(5, "jkl");
		lookup.put(6, "mno");
		lookup.put(7, "pqrs");
		lookup.put(8, "tuv");
		lookup.put(9, "wxyz");
		
		ArrayList<String> finalAns = new ArrayList<>();
		
		possibleWordsHelper(a, lookup, finalAns, new StringBuilder(), 0);
		
		return finalAns;
	}
	
	private void possibleWordsHelper(int[] a, Map<Integer, String> lookup, 
			ArrayList<String> finalAns, StringBuilder currString, int idx) {
		
		if(currString.length() == a.length) {
			finalAns.add(currString.toString());
			return;
		}
		
		for(char c:lookup.get(a[idx]).toCharArray()) {
			currString.append(c);
			possibleWordsHelper(a, lookup, finalAns, currString, idx+1);
			currString.deleteCharAt(currString.length()-1);
		}
	}
}
