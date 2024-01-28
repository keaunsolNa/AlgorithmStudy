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

  /*
    .map 은 기존의 배열이 아닌 새 배열을 반환하는 반면 forEach()는 그렇지 않습니다.
    주어진 문자열을 Character 단위로 뜯어내기만 하는 위 문제의 경우 기존 배열의 값을 기반으로 새 배열을 생성할 필요가 없으며
    각 요소에 대해서만 작업을 수행해야 하므로 forEach()가 더 나은 선택이 된다고 합니다.

    (https://medium.com/web-development-with-sumit/which-is-faster-in-javascript-map-vs-foreach-4d5a62daaaa6)

      let result = 0
      let answer = true

      for (let obj of text) {

          if (obj === '(') {
              result++
          } else {
              result--
              if (result < 0) return answer = false
          }

      }

      return result === 0 && answer

    위 방식으로 수행 시 수행 시간 측면에서 유의미한 차이가 있었습니다.

    또한, 이는 수행시간 측면에서는 의미는 없지만 삼항 연산자를 적극적으로 활용하면 코드가 더 멋있어(?) 보입니다....

      function solution(text){

      let result = 0

      for (let obj of text) {

          result += obj === '(' ? 1 : -1;
          if(result < 0) return false;
      }

      return result === 0

}
   */
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
