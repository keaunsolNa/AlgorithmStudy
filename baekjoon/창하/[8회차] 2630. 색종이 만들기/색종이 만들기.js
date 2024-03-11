/* eslint-disable */
const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

const N = +input.shift();
const arr = input.map((v) => v.split(' ').map((v) => +v));
const answer = [0, 0];
function quad(size, start) {
  const first = arr[start[0]][start[1]];
  if (size === 1) {
    first === 0 ? answer[0]++ : answer[1]++;
    return;
  }

  let flag = true;

  for (let i = start[0]; i < start[0] + size; i++) {
    for (let j = start[1]; j < start[1] + size; j++) {
      if (first !== arr[i][j]) {
        flag = false;
        break;
      }
    }
    if (!flag) break;
  }

  if (flag) {
    first === 0 ? answer[0]++ : answer[1]++;
    return;
  }

  const half = size / 2;
  quad(half, start);
  quad(half, [start[0], start[1] + half]);
  quad(half, [start[0] + half, start[1]]);
  quad(half, [start[0] + half, start[1] + half]);
  return;
}

quad(N, [0, 0]);
console.log(answer[0] + '\n' + answer[1]);
