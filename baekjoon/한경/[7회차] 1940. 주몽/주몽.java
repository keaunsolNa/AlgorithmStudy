import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 M 입력 받기
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] number = new int[N];
        int cnt = 0;
        int j = 0;
        int k = N-1;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);

        while (j<k){
            if(number[j] + number[k] < M){
                j++;
            } else if(number[j] + number[k] > M){
                k--;
            } else {
                cnt++;
                j++;
                k--;
            }
        }


        System.out.println(cnt);
    }
}
