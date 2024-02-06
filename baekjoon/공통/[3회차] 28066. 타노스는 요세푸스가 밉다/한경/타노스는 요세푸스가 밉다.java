import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 변수 입력받기
		int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N+1 ; i++){
            deque.add(i);
        }

        // 덱에 남은 element가 K보다 큰 경우
        while(deque.size() > K){
            // 첫번째 값을 뒤로 보낸다.
            deque.addLast(deque.pollFirst());

            if(K>1){
                // K까지 삭제
                for(int j = 0; j < K-1; j++){
                    if(!deque.isEmpty()){   
                        deque.removeFirst();
                    }
                }
            }
        }

        if(deque.size() > 1){    
            for(int k = 0 ; k < deque.size() - 1; k++){
                deque.removeLast();
            }
        }
        
        System.out.println(deque.getFirst());
        
        
    }
    
}