package com.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1546 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		float avg = 0;
		double M = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			M = Math.max(M, arr[i]);
			
		}
		
		for(int j = 0; j<arr.length; j++) {
			avg += arr[j]/M*100;
			
		}
		
		System.out.println(avg/N);
		
		br.close();
		
		
	}
}
