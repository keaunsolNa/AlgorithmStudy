import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        long D[][] = new long[N+1][10];
        
        for(int i = 1; i<=9; i++){ 
            D[1][i] = 1;  
        }

        for(int j = 2; j <=N; j++){
            D[j][0] = D[j-1][1];
            D[j][9] = D[j-1][8];

            for(int k = 1; k <=8; k++){
                D[j][k] = (D[j-1][k-1] + D[j-1][k+1]) % mod;
            }
        }

        long sum = 0;
        for(int l = 0; l < 10; l++){
            sum = (sum + D[N][l]) % mod;
        }

        System.out.println(sum);

    }
    
}
