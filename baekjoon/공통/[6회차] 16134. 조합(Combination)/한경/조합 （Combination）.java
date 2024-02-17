import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Integer[][] dp;
    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N과 R 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(binomial(N, K));

    }

    static Integer binomial(int n, int r) {

        dp = new Integer[n+1][r+1];

        for(int i = 0; i<=n; i++) {
            // 0 ~ i 또는 0 ~ k 까지 중 작은 것을 택함 불필요한 것을 구하지 않기 위해서 
            for(int j = 0; j<=Math.min(i, r); j++) {
                if(j == 0 || j == i) 
                    dp[i][j] = 1;
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%mod;
            }
        }
        return dp[n][r];
    }

}
