/* eslint-disable */
const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

const N = +input.shift();
const arr = input.map((v) => v.split(' ').map((v) => +v));
const dp = new Array(N).fill(0);
for (let i = 0; i < N; i++) {
  //걸리는 시간 , 이익
  const [duration, profit] = arr[i];

  //현재 일자 + 걸리는시간 > 퇴사일 건너뜀
  if (i + duration > N) continue;
  //dp배열에 이익 입력
  dp[i] += profit;
  // 현재일자 + 걸리는시간 ~ 퇴사일
  for (let j = i + duration; j < N; j++) {
    dp[j] = Math.max(dp[j], dp[i]); //현재 금액, i일 뒤에 받게 될 금액 비교
  }
}
console.log(Math.max(...dp));
