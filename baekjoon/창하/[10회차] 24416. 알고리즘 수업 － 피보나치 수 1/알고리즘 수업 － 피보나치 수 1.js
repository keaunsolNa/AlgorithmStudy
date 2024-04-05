/* eslint-disable */
const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');

const N = +input.shift();
let fibCount = 1;
let fibonacciCount = 1;

function fib(n) {
  if (n == 1 || n == 2) return 1;
  fibCount++;
  return fib(n - 1) + fib(n - 2);
}

const f = new Array(N).fill(0);
function fibonacci(n) {
  f[1] = 1;
  f[2] = 1;

  for (let i = 3; i < n; i++) {
    fibonacciCount++;
    f[i] = f[n - 1] + f[n - 2];
  }
  return f[n];
}
fib(N);
fibonacci(N);
console.log(fibCount, fibonacciCount);
