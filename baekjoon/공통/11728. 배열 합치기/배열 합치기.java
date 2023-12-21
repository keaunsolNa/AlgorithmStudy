import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n과 m 변수 입력 받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // n + m 크기의 배열 선언
        int[] answer = new int[n + m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            answer[i] = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for(int i = n; i < n + m; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        // 오름차순 정렬
        Arrays.sort(answer);

        // 출력 속도를 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // append()
        for (int i : answer)
            sb.append(i).append(" ");

        // 마지막 띄어쓰기 제거
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}