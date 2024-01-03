package com.beakjun.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15552 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 입력받기
		int T = Integer.parseInt(st.nextToken());
		
		// A와 B 입력받기
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// 더한 값을 StringBuilder에 append
			sb.append(A+B + "\n");
		}
		
		System.out.println(sb);

	}
}
