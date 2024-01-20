import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for(int i = 0; i < truck_weights.length; i++) {

            // 개별 트럭의 무게마다 탐색
            int truck = truck_weights[i];
            while(true) {

                // 기존에 큐가 비어 있다면
                if(queue.isEmpty()) {

                    // 큐에 트럭을 넣고
                    queue.add(truck);
                    // 누적합에 트럭의 무게를 더한다.
                    sum += truck;
                    // 시간 + 1 
                    time++;
                    break;

                // 큐의 현재 사이즈가 다리의 길이와 같다면 (더 이상 트럭이 올라갈 수 없다면) 누적합에서 가장 앞에 있는 트럭의 무게 제외
                } else if(queue.size() == bridge_length) sum -= queue.poll();

                // 큐가 차 있으며 사이즈가 초과되지 않았다면
                else  {

                    // 누적합에 신규 트럭의 무게가 한계 무계 이하라면
                    if(sum + truck <= weight) {

                        // 큐에 트럭을 더하고 
                        queue.add(truck);
                        //누적합과 시간 연산
                        sum += truck;
                        time++;
                        break;

                    //한계 무게 이상이라면
                    } else {

                        // 큐에 빈 값을 더하고 시간 ++
                        queue.add(0);
                        time++;

                    }
                }
            }
        }

        // 시간 + 다리의 길이가 정답
        return time + bridge_length;
    }
}