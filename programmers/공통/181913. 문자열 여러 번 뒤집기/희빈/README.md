# [level 0] 문자열 여러 번 뒤집기 - 181913

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/181913)

### 성능 요약
테스트 1 〉	통과 (0.20ms, 33.6MB)<br/>
테스트 2 〉	통과 (0.20ms, 33.5MB)<br/>
테스트 3 〉	통과 (0.27ms, 33.7MB)<br/>
테스트 4 〉	통과 (0.38ms, 33.7MB)<br/>
테스트 5 〉	통과 (0.74ms, 34MB)<br/>
테스트 6 〉	통과 (0.22ms, 33.4MB)<br/>
테스트 7 〉	통과 (0.21ms, 33.5MB)<br/>
테스트 8 〉	통과 (0.51ms, 33.7MB)<br/>
테스트 9 〉	통과 (0.85ms, 34.2MB)<br/>
테스트 10 〉	통과 (0.99ms, 34.4MB)<br/>
테스트 11 〉	통과 (0.23ms, 33.4MB)<br/>
테스트 12 〉	통과 (0.25ms, 33.5MB)<br/>
테스트 13 〉	통과 (0.33ms, 33.7MB)<br/>
테스트 14 〉	통과 (0.65ms, 33.9MB)<br/>
테스트 15 〉	통과 (2.14ms, 34.7MB)<br/>
테스트 16 〉	통과 (0.26ms, 33.6MB)<br/>
테스트 17 〉	통과 (0.66ms, 33.7MB)<br/>
테스트 18 〉	통과 (0.60ms, 33.7MB)<br/>
테스트 19 〉	통과 (1.79ms, 34.7MB)<br/>
테스트 20 〉	통과 (2.80ms, 34.7MB)<br/>
테스트 21 〉	통과 (0.40ms, 33.8MB)<br/>
테스트 22 〉	통과 (0.43ms, 33.6MB)<br/>
테스트 23 〉	통과 (2.44ms, 34.5MB)<br/>
테스트 24 〉	통과 (4.75ms, 34.9MB)<br/>
테스트 25 〉	통과 (5.64ms, 35MB)

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 1월 2일 19:58

### 문제 설명

<div class="markdown solarized-dark"><p>문자열 <code>my_string</code>과 이차원 정수 배열 <code>queries</code>가 매개변수로 주어집니다. <code>queries</code>의 원소는 [s, e] 형태로, <code>my_string</code>의 인덱스 s부터 인덱스 e까지를 뒤집으라는 의미입니다. <code>my_string</code>에 <code>queries</code>의 명령을 순서대로 처리한 후의 문자열을 return 하는 solution 함수를 작성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li><code>my_string</code>은 영소문자로만 이루어져 있습니다.</li>
<li>1 ≤ <code>my_string</code>의 길이 ≤ 1,000</li>
<li><code>queries</code>의 원소는 [s, e]의 형태로 0 ≤ s ≤ e &lt; <code>my_string</code>의 길이를 만족합니다.</li>
<li>1 ≤ <code>queries</code>의 길이 ≤ 1,000</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>my_string</th>
<th>queries</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>"rermgorpsam"</td>
<td>[[2, 3], [0, 7], [5, 9], [6, 10]]</td>
<td>"programmers"</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<ul>
<li><p>예제 1번의 <code>my_string</code>은 "rermgorpsam"이고 주어진 <code>queries</code>를 순서대로 처리하면 다음과 같습니다.</p>
<table class="table">
        <thead><tr>
<th>queries</th>
<th>my_string</th>
</tr>
</thead>
        <tbody><tr>
<td></td>
<td>"rermgorpsam"</td>
</tr>
<tr>
<td>[2, 3]</td>
<td>"remrgorpsam"</td>
</tr>
<tr>
<td>[0, 7]</td>
<td>"progrmersam"</td>
</tr>
<tr>
<td>[5, 9]</td>
<td>"prograsremm"</td>
</tr>
<tr>
<td>[6, 10]</td>
<td>"programmers"</td>
</tr>
</tbody>
      </table>
<p>따라서 "programmers"를 return 합니다.</p></li>
</ul>
</div>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
