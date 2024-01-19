import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

        // 변수 입력받기
		int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N+1 ; i++){
            queue.add(i);
        }

        sb.append("<");

        while(!queue.isEmpty()){
            // K번째 전까지 뒤에 다시 붙인다.
            for(int j = 0; j < K - 1; j++){
                queue.add(queue.poll());
            }

            // K번째 값이 가장 앞에 있으므로 삭제
            if(queue.size() == 1){
                sb.append(queue.poll());
            } else {
                sb.append(queue.poll() + ", ");
            }
        }

        sb.append(">");
        
        System.out.println(sb);
        
    }
}
