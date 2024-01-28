# [level unrated] 올바른 괄호 - 12909

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/120909) 

### 성능 요약

<h3>정확성  테스트<br></h3>
테스트 1 〉	통과 (0.04ms, 33.4MB)<br>
테스트 2 〉	통과 (0.04ms, 33.4MB)<br>
테스트 3 〉	통과 (0.04ms, 33.5MB)<br>
테스트 4 〉	통과 (0.04ms, 33.4MB)<br>
테스트 5 〉	통과 (0.04ms, 33.4MB)<br>
테스트 6 〉	통과 (0.04ms, 33.6MB)<br>
테스트 7 〉	통과 (0.04ms, 33.4MB)<br>
테스트 8 〉	통과 (0.05ms, 33.4MB)<br>
테스트 9 〉	통과 (0.13ms, 33.5MB)<br>
테스트 10 〉	통과 (0.05ms, 33.5MB)<br>
테스트 11 〉	통과 (0.05ms, 33.5MB)<br>
테스트 12 〉	통과 (0.13ms, 33.5MB)<br>
테스트 13 〉	통과 (0.13ms, 33.6MB)<br>
테스트 14 〉	통과 (0.14ms, 33.4MB)<br>
테스트 15 〉	통과 (0.13ms, 33.6MB)<br>
테스트 16 〉	통과 (0.13ms, 33.5MB)<br>
테스트 17 〉	통과 (0.13ms, 33.4MB)<br>
테스트 18 〉	통과 (0.14ms, 33.6MB)<br>
<h3>효율성  테스트<br></h3>
테스트 1 〉	통과 (4.76ms, 37.7MB)<br>
테스트 2 〉	통과 (4.99ms, 37.7MB)<br>

### 구분

코딩테스트 연습 > 스택/큐 > 올바른 괄호



### 채점결과

정확성: 69.5
효율성: 30.5
합계: 100.0 / 100.0

### 제출 일자

2024년 1월 14일 17:30

### 문제 설명

<h6 class="guide-section-title">문제 설명</h6>
<div class="markdown solarized-dark"><p>괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어</p>

<ul>
<li>"()()" 또는 "(())()" 는 올바른 괄호입니다.</li>
<li>")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.</li>
</ul>

<p>'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.</p>

<h5>제한사항</h5>

<ul>
<li>문자열 s의 길이 : 100,000 이하의 자연수</li>
<li>문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>s</th>
<th>answer</th>
</tr>
</thead>
        <tbody><tr>
<td>"()()"</td>
<td>true</td>
</tr>
<tr>
<td>"(())()"</td>
<td>true</td>
</tr>
<tr>
<td>")()("</td>
<td>false</td>
</tr>
<tr>
<td>"(()("</td>
<td>false</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>입출력 예 #1,2,3,4<br>
문제의 예시와 같습니다.</p>
</div>
    </div>
  </div>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges