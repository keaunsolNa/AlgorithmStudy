/* eslint-disable */
const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, A, M, B] = input.map((v) => v.split(" ").map((x) => Number(x)));
// A.sort((a, b) => a - b);

// //binarySearch
// const binarySearch = (list, target) => {
//   let min = 0;
//   let max = list.length - 1;

//   while (min <= max) {
//     const mid = Math.floor((min + max) / 2);
//     if (list[mid] === target) return 1;
//     else if (list[mid] > target) {
//       max = mid - 1;
//     } else {
//       min = mid + 1;
//     }
//   }
//   return 0;
// };

// const result = B.map((v) => console.log(binarySearch(A, v)));
// console.log(result.join("\n"));

const array = new Set(A);

const result = B.map((v) => (array.has(v) ? 1 : 0));

console.log(result.join("\n"));
