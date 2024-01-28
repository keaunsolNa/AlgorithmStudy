package com.programmers;

public class ps181913 {
	public String solution(String my_string, int[][] queries) {

		// 문자열을 저장
		StringBuilder answer = new StringBuilder(my_string);

		for (int i = 0; i < queries.length; i++) {

			// 인덱스를 변수에 저장
			int s = queries[i][0];
			int e = queries[i][1];

			StringBuilder sb = new StringBuilder(answer.substring(s, e + 1)); // sb에 바꿀 문자열만 따로 저장
			sb.reverse(); // reverse를 통해 문자열 뒤집기
			answer.replace(s, e + 1, sb.toString()); // 원래 문자열을 바꾼 문자열로 대체
		}
		return answer.toString();
	}
}
