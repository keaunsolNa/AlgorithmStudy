import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      Map<String, PriorityQueue<Integer>> gMap = new HashMap<>();    // 고릴라, 정보 큐

      int Q = Integer.parseInt(st.nextToken());      // 코드의 수
      long sum = 0;      // 구매 정보의 총 합
    
      for(int i = 0; i < Q; i++){
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int incase = Integer.parseInt(st2.nextToken());    // 판매 구분
        String name = st2.nextToken();                   // 고릴라 이름
        int K = Integer.parseInt(st2.nextToken());       // 고릴라 정보 혹은 구매 정보 갯수
      
        // incase = 1인경우 offer
        if(incase == 1){
            for(int j = 0; j < K; j++){
                // 아는 고릴라인지 확인
                if(!gMap.containsKey(name)){
                        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐 사용 
                        queue.offer(Integer.parseInt(st2.nextToken()));  // 큐에 넣기
                        gMap.put(name, queue);  // 맵에 저장
                    
                } else {
                    gMap.get(name).add(Integer.parseInt(st2.nextToken()));  // 큐에 넣기
                }

            }
            
        } else {
            // 아는 고릴라면
            if(gMap.containsKey(name)){
                // 큐가 남아있고 K번만큼 산다
                while(!gMap.get(name).isEmpty() && K > 0){
                    sum +=gMap.get(name).poll();
                    K--;
                }
            }
        }

         
    }
      System.out.println(sum);
    }
}
