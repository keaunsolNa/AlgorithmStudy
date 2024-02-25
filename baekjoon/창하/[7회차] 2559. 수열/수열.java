import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //전체 날짜의 수
        int N = Integer.parseInt(st.nextToken());
        //연속적인 날짜의 수
        int K = Integer.parseInt(st.nextToken());

        //온도 배열
        int [] ondoArr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            ondoArr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = K;
        int maxSum = Integer.MIN_VALUE;
        while(e <= N){
            int sum = 0;
            for(int i = s; i < e; i++){
                sum += ondoArr[i];
            }
            maxSum = Math.max(maxSum,sum);
            s++;
            e++;
        }
        System.out.print(maxSum);
    }
}