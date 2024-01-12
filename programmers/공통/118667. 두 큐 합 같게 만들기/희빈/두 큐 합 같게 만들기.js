/**
 * 첫번째 방법: 배열을 직접 변경하기
 *
 * @description
 * 이렇게 배열을 직접 변경하는 경우 shift()는 시간복잡도가 O(N)이라 시간초과가 발생하여
 * shift()를 사용하지 않는 방향으로 재시도하게 되었습니다.
 * */
function solution(queue1, queue2) {
  let count = 0
  const maxLength = queue1.length + queue2.length

  let sumQueue1 = sum(queue1)
  let sumQueue2 = sum(queue2)

  // 두 합계가 같아질 때 까지 반복
  while (sumQueue1 !== sumQueue2) {
    // 합이 더 작은 배열로 값을 삽입하여 합계가 같은 경우를 찾음
    if (sumQueue1 > sumQueue2) {
      const target = queue1.shift()
      queue2.push(target)
      sumQueue1 -= target
      sumQueue2 += target
    } else {
      const target = queue2.shift()
      queue1.push(target)
      sumQueue1 += target
      sumQueue2 -= target
    }
    count++

    // 한 배열의 개수가 모든 배열의 합계보다 큰 경우 더 이상 계산될 값이 없으므로 -1 리턴
    if (queue1.length >= maxLength || queue2.length >= maxLength) {
      return -1
    }
  }

  return count
}

/**
 * 두번째 방법: 합산한 값을 이용하기
 *
 * @description
 * 배열을 직접적으로 변경하는 경우는 push()만 사용하고,
 * 그 외에는 포인터용 변수를 사용하여 합계만 다시 계산하는 로직으로 변경하였습니다.
 * */
function solution(queue1, queue2) {
  let count = 0
  const maxLength = queue1.length + queue2.length

  let sumQueue1 = sum(queue1)
  let sumQueue2 = sum(queue2)
  let queue1Index = 0;
  let queue2Index = 0;

  // 두 합계가 같아질 때 까지 반복
  while (sumQueue1 !== sumQueue2) {
    // 합이 더 작은 배열로 값을 삽입하여 합계가 같은 경우를 찾음
    if (sumQueue1 > sumQueue2) {
      sumQueue1 -= queue1[queue1Index]
      queue2.push(queue1[queue1Index])
      sumQueue2 += queue1[queue1Index++]
    } else {
      sumQueue1 += queue2[queue2Index]
      queue1.push(queue2[queue2Index])
      sumQueue2 -= queue2[queue2Index++]
    }
    count++

    // 한 배열의 개수가 모든 배열의 합계보다 큰 경우 더 이상 계산될 값이 없으므로 -1 리턴
    if (queue1Index > maxLength || queue2Index > maxLength) {
      return -1
    }
  }

  return count
}

const sum = (arr) => {
  return arr.reduce((acc, cur) => acc += cur)
}
