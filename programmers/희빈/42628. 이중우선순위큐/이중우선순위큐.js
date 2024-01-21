const TYPE = {
  '최댓값': '최댓값',
  '최솟값': '최솟값',
}
const PROCESS_TYPE = {
  '삽입': 'I',
  '삭제': 'D',
}

/**
 * @description
 * 부모 노드가 자식 노드보다 크지 않은 '최소힙'으로 구현
 */
class MinHeap {
  constructor() {
    this.heap = [null]
  }

  push(value) {
    this.heap.push(value)
    let currentIndex = this.heap.length - 1
    let parentIndex = Math.floor(currentIndex / 2)

    // 현재 값보다 부모 값이 더 작을 떄 까지 (=최소힙의 형태를 만들 때 까지) swap 한다.
    while (parentIndex !== 0 && this.heap[currentIndex] < this.heap[parentIndex]) {
      this.swap(currentIndex, parentIndex)
      currentIndex = parentIndex
      parentIndex = Math.floor(currentIndex / 2)
    }
  }

  pop(deleteTarget) {
    if (this.isEmpty()) return
    if (this.heap.length === 2) return this.heap.pop() // 루트 정점만 남은 경우

    if (deleteTarget === TYPE.최댓값) {
      const parentIndex = Math.floor((this.heap.length - 1) / 2);
      const lastLeaf = this.heap.slice(parentIndex);
      const max = Math.max(...lastLeaf);
      this.swap(parentIndex + lastLeaf.indexOf(max), this.heap.length - 1);
      return this.heap.pop();
    }

    const returnValue = this.heap[1]
    this.heap[1] = this.heap.pop()

    let currentIndex = 1
    let leftIndex = 2
    let rightIndex = 3

    while (
        this.heap[leftIndex] && this.heap[currentIndex] > this.heap[leftIndex] ||
        this.heap[rightIndex] && this.heap[currentIndex] > this.heap[rightIndex]
        ) {

      switch (true) {
        case this.heap[leftIndex] === undefined:
          this.swap(rightIndex, currentIndex)
          break

        case this.heap[rightIndex] === undefined:
          this.swap(leftIndex, currentIndex)
          break

        case this.heap[leftIndex] > this.heap[rightIndex]:
          this.swap(currentIndex, rightIndex)
          currentIndex = rightIndex;
          break

        case this.heap[leftIndex] <= this.heap[rightIndex]:
          this.swap(currentIndex, leftIndex)
          currentIndex = leftIndex;
          break
      }

      leftIndex = currentIndex * 2
      rightIndex = currentIndex * 2 + 1
    }

    return returnValue
  }

  isEmpty() {
    return this.heap.length === 1
  }

  swap(a, b) {
    [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
  }

  return() {
    if (this.isEmpty()) return [0, 0] // 비어있을 경우 [0, 0] 리턴
    if (this.heap.length === 2) return [this.heap[1], this.heap[1]]

    const parentIndex = Math.floor((this.heap.length - 1) / 2);
    const lastLeaf = this.heap.slice(parentIndex);
    const max = Math.max(...lastLeaf);
    return [max, this.heap[1]];
  }
}

function solution(operations) {
  const heap = new MinHeap()
  operations.forEach((operation) => {
    const [processType, number] = operation.split(' ').map((value, index) => {
      // 값의 자료형을 [string, number]로 치환
      return index === 1 ? Number(value) : value
    })

    if (processType === PROCESS_TYPE.삽입) {
      heap.push(number)
    } else {
      heap.pop(number < 0 ? TYPE.최솟값 : TYPE.최댓값)
    }
  })

  return heap.return()
}
