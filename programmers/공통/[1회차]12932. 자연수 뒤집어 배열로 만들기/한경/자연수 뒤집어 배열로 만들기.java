package com.programmers;

public class ps12932 {

	class Solution {
	    public int[] solution(long n){
	        String N = String.valueOf(n);
	        int[] answer = new int[N.length()];

	        for(int i = 0; i < N.length(); i++) {
	            answer[i] = N.charAt((N.length()-1)-i) - '0';
	        }

	        return answer;
	    }
	}

}
