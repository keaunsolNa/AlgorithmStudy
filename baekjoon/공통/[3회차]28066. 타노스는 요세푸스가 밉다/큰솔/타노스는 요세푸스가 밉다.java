import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 덱 선언
        Deque<Integer> deq = new LinkedList<>();
        // 1부터 n까지 deque에 삽입
        for(int i = 1; i <= n; i++) deq.add(i);

        // 덱의 사이즈가 k보다 작을 때까지
        while(k <= deq.size()) {

            // 덱의 마지막에 덱의 첫 번째 요소 삽입
            deq.addLast(deq.poll());

            // 1부터 k - 1까지 덱의 앞 요소 제거.
            for(int i = 0; i < k - 1; i++) deq.poll();
        }

        // 가장 앞 요소 출력
        System.out.println(deq.poll());
    }
}


