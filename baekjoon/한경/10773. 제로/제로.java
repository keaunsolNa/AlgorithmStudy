package com.beakjun.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			int number = Integer.parseInt(br.readLine());	// 정수 입력
			
			// 0이면 가장 최근 숫자 삭제
			if(number == 0) {	
				stack.pop();
			}
			else {
				// 아니면 스택에 삽입
				stack.push(number);
			}
		}
		int sum = 0;

		
		for(int o : stack) {
			// 스택에 남은 숫자 더하기
			sum += o;
		}

		System.out.println(sum);	
	}
	
}
