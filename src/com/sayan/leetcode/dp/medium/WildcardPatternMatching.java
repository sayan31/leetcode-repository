package com.sayan.leetcode.dp.medium;

public class WildcardPatternMatching {
    public static void main(String[] args) {
        String txt = "abcde", pat = "a?c*";
        //String txt = "baaabab", pat = "a*ab";
        //String txt = "baaabab", pat = "ab";
        //String txt = "fguekcccdpsrt", pat = "?*c*";
        System.out.println("Match : "+patternMatched(txt, pat)); // true
    }

    private static String patternMatched(String txt, String pat) {
        return patternMatchedHelper(txt, pat, txt.length()-1, pat.length()-1);
    }

    private static String patternMatchedHelper(String txt, String pat, int txtCurr, int patCurr) {
        if((txtCurr < 0 && patCurr < 0) || (txtCurr < 0)){
            return "true";
        }
        if(patCurr < 0 ) {
            return "false";
        }

        if(pat.charAt(patCurr) == txt.charAt(txtCurr) || pat.charAt(patCurr) == '?') {
            return patternMatchedHelper(txt, pat, txtCurr-1, patCurr-1);
        }else if(pat.charAt(patCurr) == '*') {
            return patternMatchedHelper(txt, pat, txt.indexOf(pat.charAt(patCurr-1)), patCurr-1);
        }

        return "false";
    }
}
