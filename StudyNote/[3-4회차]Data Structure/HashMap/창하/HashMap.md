# **HashMap의 선언**
---
기본적으로 Map은 <code>key:value</code> 형태로 구성되어 있습니다. 시험 성적으로 예를들면, {국어=90점, 수학=80점} 식으로 구성되어 있습니다. 각각의 과목이 <code>key</code>, 점수를 <code>value</code>라고 생각하면 됩니다. 그리고 <code>key</code>는 Set와 마찬가지로 중복이 불가능합니다.

```JAVA
HashMap<String,Integer> myMap = new HashMap<String, Integer>();
System.out.println(myMap.toString()); //{}
```
Map은 <code>key:value</code> 형태의 값이 필요합니다. 따라서 꺽쇠 안에 들어가야 하는 변수는 Type도 두 개 입니다. 예시에서는 <code>key</code>에는 <code>String</code>이, <code>value</code> 에는 <code>Integer</code> Type이 들어가는 HashMap을 사용하기로 하였습니다. Map은 중괄호 <code>{}</code>형태가 출력되는 것이 특징입니다.

# **HashMap의 주요 메서드**


```JAVA
    //1. put
    myMap.put("Korean", 90);
    myMap.put("Math", 80);
    myMap.put("English", 87);
    myMap.put("Science", 90);

    System.out.println(myMap.toString());   //{English=87, Science=90, Korean=90, Math=80}

    myMap.put("English", 95);

    System.out.println(myMap.toString());   //{English=95, Science=90, Korean=90, Math=80}

    //2. remove
    myMap.remove("English");

    System.out.println(myMap.toString());   //{Science=90, Korean=90, Math=80}

    //3. get
    System.out.println(myMap.get("Korean"));        //90

    //4. size
    System.out.println(myMap.size());       //3

    //5. contains
    System.out.println(myMap.containsKey("Math"));  //true
    System.out.println(myMap.containsKey("English"));   //false
    System.out.println(myMap.containsValue(90));    //true

    //6. keySet, Values
    System.out.println(myMap.keySet());             //[Science, Korean, Math]

    System.out.println(myMap.values());             //[90, 90, 80]

    //7. forEach
    for(String subject: myMap.keySet()) {
        System.out.println(subject);    //Science, ...
    }

```
Map은 구조가 상대적으로 복잡하여 활용하기 위한 메서드도 많은 편입니다.

# **put**
---
Map 안에 값을 넣기 위해서는 put을 사용합니다. 선언부에서 정의했던 자료형의 쌍을 집어넣게 되는데, 작성한 코드의 순서와는 상관없이 값이 저장됩니다. 또한 key값은 중복이 불가능합니다.

# **remove**
---
Map에서는 remove(key) 형식으로 삭제를 진행하며 remove의 결과로 해당 key와 value가 모두 지워지게 됩니다.

# **get**
---
get메서드 또한 key를 사용하여 value를 호출하게 됩니다.

# **size**
---
size메서드는 Map의 크기를 int Type으로 반환하는 메서드입니다.

# **contains**
---
Map에는 key포함 여부를 확인하는 containKey와 Value포함 여부를 확인하는 containValue라는 메서드가 구현되어 있습니다.

# **keySet, Values**
---
keySet은 Map이 가지고 있는 Key를, Values는 Map이 가지고 있는 Value를 각각 반환합니다.

# **forEach**
---
Map의 반복문은 keySet()의 결과인 key의 집합을 돌면서 수행하게 됩니다.

```JAVA
    for(String subject: myMap.keySet()) {
        System.out.println(subject+" : "+myMap.get(subject));   //Science : 90, ...
    }

```

# **결론**
---
Map은 순서쌍이나 그래프문제를 풀 때 많이 사용하게 됩니다. 예를 들어, 1번 노드와 연결된 2번 노드가 있다고 가정할때, 이것을 구현해 보면 {key : value}={node1 : node2} 처럼 표시할 수 있습니다. 하지만 3번 노드, 4번 노드... 등도 연결 되어 있다면 복수의 자료를 저장해야 함으로 Map안에 List를 넣게 됩니다.

```JAVA
    //1.Map<String, List> 만들기
    HashMap<String,ArrayList<String>> myMap=new HashMap<String, ArrayList<String>>();

    //2.Value가 될 List 만들기
    ArrayList<String> myList=new ArrayList<String>();

    //3. List 채우기
    myList.add("node2");
    myList.add("node3");

    //4. Map안에 key와 value 넣기
    myMap.put("node1",myList);

    System.out.println(myMap.toString());   //{node1=[node2, node3]}

```
위와 같은 방법으로 {key : value}={node1 : [node2, node3, ...]}식으로 정리 할 수 있습니다.

# JavaScript Map
---

## **new Map()**
	새로운 Map 객체를 생성합니다.

## **set()**
	set() 메서드는 Map 객체에서 주어진 키와 값을 추가하거나 업데이트 합니다.

```javascript
const map1 = new Map();
map1.set('bar', 'foo');

console.log(map1.get('bar'));
// Expected output: "foo"

console.log(map1.get('baz'));
// Expected output: undefined

```
set(key, value)
	key : Map 객체에 추가되는 요소의 키
	value : Map 객체에 추가되는 요소의 값
	반환 값 : Map 객체

## **get()**
	get() 메서드는 Map 객체에서 특정 요소를 반환합니다. 만약 주어진 키와 관련된 값이 객체라면 해당 객체에 대한 참조만 가져오고, 해당 객체에 대한 모든 변경은 Map 내에서 효율적으로 수정됩니다.


```javascript
const map1 = new Map();
map1.set('bar', 'foo');

console.log(map1.get('bar'));
// Expected output: "foo"

console.log(map1.get('baz'));
// Expected output: undefined

```
get(key)
	key : Map 객체에서 반환받을 요소의 키
	반환 값 : 명명시된 키와 연관된 요소 혹은 `Map` 객체에서 해당 키를 찾을 수 없는 경우 undefined

## **size**
	size 접근자 속성은 Map 객체의 요소 수를 반환합니다.


```javascript
const map1 = new Map();

map1.set('a', 'alpha');
map1.set('b', 'beta');
map1.set('g', 'gamma');

console.log(map1.size);
// Expected output: 3

```
`size` 값은 `Map` 객체에 몇 개의 항목이 있는지 나타내는 정수입니다. `size` 설정 접근자 함수는 `undefined` 이므로 이 속성을 변경할 수 없습니다.

## **clear()**
	clear() 메서드는 Map 객체의 모든 요소를 제거합니다.


```javascript
const map1 = new Map();

map1.set('bar', 'baz');
map1.set(1, 'foo');

console.log(map1.size);
// Expected output: 2

map1.clear();

console.log(map1.size);
// Expected output: 0

```
clear()
	반환 값 : undefined

## **delete()**
	delete() 메서드는 키로 Map 객체에서 특정 요소를 제거합니다.


```javascript
const map1 = new Map();
map1.set('bar', 'foo');

console.log(map1.delete('bar'));
// Expected result: true
// True indicates successful removal

console.log(map1.has('bar'));
// Expected result: false

```
delete(key)
	key : Map 객체에서 제거할 요소의 키
	반환 값 : Map 객체에서 요소가 존재하고 제거된 경우 true, 그렇지 않고 해당 요소가 존재하지 않으면 false를 반환합니다.

## **entries()**
	entries() 메서드는 새 반복자 객체를 반환합니다. 이 객체에는 Map 객체의 각 요소에 대한 [key, value] 쌍이 삽입 순서대로 포함됩니다. 이 특별한 경우, 이 반복자 객체도 반복이 가능하므로 for-of 루프를 사용할 수 있습니다. [Symbol.iterator] 프로토콜이 사용될 경우, 호출될 때 반복자 자체를 반환하는 함수를 반환합니다


```javascript
const map1 = new Map();

map1.set('0', 'foo');
map1.set(1, 'bar');

const iterator1 = map1.entries();

console.log(iterator1.next().value);
// Expected output: Array ["0", "foo"]

console.log(iterator1.next().value);
// Expected output: Array [1, "bar"]

```
entries()
	반환 값 : 새로운 순회 가능한 반복자 객체


## **forEach()**
	forEach() 메서드는 삽입 순서에 따랄 Map 객체의 키/값 쌍마다 한 번씩 제공된 함수를 실행합니다.


```javascript
function logMapElements(value, key, map) {
  console.log(`m[${key}] = ${value}`);
}

new Map([
  ['foo', 3],
  ['bar', {}],
  ['baz', undefined],
]).forEach(logMapElements);

// Expected output: "m[foo] = 3"
// Expected output: "m[bar] = [object Object]"
// Expected output: "m[baz] = undefined"

```

forEach(callbackFn)
forEach(callBackFn, thisArg)
	callbackFn : 맵의 각 항목에 대해 실행할 함수입니다. 이 함수는 다음 인수를 사용하여 호출됩니다.
		value : 각 반복의 값입니다
		key : 각 반복의 키입니다.
		map : 반복되는 map입니다.
	thisArg( optional ) : callbackFn을 실행하고 있을 때 this로 사용하는 값.
	반환 값 : undefined

## **has()**
	has() 메서드는 주어진 키에 해당하는 요소가 존재 여부를 가리키는 불리언 값을 반환합니다.


```javascript
const map1 = new Map();
map1.set('bar', 'foo');

console.log(map1.has('bar'));
// Expected output: true

console.log(map1.has('baz'));
// Expected output: false

```
has(key)
	key : Map 객체에서 존재를 확인할 요소의 키
	반환 값 : 만약 주어진 키에 해당하는 요소가 Map객체에 존재한다면 true, 그렇지 않으면 false

## **keys()**
	keys() 메서드는 배열에서 각 인덱스의 키를 포함하는 새로운 맵 반복자 객체를 반환합니다.


```javascript
const map1 = new Map();

map1.set('0', 'foo');
map1.set(1, 'bar');

const iterator1 = map1.keys();

console.log(iterator1.next().value);
// Expected output: "0"

console.log(iterator1.next().value);
// Expected output: 1

```

keys()
	반환 값 : 새로운 순회 가능한 반복자 객체


## **values()**
	values()메서드는 배열의 각 아이템의 값을 순회하는 새로운 맵 반복자 객체를 반환합니다.


```javascript
const map1 = new Map();

map1.set('0', 'foo');
map1.set(1, 'bar');

const iterator1 = map1.values();

console.log(iterator1.next().value);
// Expected output: "foo"

console.log(iterator1.next().value);
// Expected output: "bar"

```
values()
	반환 값 : 새로운 순회 가능한 반복자 객체