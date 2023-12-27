function solution(score) {
  const avgArr = score.map(([a, b]) => (a + b) / 2)
  const sortedArr = [...avgArr].sort((a, b) => b - a)

  return avgArr.map((obj) => sortedArr.indexOf(obj) + 1)
}
