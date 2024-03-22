/* eslint-disable */
const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

const N = +input.shift();
const arr = input.map((v) => v.split(' ').map((v) => +v));

for (let i = 1; i < N; i++) {
  for (let j = 0; j < arr[i].length; j++) {
    // 왼쪽 가장자리
    if (j === 0) {
      arr[i][j] = arr[i][j] + arr[i - 1][j];
      // 오른쪽 가장자리
    } else if (i === j) {
      arr[i][j] = arr[i - 1][j - 1] + arr[i][j];
      // 가운데 자리
    } else {
      arr[i][j] = Math.max(arr[i - 1][j - 1], arr[i - 1][j]) + arr[i][j];
    }
  }
}

console.log(Math.max(...arr[N - 1]));
