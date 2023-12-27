package com.beakjun.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj5597 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[30];
		
		for(int i = 0; i < 28; i++) {
			int no = Integer.parseInt(br.readLine());
			arr[no - 1] = 1;
		}
		
		for(int j = 0; j<arr.length; j++) {
			if(arr[j] == 0) {
				System.out.println(j+1);
			}
		}
		
		br.close();
		
		
	}

}
