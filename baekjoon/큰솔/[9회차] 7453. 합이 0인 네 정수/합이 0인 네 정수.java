import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        int[][] preSum = new int[2][n * n];
        int idx = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {

                preSum[0][idx] = arr[i][0] + arr[j][1];
                preSum[1][idx++] = arr[i][2] + arr[j][3];
            }

        Arrays.sort(preSum[0]);
        Arrays.sort(preSum[1]);

        int start = 0;
        int second = preSum[0].length - 1;
        int end = n * n;
        long answer = 0;

        while (start < end && 0 <= second) {

            int sum = preSum[0][start] + preSum[1][second];
            int firstCnt = 1;
            int secondCnt = 1;

            if (sum == 0) {

                while (start <= end - 2 && preSum[0][start] == preSum[0][start + 1]) {
                    firstCnt++;
                    start++;
                }

                while (0 < second && preSum[1][second] == preSum[1][second - 1]) {
                    secondCnt++;
                    second--;
                }

                answer += (long) firstCnt * secondCnt;
            }

            if (sum < 0) start++;
            else second--;
        }

        System.out.println(answer);

    }

}
