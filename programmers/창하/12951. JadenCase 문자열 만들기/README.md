# [level unrated] JadenCase 문자열 만들기 - 12951 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12951) 

### 성능 요약

테스트 1 〉	통과 (0.15ms, 33.4MB)</br>
테스트 2 〉	통과 (0.07ms, 33.6MB)</br>
테스트 3 〉	통과 (0.15ms, 33.4MB)</br>
테스트 4 〉	통과 (0.19ms, 33.5MB)</br>
테스트 5 〉	통과 (0.48ms, 33.5MB)</br>
테스트 6 〉	통과 (5.05ms, 38.2MB)</br>
테스트 7 〉	통과 (5.41ms, 38.2MB)</br>
테스트 8 〉	통과 (13.71ms, 42.5MB)</br>
테스트 9 〉	통과 (14.16ms, 42.5MB)</br>
테스트 10 〉	통과 (25.44ms, 44.7MB)</br>
테스트 11 〉	통과 (24.06ms, 44MB)</br>
테스트 12 〉	통과 (43.99ms, 52.1MB)</br>
테스트 13 〉	통과 (46.57ms, 52.1MB)</br>
테스트 14 〉	통과 (104.39ms, 77.9MB)</br>
테스트 15 〉	통과 (230.71ms, 126MB)</br>
테스트 16 〉	통과 (220.81ms, 125MB)</br>
테스트 17 〉	통과 (205.75ms, 135MB)</br>
테스트 18 〉	통과 (227.32ms, 126MB)</br>
테스트 19 〉	통과 (218.20ms, 125MB)</br>
테스트 20 〉	통과 (206.47ms, 160MB)</br>
테스트 21 〉	통과 (177.46ms, 151MB)</br>
테스트 22 〉	통과 (160.69ms, 107MB)</br>
테스트 23 〉	통과 (151.61ms, 148MB)</br>

### 구분

코딩테스트 연습 >  연습문제  >  뒤에 있는 큰 수 찾기


### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 12월 27일 21:54

### 문제 설명

<h6 class="guide-section-title">문제 설명</h6>
<p>JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)<br>
문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.</p>

<h5>제한 조건</h5>

<ul>
<li>s는 길이 1 이상 200 이하인 문자열입니다.</li>
<li>s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.

<ul>
<li>숫자는 단어의 첫 문자로만 나옵니다.</li>
<li>숫자로만 이루어진 단어는 없습니다.</li>
<li>공백문자가 연속해서 나올 수 있습니다.</li>
</ul></li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>s</th>
<th style="text-align: center">return</th>
</tr>
</thead>
        <tbody><tr>
<td>"3people unFollowed me"</td>
<td style="text-align: center">"3people Unfollowed Me"</td>
</tr>
<tr>
<td>"for the last week"</td>
<td style="text-align: center">"For The Last Week"</td>
</tr>
</tbody>
      </table>
<hr>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges