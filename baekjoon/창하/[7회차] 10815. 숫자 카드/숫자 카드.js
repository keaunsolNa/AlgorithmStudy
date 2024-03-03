const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .split("\n")
  .map((e) => e.split(" ").map(Number));

function binarySearch(arr, num) {
  let start = 0;
  let end = arr.length;

  while (start <= end) {
    const mid = Math.floor((start + end) / 2);
    if (arr[mid] === num) return 1;
    else if (arr[mid] < num) {
      start = mid + 1;
    } else {
      end = mid - 1;
    }
  }
  return 0;
}

function solution() {
  let cardArr = input[1].sort((a, b) => a - b);
  let targetArr = input[3];
  let result = [];
  for (const target of targetArr) {
    result.push(binarySearch(cardArr, target));
  }
  console.log(result.join(" "));
}

solution();
