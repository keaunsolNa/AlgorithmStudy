package com.beakjun.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11728 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N+M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < M; j++) {
			A[N+j] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		// 시간초과로 인해 실패처리되어 StringBuilder로 변경
		/*for (int i : A) {
            System.out.print(i + " ");
        }*/
		
		StringBuilder sb = new StringBuilder();
		
		for(int r : A) {
			sb.append(r+" "); 
					
		}
		
		System.out.println(sb);
		
		
		
	}

}
