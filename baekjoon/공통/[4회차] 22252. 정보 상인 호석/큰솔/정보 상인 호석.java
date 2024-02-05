import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 쿼리 갯수
        int q = Integer.parseInt(br.readLine());
        // <String, PriorityQueue<Integer> 타입의 HashMap 선언
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        // long 타입 answer
        long answer = 0;

        while(q --> 0) {

            st = new StringTokenizer(br.readLine());
            // 쿼리의 종류
            int number = Integer.parseInt(st.nextToken());

            // 정보 고릴라 이름
            String name = st.nextToken();
            // k(b)
            int count = Integer.parseInt(st.nextToken());

            if(number == 1) {

                // count의 갯수만큼 반복
                for(int i = 0; i < count; i++) {

                    // 맵에 해당하는 name이 key로 있다면 add
                    if(map.containsKey(name)) map.get(name).add(Integer.parseInt(st.nextToken()));

                    // 아니라면
                    else {

                        // PriorityQueue<Integer> 생성 (역순 내림차순 정렬)
                        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
                        // PriorityQueue에 정보의 가치를 담은 뒤
                        pq.add(Integer.parseInt(st.nextToken()));

                        Map에 put
                        map.put(name, pq);

                    }
                }

            }

            // 쿼리가 2라면
            else {

                // map에 name이 있을 경우에만 시행
                if(map.containsKey(name)) {

                    // 맵에서 해당 이름의 PriorityQueue가 비었거나 count가 0 미만이 되면 종료
                    while(!map.get(name).isEmpty() && count > 0) {

                        // 정답에 맵에서 해당하는 이름의 가장 큰 값(가치)를 꺼낸 뒤 더한다.
                        answer += map.get(name).poll();
                        count--;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}