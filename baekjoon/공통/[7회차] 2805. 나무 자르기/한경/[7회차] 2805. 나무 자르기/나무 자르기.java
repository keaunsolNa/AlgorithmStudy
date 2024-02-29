import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 입력받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] woods = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N ; i++){
            woods[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(woods); // 나무 정렬
        int min = 0; // 제일 작은 값
        int max = woods[N-1];   // 제일 큰 값

        
        // 더해서 M보다 커질 떄 까지
        while(min < max){
            int mid = (min+max)/2;  // 중간 값 구하기
            long sum = 0;

            for(int i = 0; i < N; i++){
                if(woods[i] - mid > 0){
                    sum += (woods[i] - mid);   // 나무 자른 값 더하기
                }
            }

            // M보다 작으면 더 많이 잘라야함
            if(sum < M){
                max = mid;
            } else {    // M보다 크면 더 적게 잘라야함
                min = mid + 1;
            }

        }
      
        // min = mid + 1이기 때문에 -1 한 값을 출력한다.
        System.out.println(min - 1);
        
    }
}