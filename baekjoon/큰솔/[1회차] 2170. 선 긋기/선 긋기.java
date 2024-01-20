import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 선을 그은 횟수
        int n = Integer.parseInt(br.readLine());
        // 입력 값을 받을 포인터 변수 배열
        int[][] point = new int[n][2];

        // 최초 입력
        for(int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());

        }

        /*
             선분은 정렬되어 있다는 언급이 없으므로 정렬한다.
             x축이 겹치면 y축으로,
             겹치지 않으면 x축 기준으로 오름차순 정렬
         */
        Arrays.sort(point, (o1, o2) -> {
            if(o1[0] == o2[0])  return o1[1] - o2[1];
            else  return o1[0] - o2[0];
        });

        // 최초의 선분 지점
        int start = point[0][0];
        int end = point[0][1];

        // 정답이 될 최초의 길이는 y - x
        int len = end - start;

        // 배열의 길이만큼 순회한다.
        for(int i = 1; i < n; i++) {

            // Case 3. 선분이 완전히 겹치는 경우
            if(start <= point[i][0] && point[i][1] <= end) continue;

            // Case 2. 선분이 일부만 겹치는 경우. 현재 선의 y좌표 - 이전 선의 y좌표
            else if(point[i][0] < end) len += point[i][1] - end;

            // Case 1. 선분이 완전히 겹치지 않는 경우. 현재 선의 y 좌표에서 x좌표의 값을 뺀 값을 더한다. (사이의 텀)
            else len += point[i][1] - point[i][0];

            // 매 순회마다 x축과 y축 갱신
            start = point[i][0];
            end = point[i][1];
        }

        // 정답 출력
        System.out.println(len);
    }
}