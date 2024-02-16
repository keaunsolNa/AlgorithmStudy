import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
       // bridge_length 1당 1초 소요

        int answer = bridge_length; // 다리를 건너는데 걸리는 시간
        int temp_weight = weight;
        Queue<Integer> queue = new LinkedList<>();  // 대기 트럭
        Queue<Integer> queue2 = new LinkedList<>();  // 다리를 건너는 트럭

        for(int i = 0; i<truck_weights.length; i++){
            queue.add(truck_weights[i]);
        }

        for(int j= 0; j < bridge_length; j++){
            queue2.add(0);  // 일단 다리 채우기
        }


        // 대기 트럭이 없을때까지
        while(!queue.isEmpty()){

            // 다리에 있는 트럭 poll
            temp_weight += queue2.peek();
            queue2.poll();

            // 대기 트럭이 없는 경우
            if(queue.isEmpty()){
                // 마지막 트럭은 건널 때 무조건 다리길이만큼 시간 필요
                answer += bridge_length;
                break;
            } else {
                // 다리 무게가 남아있으면
                if(temp_weight >= queue.peek()){
                    //큐에 삽입
                    temp_weight -= queue.peek();
                    queue2.add(queue.poll());
                } else {
                    queue2.add(0);  // 안되면 0으로 채우기
                }
            }

            answer++;

        }
        
        
        return answer;
    }

    
}