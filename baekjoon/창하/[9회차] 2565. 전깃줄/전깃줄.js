/* eslint-disable */
const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

//전기줄 개수
const line = +input.shift();
//전기줄 배열 시작지점 오름차순
const lineMap = input
  .map((v) => v.split(' ').map((v) => +v))
  .sort((a, b) => a[0] - b[0]);

//전기줄 개수만큼의 1의 배열
const lis = new Array(line).fill(1);
//LIS (최장 증가 부분 수열 적용)
//오른쪽 전기줄이 낮아질때를 구하면된다...?
for (let i = 1; i < line; i++) {
  for (let j = 0; j < i; j++) {
    if (lineMap[i][1] > lineMap[j][1]) {
      lis[i] = Math.max(lis[i], lis[j] + 1);
    }
  }
}
console.log(line - Math.max(...lis));
