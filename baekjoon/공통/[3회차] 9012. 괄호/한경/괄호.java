package com.beakjun.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj9012 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 데이터 개수 입력받기
		int T = Integer.parseInt(st.nextToken());

		// T만큼 반복
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			Stack<Character> stack = new Stack<>();

			// A의 길이만큼 반복
			for (int j = 0; j < A.length(); j++) {
				if (A.charAt(j) == '(') {
					// 여는 괄호면 stack에 삽입
					stack.push(A.charAt(i));
				} else if (A.charAt(j) == ')') {
					// 닫는 괄호인데 stack이 비어있으면 NO
					if (stack.isEmpty()) {
						sb.append("NO\n");
						break;
					} else {
						// 닫는 괄호면 stack에서 삭제
						stack.pop();
					}

				}
				
				// 마지막에 stack이 비어있다면 YES 아니면 NO
				if (j + 1 == A.length()) {
					if (stack.isEmpty()) {
						sb.append("YES\n");
					} else {
						sb.append("NO\n");
					}
				}

			}

		}

		System.out.println(sb);

	}
}
