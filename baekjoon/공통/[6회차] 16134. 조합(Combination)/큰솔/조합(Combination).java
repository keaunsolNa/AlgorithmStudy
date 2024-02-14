import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        long ans = 0;
        long a = 1;
        long b = 1;

        // 모듈로 곱셈 역원
        for(int i = 0; i < r; ++i) {
            a *= (n - i);
            b *= (r - i);
            a %= MOD;
            b %= MOD;
        }

        long b2 = 1;
        int exp = MOD - 2;

        // 페르마의 소정리
        while(exp > 0) {

            if(exp % 2 > 0) {
                b2 *= b;
                b2 %= MOD;
            }

            b *= b;
            b %= MOD;
            exp /= 2;

        }

        ans = a * b2;
        ans %= MOD;

        System.out.println(ans);
    }
}