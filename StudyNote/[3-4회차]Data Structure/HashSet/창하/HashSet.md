# 세트(Set) - HashSet의 특징
---
- 저장된 값을 Index로 관리하지 않습니다.
- 값을 넣는 순서와 상관없이 저장됩니다.
- **세트 안에 이미 존재하는 값이면 저장되지 않습니다.(중복이 허용되지 않습니다)**

Set을 사용하는 가장 주된 이유는 앞서 설명하듯이 중복이 허용되지 않기 때문입니다. 값을 자루구조에 넣을 때 마다 이미 들어가 있는 값인지 확인해야 할 필요가 없다는 뜻입니다. 세트의 종류에는 여러가지가 존재하며 HashSet이 가장 대표적인 구조입니다.

# HashSet의 선언
---
```JAVA
//선언
HashSet<Integer> mySet = new HasSet<Integer>(); 

//문자열로 변환
System.out.println(mySet.toString());
```
	HashSet을 정의하고 꺽쇠 안에 저장할 자료형을 선택하여 명시합니다.

# HashSet의 주요 메서드
---

```JAVA
HashSet<Integer> mySet = new HashSet<Integer>();

//1. add
mySet.add(11);
mySet.add(11);
mySet.add(11);
mySet.add(21);
mySet.add(31);
mySet.add(41);

System.out.println(mySet.toString());   //[21, 41, 11, 31]

//2. remove
mySet.remove(11);

System.out.println(mySet.toString());   //[21, 41, 31]

mySet.remove(1);

System.out.println(mySet.toString());   //[21, 41, 31]

//3. size
System.out.println(mySet.size());       //3

//4. contains
System.out.println(mySet.contains(1));  //false
System.out.println(mySet.contains(21)); //true

//5. forEach
for(int i : mySet) {
System.out.println(i);              //21 41 31
}
```
## add
	세트에 값을 넣을 떄에도 다른 자료구조와 같이 를 사용합니다
	출력된 결과를 보게되면, 중복을 허용하지 않고 저장 시 순서가 임의로 결정된다는 것을 알 수 있습니다.

## remove
	값을 제거할 때는 remove를 사용하며, ()안에는 제거하고자 하는 값을 입력합니다. 만약 괄호 안에 입력한 값이 Set안에 저장되지 않은 값일 경우 아무일도 발생하지 않습니다.

## size
	Set의 크기를 확인하기 위해서는 size를 사용합니다. 반환되는 값은 0보다 크거나 같은 int값을 반환하게 됩니다.

## contains
	생성한 Set 안에 원하는 값이 들어있는지를 확인하는 함수입니다. boolean Type의 반환값을 갖습니다.

## forEach
	Set은 index로 값들을 관리하지 않습니다. 따라서 다른 자료구조에서 했듯이 .get()등의 메서드는 존재하지 않습니다. 따라서 반복문을 사용할때도 기존에 다루었던 for문과 다른 형태의 반복문을 사용하며, 이를 forEach문 이라고 부릅니다. 괄호 ()안에는 루프(Loop)를 돌 자료구조를 명시하고, 루프를 반복해서 수행하는 동안 값들을 부를 이름을 정하게 됩니다.

```JAVA
	for(int i : mySet){
		System.out.println(i); // 21 41 31
	}
```

	Set안에 있는 int 값들은, 자료구조의 특성상 따로 index도 없고, 변수명도 없기 때문에 부르기 곤란합니다. 따라서 반복문을 수행하면서 i라고 정하고 mySet에 저장된 값인 i를 출력하는 prinrt문을 차례대로 수행합니다.

# 결론
---
따라서 값을 저장할 때 중복을 허용하지 않고 정렬이 필요하지 않은 경우 HashSet을 사용하게 됩니다. 예를 들어 문제에서 좌표가 입력값으로 주어지는데 여러번 반복해서 나올 수 있는 경우, 굳이 중복으로 저장할  필요 없이 Set을 쓰면 깔끔하게 저장이 될 것입니다.


# **JavaScript Set**
---

# **Set 생성 new Set()**
---
자바스크립트에서 Set는 클래스(Class)이므로 new 키워드와 생성자를 사용하여 객체를 생성 할 수 있습니다.

```javascript
const set = new Set(); // Set(0) {size: 0}
```
위와 같이 생성자의 인자로 아무것도 넘기지 않으면 빈 세트가 만들어지며, 아래와 같이 배열을 인수로 넘기면 배열에 담긴 값으로 세트가 만들어집니다.

```javascript
const numSet = new Set([1, 2, 3]); // Set(3) {1, 2, 3}
```

# **값 추가** add()
---
세트에 새로운 값을 추가할 때는 add() 메서드를 사용합니다. 세트에는 중복된 값이 추가되지 않으며, 유일한 값만 저장됩니다.

```javascript
set.add(1); // Set(1) {1}
set.add("A"); // Set(2) {1, 'A'}
set.add(true); // Set(3) {1, 'A', true}

-------
set.add(1).add("A").add(true); //위와 같습니다.
```

# **값 삭제** remove()
---
Set의 delete() 메서드를 사용하면 세트로 부터 특정 값을 삭제할 수 있습니다.  delete()메서드에 인자로 넘기는 값이 세트에 존재하여 성공적으로 삭제하였으면 true를 반환하고, 해당 값이 세트에 존재하지 않아서 삭제에 실패하였다면 false를 반환합니다.

```javascript
set.delete(1); //true
set.delete(2); //false
```

# **값 존재 여부 확인** has()
---
세트에 특정 값이 존재하는지 확인하려면 has()메서드를 사용합니다.

```javascript
if (set.has("A")){
	console.log("A는 세트에 존재합니다.") // A는 세트에 존재합니다.
}

const result = set.has("B") ? "YES" : "NO"; //No
```

# **값의 개수 확인 size**
---
세트의 size 속성을 통해서 해당 세트의 길이, 즉 얼마나 많은 값이 저장되어 있는지를 알아낼 수 있습니다.

```javascript
console.log(set.size); // 2
```

# **모든 값 제거 clear()**
---
Set 객체의 모든 값을 제거하려면 clear() 메서드를 사용합니다.

```javascript
set.clear(); // Set(0) {size : 0}
```

# **세트 순회 for ... of**
---
세트에 저장되어 있는 모든 값을 순회하고 싶을 때는 어떻게 해야 할까요? 이 때는 for 루프안에서 of 연산자를 사용하면 됩니다.

```javascript
for (const num of numSet){
	console.log(num);
}
```
배열처럼 세트도 forEach() 함수로 제공하고 있기 때문에 활용할 수 있습니다.

```javascript
numSet.forEach((num) => console.log(num));
```

# **배열을 세트로 변환**

```javascript
const array = [1, 2, 2, 3, 3, 3];
const set = new Set(array); // Set(3) {1, 2, 3}
```
이렇게 배열로 부터 세트를 만들어내면 중복 값이 모두 제거됩니다.

# **세트를 배열로 변환**
---

```javascript
const array = [...set]; // [1, 2, 3]

const array = Array.from(set); // [1,2,3]
```

