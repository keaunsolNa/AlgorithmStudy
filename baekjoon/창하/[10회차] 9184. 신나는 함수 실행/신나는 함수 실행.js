/* eslint-disable */
const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');
input.pop();
const arr = input.map((v) => v.split(' ').map((v) => +v));
const dp = Array.from({ length: 51 }, () =>
  Array.from({ length: 51 }, () => Array(51).fill(0))
);
function w(x, y, z) {
  if (x <= 0 || y <= 0 || z <= 0) return 1;

  if (x > 20 || y > 20 || z > 20) return w(20, 20, 20);

  if (dp[x][y][z]) return dp[x][y][z];

  if (x < y && y < z)
    dp[x][y][z] = w(x, y, z - 1) + w(x - 1, y - 1, z) - w(x - 1, y - 1, z - 1);
  else
    dp[x][y][z] =
      w(x - 1, y, z) +
      w(x - 1, y - 1, z) +
      w(x - 1, y, z - 1) -
      w(x - 1, y - 1, z - 1);

  return dp[x][y][z];
}

const result = arr.map((v) => {
  const [a, b, c] = v;
  return `w(${a}, ${b}, ${c}) = ${w(a, b, c)}`;
});
console.log(result.join('\n'));
