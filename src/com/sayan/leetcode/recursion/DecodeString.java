package com.sayan.leetcode.recursion;

public class DecodeString {

	public static void main(String[] args) {
		
		String toDecode = "3[a3[b]1[ab]]";
		//String toDecode = "3[x2[p7[q5[rs4[z]]]]]";
		//String toDecode = "3[b2[ca]]";
		DecodeStringSolution obj = new DecodeStringSolution();
		
		System.out.println(obj.decodedString(toDecode));
	}

}

class DecodeStringSolution{
	public String decodedString(String s) {		
		char[] input = s.toCharArray();
		
		String returnAns = "";
		String finalAns = "";
		String temp="";
		String repeating="";
		int count = 0;
		for(int i = s.length()-1;i >= 0; i--) {
			if(input[i] == ']' || input[i] == '[')
				continue;
			
			while(input[i]>='a' && input[i]<='z') {
				temp = input[i]+temp;
				i--;
			}
	
			
			while(i>=0 && input[i]>='1' && input[i]<='9') {
				repeating=input[i]+repeating;
				i--;
			} 
			
			if(!repeating.isEmpty()) {
				count = Integer.parseInt(repeating);
				for(int a = 0;a<count;a++) {
					finalAns = temp + finalAns;
				}
				temp = finalAns;
				returnAns = temp;
				if (i>=0 && !(input[i]== ']' && input[i+1+repeating.length()]=='[')) {
					finalAns = "";
				}else {
					temp = "";
				}
				repeating="";
			}
			
			i++;
		}
		return returnAns;
	}
}


/*temp =finalAns;
finalAns = "";
repeating="";*/