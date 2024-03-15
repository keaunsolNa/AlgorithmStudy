import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());				// 물품의 수
		int K = Integer.parseInt(st.nextToken());				// 물품의 최대 무게
		int[][] back = new int[N + 1][2];						// 가방에 담을 물건 2차원 배열
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			back[i][0] = Integer.parseInt(st.nextToken());		// 물품의 무게
			back[i][1] = Integer.parseInt(st.nextToken());		// 물품의 가치
		}
		
		int[] dp = new int[K + 1];								// 최대 가치 누적 dp 배열
        int max = 0;											// 최대 값을 찾기 위한 변수 선언
		
		// 물품의 수 0개 부터 N개까지 고려
		for(int n = 0; n < N; n++) {
			
			// 물품의 무게 최대치부터 0개까지 고려
			for(int k = K; k >= back[n][0]; k--) {
				
				// 무게 k(현재 탐색 행)까지의 최적해와 k - 현재 행 중 최대값을 dp 배열에 넣기
				dp[k] = Math.max(dp[k], dp[k - back[n][0]] + back[n][1]);
				
				// 탐색 값 중 최고값 = max
				if(dp[k] > max) max = dp[k];
			}
		}
		
		System.out.println(max);
   }
}