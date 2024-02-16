function solution(bridge_length, weight, truck_weights) {
  const currentBridge = []
  let count = 0

  while (truck_weights.length !== 0) {
    // 현재 다리에 올라와있는 트럭의 총 개수가 다리의 길이와 같으면
    // 다음 트럭을 추가하기위해 하나를 없앤다.
    if (currentBridge.length === bridge_length) {
      currentBridge.shift()
    }

    // 무게제한으로 트럭이 올라올 수 없다면 무게가 0인 트럭을 올린다.
    if (sum(currentBridge) + truck_weights[0] > weight) {
      currentBridge.push(0)
    } else {
      currentBridge.push(truck_weights[0])
      truck_weights.shift()
    }

    count++
  }

  // 마지막 트럭이 지나는 시간을 더해준다.
  count += bridge_length

  return count
}

const sum = (arr) => arr.reduce((acc, cur) => acc+cur, 0)
