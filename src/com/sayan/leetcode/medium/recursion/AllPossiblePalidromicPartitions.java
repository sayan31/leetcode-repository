package com.sayan.leetcode.medium.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPossiblePalidromicPartitions {

	public static void main(String[] args) {
		String s = "madam";
		AllPalindromes obj = new AllPalindromes();
		List<List<String>> allPart = obj.allPalindromicPerms(s);
		for (int i = 0; i < allPart.size(); i++) {
			for (int j = 0; j < allPart.get(i).size(); j++) {
				System.out.print(allPart.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}

class AllPalindromes {

	public List<List<String>> allPalindromicPerms(String s) {
		List<List<String>> finalAns = new ArrayList<>();
		List<String> interim = new ArrayList<>();

		allPalindromicPermsHelper(finalAns, interim, s, 0);

		return finalAns;
	}

	private void allPalindromicPermsHelper(List<List<String>> finalAns, List<String> interim, String s, int currIdx) {

		if (currIdx == s.length()) {
			finalAns.add(new ArrayList<>(interim));
			return;
		}

		String currStr = "";
		for (int i = currIdx; i < s.length(); i++) {
			// if the substring is a palindrome, add it into interim list
			currStr += s.charAt(i);
			if (isPalindrome(currStr)) {
				interim.add(currStr);
				allPalindromicPermsHelper(finalAns, interim, s, i + 1);
				interim.remove(interim.size() - 1);
			}
		}

	}

	private boolean isPalindrome(String currStr) {
		int start = 0, end = currStr.length() - 1;

		for (int i = start, j = end; i < j; i++, j--) {
			if (currStr.charAt(i) != currStr.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
