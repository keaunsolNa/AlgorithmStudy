# [level 1] 다리를 지나는 트럭 - 42583

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12932)

### 성능 요약

테스트 1 〉	통과 (1.61ms, 34MB)<br>
테스트 2 〉	통과 (41.02ms, 38.1MB)<br>
테스트 3 〉	통과 (0.29ms, 33.5MB)<br>
테스트 4 〉	통과 (56.83ms, 37.2MB)<br>
테스트 5 〉	통과 (67.17ms, 37.1MB)<br>
테스트 6 〉	통과 (53.54ms, 37.2MB)<br>
테스트 7 〉	통과 (0.80ms, 33.8MB)<br>
테스트 8 〉	통과 (0.45ms, 33.5MB)<br>
테스트 9 〉	통과 (10.71ms, 37.9MB)<br>
테스트 10 〉	통과 (0.46ms, 33.5MB)<br>
테스트 11 〉	통과 (0.21ms, 33.5MB)<br>
테스트 12 〉	통과 (0.40ms, 33.6MB)<br>
테스트 13 〉	통과 (0.95ms, 34MB)<br>
테스트 14 〉	통과 (0.30ms, 33.5MB)<br>

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 12월 24일 15:28

### 문제 설명

<h6 class="guide-section-title">문제 설명</h6>
<div class="markdown solarized-dark"><p>트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.</p>

<p>예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.</p>
<table class="table">
        <thead><tr>
<th>경과 시간</th>
<th>다리를 지난 트럭</th>
<th>다리를 건너는 트럭</th>
<th>대기 트럭</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>[]</td>
<td>[]</td>
<td>[7,4,5,6]</td>
</tr>
<tr>
<td>1~2</td>
<td>[]</td>
<td>[7]</td>
<td>[4,5,6]</td>
</tr>
<tr>
<td>3</td>
<td>[7]</td>
<td>[4]</td>
<td>[5,6]</td>
</tr>
<tr>
<td>4</td>
<td>[7]</td>
<td>[4,5]</td>
<td>[6]</td>
</tr>
<tr>
<td>5</td>
<td>[7,4]</td>
<td>[5]</td>
<td>[6]</td>
</tr>
<tr>
<td>6~7</td>
<td>[7,4,5]</td>
<td>[6]</td>
<td>[]</td>
</tr>
<tr>
<td>8</td>
<td>[7,4,5,6]</td>
<td>[]</td>
<td>[]</td>
</tr>
</tbody>
      </table>
<p>따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.</p>

<p>solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.</p>

<h5>제한 조건</h5>

<ul>
<li>bridge_length는 1 이상 10,000 이하입니다.</li>
<li>weight는 1 이상 10,000 이하입니다.</li>
<li>truck_weights의 길이는 1 이상 10,000 이하입니다.</li>
<li>모든 트럭의 무게는 1 이상 weight 이하입니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>bridge_length</th>
<th>weight</th>
<th>truck_weights</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>2</td>
<td>10</td>
<td>[7,4,5,6]</td>
<td>8</td>
</tr>
<tr>
<td>100</td>
<td>100</td>
<td>[10]</td>
<td>101</td>
</tr>
<tr>
<td>100</td>
<td>100</td>
<td>[10,10,10,10,10,10,10,10,10,10]</td>
<td>110</td>
</tr>
</tbody>
</table>
</div>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges