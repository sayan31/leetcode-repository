package com.sayan.leetcode.dp.medium;

public class WildcardPatternMatching {
    public static void main(String[] args) {
        //String txt = "abcde", pat = "a?c*";
        //String txt = "baaabab", pat = "a*ab";
        //String txt = "baaabab", pat = "ab";
        String txt = "fguekcccdpsrt", pat = "a?*c*";
        System.out.println("Match : "+patternMatched(txt, pat)); // true
    }

    private static boolean patternMatched(String txt, String pat) {
        boolean patternMatchedRecursive = patternMatchedHelper(txt, pat, txt.length()-1, pat.length()-1);
        System.out.println("Pattern matched recursive output: "+patternMatchedRecursive);

        Boolean[][] memo = new Boolean[txt.length()][pat.length()];        
        boolean patternMatchedMemoized = patternMatchedMemo(memo, txt, pat, txt.length()-1, pat.length()-1);   
        System.out.println("Pattern matched memoized output: "+patternMatchedMemoized);

        return patternMatchedMemoized;
    }

    private static boolean patternMatchedMemo(Boolean[][] memo, String txt, String pat, int txtCurr, int patCurr) {
        if((txtCurr < 0 && patCurr < 0)){
            return true;
        }
        if(patCurr < 0 ) {
            return false;
        }
        // If the text is exhausted, the remaining pattern must consist only of * for it to match
        if (txtCurr < 0) {
            for (int i = 0; i <= patCurr; i++) {
                if (pat.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        if(memo[txtCurr][patCurr] != null) {
            // If the value is already computed, return it.
            return memo[txtCurr][patCurr];
        }

        if(pat.charAt(patCurr) == txt.charAt(txtCurr) || pat.charAt(patCurr) == '?') {
            memo[txtCurr][patCurr] = patternMatchedMemo(memo, txt, pat, txtCurr-1, patCurr-1);
        }else if(pat.charAt(patCurr) == '*') {
            // If the pattern is '*', we can either ignore it or match it with the current character in the text.
            // So we check both possibilities: ignoring the '*' (patCurr-1) or matching it with the current character (txtCurr-1).
            memo[txtCurr][patCurr] = patternMatchedHelper(txt, pat, txtCurr-1, patCurr) || patternMatchedHelper(txt, pat, txtCurr, patCurr-1);
        }else {
            memo[txtCurr][patCurr] = false;
        }

        return memo[txtCurr][patCurr];        
    }

    private static boolean patternMatchedHelper(String txt, String pat, int txtCurr, int patCurr) {
        if((txtCurr < 0 && patCurr < 0)){
            return true;
        }
        if(patCurr < 0 ) {
            return false;
        }
        // If the text is exhausted, the remaining pattern must consist only of * for it to match
        if (txtCurr < 0) {
            for (int i = 0; i <= patCurr; i++) {
                if (pat.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        if(pat.charAt(patCurr) == txt.charAt(txtCurr) || pat.charAt(patCurr) == '?') {
            return patternMatchedHelper(txt, pat, txtCurr-1, patCurr-1);
        }else if(pat.charAt(patCurr) == '*') {
            return patternMatchedHelper(txt, pat, txtCurr-1, patCurr) || patternMatchedHelper(txt, pat, txtCurr, patCurr-1);
        }

        return false;
    }
}
