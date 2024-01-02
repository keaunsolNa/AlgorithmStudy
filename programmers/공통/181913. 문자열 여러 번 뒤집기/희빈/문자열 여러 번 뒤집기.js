function solution(text, queries) {
  let tempArr = [...text]
  queries.map(([start, end]) => {
    const reverseArr = tempArr.slice(start, end+1).reverse()
    tempArr.splice(start, reverseArr.length, ...reverseArr)
  })

  return tempArr.join('')
}
