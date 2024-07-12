package com.sayan.leetcode.medium.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBoggle {

	public static void main(String[] args) {

		String[] dictionary = new String[] { "GEEKS", "FOR", "QUIZ", "GO" };

		char[][] board = new char[][] { { 'A', 'I', 'E' }, { 'U', 'Z', 'K' }, { 'Q', 'L', 'E' } };

		WordBoggleSolution obj = new WordBoggleSolution();
		String[] ans = obj.findAllWords(dictionary, board);

		if (ans.length == 0)
			System.out.println("-1");
		else {
			Arrays.sort(ans);
			for (int i = 0; i < ans.length; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
		}
	}

}

class WordBoggleSolution {

	public String[] findAllWords(String[] dictionary, char[][] board) {
		int rows = board.length, cols = board[0].length;
		List<String> finalAns = new ArrayList<>();

		boolean[][] visited = new boolean[rows][cols];

		for (int i = 0; i < dictionary.length; i++) {
			if (wordPossible(dictionary[i], board, rows, cols, visited, "", 0)) {
				finalAns.add(dictionary[i]);
			}
		}
		String[] result = new String[finalAns.size()];
		return finalAns.toArray(result);
	}

	private boolean wordPossible(String word, char[][] board, int rows, int cols, boolean[][] visited,
			String wordFormed, int idx) {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == word.charAt(idx)) {
					// search for next character in 8 directions
					if (findNextChar(word, board, visited, idx, rows, cols, i, j)) {
						return true;
					}
				}
			}
		}

		return false;
	}
	
	
	private boolean findNextChar(String word, char[][] board, boolean[][] visited, int idx, int rows, int cols, int r,
			int c) {
		
		if(idx == word.length())
			return true;
		
		if(r < 0 || c < 0 || r == rows || c == cols || board[r][c] != word.charAt(idx) || visited[r][c] )
			return false;
		
		visited[r][c]=true;
		
		//search vertically and horizontally
		boolean right = findNextChar(word, board, visited, idx+1, rows, cols, r, c+1);
		boolean left = findNextChar(word, board, visited, idx+1, rows, cols, r, c-1);
		boolean up = findNextChar(word, board, visited, idx+1, rows, cols, r-1, c);
		boolean down = findNextChar(word, board, visited, idx+1, rows, cols, r+1, c);
		
		//search diagonally
		boolean diagonalRightDown = findNextChar(word, board, visited, idx+1, rows, cols, r+1, c+1);
		boolean diagonalLeftDown = findNextChar(word, board, visited, idx+1, rows, cols, r+1, c-1);
		boolean diagonalRightUp = findNextChar(word, board, visited, idx+1, rows, cols, r-1, c+1);
		boolean diagonalLeftUp = findNextChar(word, board, visited, idx+1, rows, cols, r-1, c-1);
		
		visited[r][c]=false;
		
		return right || left || up || down || diagonalRightDown || diagonalLeftDown || diagonalRightUp || diagonalLeftUp;
	}
}
