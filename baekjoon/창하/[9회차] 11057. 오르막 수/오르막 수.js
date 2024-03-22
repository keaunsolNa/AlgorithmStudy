/* eslint-disable */
const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

/*
오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.
예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.
수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.
*/

// 수의 길이
const N = +input;

//dp 2차원 배열
const dp = Array.from(Array(N + 1), () => new Array());

// dp[0]은 무시
// dp[1]은 한자리수에 경우의수는 한가지뿐
// dp[2]는 두자리수에 경우의수는 1씩 증가
dp[1] = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1];
dp[2] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

//점화식
//dp[i][j] = dp[i-1][j+1]까지의 인덱스 합
for (let i = 3; i <= N; i++) {
  for (let j = 0; j < dp[i - 1].length; j++) {
    const value = [...dp[i - 1]];

    dp[i][j] = value.slice(0, j + 1).reduce((acc, cur) => acc + cur) % 10007;
  }
}

console.log(dp[N].reduce((acc, cur) => acc + cur) % 10007);
