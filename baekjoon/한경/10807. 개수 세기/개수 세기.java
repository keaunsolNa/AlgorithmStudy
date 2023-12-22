package com.beakjun.test;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int v = 0;
		int cnt = 0;
		
		N = sc.nextInt();

		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		v = sc.nextInt();
		
		for(int j = 0; j < arr.length; j++) {
			if(v == arr[j]) {
				cnt = cnt + 1;
			}
		}
		
		
		System.out.println(cnt);
		
		sc.close();
		
		
	}

}
