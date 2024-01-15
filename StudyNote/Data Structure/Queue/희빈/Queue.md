# ✨ 큐(Queue)
- - -
### 1.1 정의
큐 또한 임시데이터를 처리하기 위해 디자인된 데이터 구조다.
큐 연산을 묘사하는 데 쓰이는 유용한 두문자어가 **LIFO(First In, Last Out)** 이다.

큐는 다음과 같은 세 가지 제약이 있다.
* 데이터는 큐의 끝에만 삽입할 수 있다.
* 데이터는 큐의 앞에서만 삭제할 수 있다.
* 큐의 앞에 있는 원소만 읽을 수 있다.
<br><br>
   
### 1.2 용어
* **Enqueue(인큐)**: 큐에 데이터를 추가하는 작업이다. 데이터는 큐의 뒤(rear)에 추가된다.
* **Dequeue(디큐)**: 큐에서 데이터를 제거하는 작업이다. 데이터는 큐의 앞(front)에서 제거된다.
* **Peek(피크)**: 큐의 가장 앞에 있는 데이터를 조회하지만, 제거는 하지 않는다
* **isEmpty(비어있는지 확인)**: 큐가 비어있는지 여부를 확인한다.
* **size(크기 확인)**: 큐에 현재 저장된 데이터의 개수를 반환한다.
      
```javascript
class Queue {
    constructor() {
      this._arr = [];
    }
    enqueue(item) {
      this._arr.push(item);
    }
    dequeue() {
      return this._arr.shift();
    }
}

const queue = new Queue();
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
queue.dequeue(); // 1
```      
<br>

### 1.3  우선순위 큐   
* 큐 구조를 기반으로 데이터를 일렬로 늘어놓은 다음 그 중 가장 우선순위가 높은 데이터를 가장 먼저 꺼내오는 방식으로 동작한다.
* 삽입 시 우선순위를 고려하여 요소의 위치를 조정한다. 이 때 적절한 위치를 찾기 위해 우선순위를 비교하며 우선순위가 높은 요소가 먼저 위치하도록 한다.
* 큐 내에 우선순위가 같은 요소가 여러 개 있다면 일반적으로 먼저 큐에 추가된 요소가 먼저 제거된다.



> **💡 큐 vs. 우선순위 큐**  
먼저 들어온 것이 먼저 나가는(FIFO) 자료구조이고, 우선순위 큐는 우선순위가 높은 것이 먼저 나가는 자료구조이다. 큐는 먼저 들어온 것이 먼저 처리되어야 할 때 사용하고, 우선순위 큐는 처리 순서가 우선순위에 따라 결정되어야 할 때 사용한다.

   
<br>

**1.3.1 구현하기**
* _방법 1._ 배열 및 연결리스트로 구현하기
  * 하지만 삭제, 삽입 시 모든 인덱스를 탐색하는 과정이 있어 시간복잡도가 O(N)이 된다.
* _방법 2._ 힙(heap)으로 구현하기
  * O(logN)이 되어 시간복잡도 면에서 유리하다.
  * [예전에 힙 공부했던 기록: 노드 기반 자료구조: 트리(Tree) - 힙(Heap), 트라이(trie)](https://be-a-weapon.tistory.com/entry/%EB%88%84%EA%B5%AC%EB%82%98-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0%EC%99%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-12-%ED%8A%B8%EB%A6%AC)


```javascript
class MaxHeap {
  constructor() {
    this.heap = [null];
  }
  
  heap_push(value) {
    // 아래에서 위로
    this.heap.push(value);
    
    let currentIndex = this.heap.length - 1;
    let parentIndex = Math.floor(currentIndex / 2);
    while (parentIndex !== 0 && this.heap[parentIndex] < value) {
      const temp = this.heap[parentIndex];
      this.heap[parentIndex] = this.heap[currentIndex];
      this.heap[currentIndex] = temp;
      currentIndex = parentIndex;
      parentIndex = Math.floor(currentIndex / 2);
    }
  }
  
  heap_pop() {
    if (this.heap.length === 2) return this.heap.pop(); // 루트 정점만 남은 경우
    // 위에서 아래로
    let returnValue = this.heap[1];
    this.heap[1] = this.heap.pop();
    
    let currentIndex = 1;
    let leftIndex = 2;
    let rightIndex = 3;
    while (
        this.heap[currentIndex] < this.heap[leftIndex] ||
        this.heap[currentIndex] < this.heap[rightIndex]
        ) {
      const temp = this.heap[currentIndex];
      
      if (this.heap[leftIndex] < this.heap[rightIndex]) {
        this.heap[currentIndex] = this.heap[rightIndex]
        this.heap[rightIndex] = temp;
        currentIndex = rightIndex;
      } else {
        this.heap[currentIndex] = this.heap[leftIndex]
        this.heap[leftIndex] = temp;
        currentIndex = leftIndex;
      }
      
      leftIndex = currentIndex * 2;
      rightIndex = leftIndex + 1;
    }
    return returnValue;
  }
  
  heap_return() {
    return this.heap;
  }
}
```
