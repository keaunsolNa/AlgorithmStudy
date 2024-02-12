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
        int N = Integer.parseInt(st.nextToken()); //원생 수
        int K = Integer.parseInt(st.nextToken()); //조 개수

        int[] height = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            height[i] = Integer.parseInt(st.nextToken()); //원생 키배열
        }

        Integer[] heightDiff = new Integer[N-1]; //원생 키차이 배열
        for(int j=0; j<N-1; j++){
            heightDiff[j] = height[j+1] - height[j];
        }

        Arrays.sort(heightDiff);// 키차이 내림차순 정렬
        long answer = 0;
        for(int k=0; k< (N-1) - (K-1); k++){
            answer += heightDiff[k];
        }

        System.out.print(answer);

    }
}