package com.beakjun.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2738 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < N; k++) {
			st = new StringTokenizer(br.readLine());
			for (int l = 0; l < M; l++) {
				A[k][l] = A[k][l] + Integer.parseInt(st.nextToken());
			}
		}

		for (int o = 0; o < N; o++) {
			for (int p = 0; p < M; p++) {
				System.out.print(A[o][p] + " ");
				if (p == M - 1) {
					System.out.println("");
				}
			}

		}
	}
}
