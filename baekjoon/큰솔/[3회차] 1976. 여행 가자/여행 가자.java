import java.io.*;
import java.util.*;

public class Main {

    private static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 집합을 담을 int[] 변수 초기화
        parent = new int[n + 1];
        // 모든 값이 자기 자신을 가리키도록 만든다.
        for(int i = 1; i <= n; i++) parent[i] = i;

        // 그래프의 수만큼 반복
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++) {
                int temp = Integer.parseInt(st.nextToken());

                // 두 노드 간 연결이 되어 있다면 노드를 연결한다. union(x, y) 연산
                if(temp == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));

        for(int i = 1; i < m; i++) {

            int now = Integer.parseInt(st.nextToken());

            // 시작 점이 목표점의 부모에 해당하는지 판별한다.
            if(start != find(now)) {

                // 아니라면 연결점이 없다는 의미이므로 NO를 출력하고 연산 종료
                System.out.println("NO");
                br.close();
                return;
            }
        }

        // 모든 시작 점이 목표점의 부모에 해당한다면 YES 출력
        System.out.println("YES");
        br.close();

    }

    // Find 연산
    private static int find(int x) {

        // x가 부모에 해당한다면 반환
        if (x == parent[x]) return x;

        // 아니라면 재귀 탐색으로 부모를 거슬러 올라간다.
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {

        x = find(x);
        y = find(y);

        if(x != y) {

            // 부모를 합칠 때는 일반적으로 더 작은 값 쪽으로 합친다.
            if(x < y) parent[y] = x;
            else parent[x] = y;
        }
    }
}