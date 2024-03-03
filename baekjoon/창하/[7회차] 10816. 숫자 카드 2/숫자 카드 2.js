const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, A, M, B] = input.map((v) => v.split(" ").map((x) => Number(x)));

let map = new Map();

A.forEach((v) => {
  if (map.has(v)) map.set(v, map.get(v) + 1);
  else map.set(v, 1);
});

let answer = [];
B.forEach((v) => answer.push(map.get(v) || 0));

console.log(answer.join(" "));
