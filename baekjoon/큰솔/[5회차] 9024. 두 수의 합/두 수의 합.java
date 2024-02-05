import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t --> 0) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 수열을 담을 배열
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            // 오름차순 정렬
            Arrays.sort(arr);

            // 투 포인터를 위한 left, right 변수
            int start = 0, end = n - 1;

            // 최솟값을 지정한다.
            int min = Integer.MAX_VALUE;

            // 정답 변수
            int ans = 0;

            // 투 포인터 종료 조건
            while(start < end) {

                // 수열의 두 정수 조합을 기준으로 함으로 sum 변수를 투 포인터의 시작과 끝의 합으로 정한다.
                int sum = arr[start] + arr[end];

                // 수열의 두 정수 조합과 k 사이의 차이를 기록하기 위한 변수
                int gap = Math.abs(sum - k);

                // 최솟값이 gap 보다 크거나 같다면
                if(min >= gap) {

                    // min이 gap 초과라면 이전 누적치를 초기화 한다.
                    if(min > gap) ans = 0;
                    // 최솟값 갱신
                    min = gap;
                    // ans++
                    ans++;
                }

                // 수열의 합이 k 보다 크거나 같다면 오른쪽을 줄인다.
                if(sum >= k) end--;
                // 아니라면 왼쪽을 높인다.
                else start++;
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}