# ✨ 스택(Stack)
- - -
### 1.1 정의
스택이 데이터를 저장하는 방법은 배열과 같으며 단순히 원소들의 리스트이다.
스택 연산을 묘사하는 데 쓰이는 유용한 두문자어가 **LIFO(Last In, First Out)** 이다.

스택은 다음과 같은 세 가지 제약이 있다.
* 데이터는 스택의 끝에만 삽입할 수 있다.
* 데이터는 스택의 끝에서만 삭제할 수 있다.
* 스택의 마지막 원소만 읽을 수 있다.
* 접시 더미나 수직으로 놓인 배열로 묘사하여 생각해보자.

<br>

### 1.2 용어

* **데이터 스택에 넣기**: push(), append()
* **데이터 스택에서 꺼내기**: pop()

```javascript
class Stack {
  constructor() {
    this._arr = [];
  }
  push(item) {
    this._arr.push(item);
  }
  pop() {
    return this._arr.pop();
  }
  peek() {
    return this._arr[this._arr.length - 1];
  }
}

const stack = new Stack();
stack.push(1);
stack.push(2);
stack.push(3);
stack.pop(); // 3
```

<br>

### 1.3 덱/데크(Deque)
* 선형 구조에는 큐, 스택, 덱이 있다.
* 양방향 큐이다.
* 양쪽 끝에서 삽입과 삭제가 가능한 자료구조를 의미한다.
* 데크는 양 끝 엘리먼트의 append()와 pop()이 O(1)로 압도적으로 빠르다.

```javascript
class Deque {
  constructor() {
    this.arr = [];
    this.head = 0;
    this.tail = 0;
  }
  
  push_front(item) {
    // 0번 인덱스에 값이 있다면 뒤로 한 칸씩 미룬다.
    if (this.arr[0]) {
      for (let i = this.arr.length; i > 0; i--) {
        this.arr[i] = this.arr[i - 1];
      }
    }
    this.arr[this.head] = item;
    this.tail++;
  }
  
  push_back(item) {
    this.arr[this.tail++] = item;
  }
  
  pop_front() {
    // deque에 요소가 있는지 판단
    if (this.head >= this.tail) {
      return null;
    } else {
      const result = this.arr[this.head++];
      return result;
    }
  }
  
  pop_back() {
    // deque에 요소가 있는지 판단
    if (this.head >= this.tail) {
      return null;
    } else {
      const result = this.arr[--this.tail];
      return result;
    }
  }
}

let deque = new Deque();
deque.push(1); // arr: [1], head: 0, tail: 1
deque.push(2); // arr: [1, 2], head: 0, tail: 2
deque.push(3); // arr: [1, 2, 3], head: 0, tail: 3
deque.popleft(); // result: 1, arr: [2, 3], head: 1, tail: 3
deque.pop(); // result: 3, arr: [2] head: 1, tail: 2
```

