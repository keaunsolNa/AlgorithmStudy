// 첫번째 방법: stack 이용하기
function solution(text){
  const result = []
  let answer = true

  text.split('').map((obj) => {
    if (obj === '(') {
      result.push(obj)
    } else {
      if (result.length === 0) answer = false
      result.pop()
    }
  })

  return result.length === 0 && answer
}

// 두번째 방법: 숫자 이용하기
function solution(text){
  let result = 0
  let answer = true

  text.split('').map((obj) => {
    if (obj === '(') {
      result++
    } else {
      result--
      if (result < 0) return answer = false
    }
  })

  return result === 0 && answer
}
