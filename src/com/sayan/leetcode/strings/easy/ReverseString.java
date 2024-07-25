package com.sayan.leetcode.strings.easy;

public class ReverseString {
    public void reverseString(char[] s) {
        int start=0;
        reverseCharArray(s,start,s.length-1);
    }
    private void reverseCharArray(char[] s,int start,int end){
        char temp='\0';
        if(start>=end){return;}
        temp=s[end];
        s[end]=s[start];
        s[start]=temp;
        reverseCharArray(s,start+1,end-1);
    }
    private static void printArray(char[] s){
        for(char c:s){
            System.out.print(c+" ");
        }
    }

    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        char[] s = new char[]{'h','e','l','l','o'};
        obj.reverseString(s);
        printArray(s);
    }
}
