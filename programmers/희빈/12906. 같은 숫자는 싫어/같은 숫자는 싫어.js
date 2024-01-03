function solution(arr) {
  const removeArr = []
  for (let i=0; i<arr.length; i++) {
    const [ a, b ] = [arr[i], arr[i+1]]
    if (a !== b) {
      removeArr.push(a)
    }
  }

  return removeArr
}