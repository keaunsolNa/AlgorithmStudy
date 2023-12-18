#  접미사 배열 - 11656

[문제 링크](https://www.acmicpc.net/problem/11656) 

### 성능 요약

메모리: 16040 KB, 시간: 208 ms

### 분류

구현

### 제출 일자

2023년 12월 18일 22:51

### 문제
접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.

baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.

문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.

### 문제 설명

접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열.
ex) "baekjoon"의 접미사는 총 8개
"baekjoon", "aekjoon", "ekjoon", "kjoon", "joon", "oon", "on", "n"

모든 접미사를 배열에 저장후 사전순으로 정렬(Arrays의 sort함수를 사용)하여 출력


### 입력 

첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000보다 작거나 같다.

### 출력 

첫째 줄부터 S의 접미사를 사전순으로 한 줄에 하나씩 출력한다.

