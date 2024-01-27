import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,PriorityQueue<Integer>> map = new HashMap<>(); //고릴라와 정보들을 담을 Map 객체
        int count = Integer.parseInt(br.readLine()); // 입력된 코드수
        long totalPrice = 0;

        while(count-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int infoInfo = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int infoCount = Integer.parseInt(st.nextToken());


            //만약 정보가 1이라면
            if (infoInfo == 1) {
                while (infoCount-- > 0) {
                    //map에 해당 이름이 있다면 해당 이름의 우선순위큐에 infoLevel 추가
                    if (map.containsKey(name)) {
                        map.get(name).offer(Integer.parseInt(st.nextToken()));
                    } else {
                        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                        pq.offer(Integer.parseInt(st.nextToken()));
                        map.put(name, pq);
                        //map에 해당 이름이 없다면 map에 해당 이름과 우선순위큐 추가
                    }
                }
            } else if (infoInfo == 2 && (map.containsKey(name))) {
                while(infoCount-->0 && !map.get(name).isEmpty()){
                    totalPrice += map.get(name).poll();
                }
            }
        }
        System.out.print(totalPrice);
    }
}
