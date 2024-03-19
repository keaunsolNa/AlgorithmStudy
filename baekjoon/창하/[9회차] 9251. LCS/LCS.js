/* eslint-disable */
const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

const A = input.shift().split('');
const B = input.shift().split('');
const LCS = Array.from({ length: A.length + 1 }, () =>
  Array(B.length + 1).fill(0)
);

for (let i = 0; i < A.length + 1; i++) {
  for (let j = 0; j < B.length + 1; j++) {
    if (i === 0 || j === 0) {
      LCS[0][0] = 0;
    } else if (A[i - 1] == B[j - 1]) {
      LCS[i][j] = LCS[i - 1][j - 1] + 1;
    } else {
      LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
    }
  }
}

console.log(LCS[A.length][B.length]);
