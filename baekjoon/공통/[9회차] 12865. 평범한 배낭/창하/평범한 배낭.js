/* eslint-disable */
const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

const [N, K] = input
  .shift()
  .split(' ')
  .map((v) => +v);

  // dp시에 계산을 쉽게하기위해 배열 1씩증가하여 생성
const dp = Array.from({ length: N + 1 }, () => Array(K + 1).fill(0));

// 1부터  N까지 순회
for (let i = 1; i < N + 1; i++) {
  // 주어진 무게와 가치
  const [W, V] = input
    .shift()
    .split(' ')
    .map((v) => +v);
    // 1부터 K까지 순회
  for (let j = 1; j < K + 1; j++) {
    // 현재 무게 이상의 경우 이전 dp와 현재 dp의 합중 최대값 반환
    if (j - W >= 0) dp[i][j] = Math.max(dp[i - 1][j - W] + V, dp[i - 1][j]);
    // 현재 무게 이하면 그대로
    else dp[i][j] = dp[i - 1][j];
  }
}
console.log(dp[N][K]);
