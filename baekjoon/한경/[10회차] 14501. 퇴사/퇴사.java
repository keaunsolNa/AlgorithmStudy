import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N+2]; // 결과
        int[] T = new int[N+1]; // 걸리는 일 수 
        int[] P = new int[N+1]; // 상담비
        
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int j = N; j > 0; j--){
            if(j+T[j] > N+1){   // 일이 끝나는게 퇴사일자 이후면
                D[j] = D[j+1];  // j+1일부터 퇴사일까지 벌 수 있는 최대 수입
            } else {
                D[j] = Math.max(D[j+1], P[j]+D[j+T[j]]);    // j번째 상담비 + j번째 상담 후 다음날부터 퇴사일까지 수입
            }
        }

        System.out.println(D[1]);

    }
    
}
