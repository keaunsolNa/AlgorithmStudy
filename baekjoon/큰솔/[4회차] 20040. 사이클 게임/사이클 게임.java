import java.io.*;
import java.util.*;

public class Main {

    private static int[] parent;
    public static void main(String[] args) throws IOException {

        /*
            union-find 알고리즘을 이용한다.
            간선의 정점 a, b가 주어질 때 union 연산을 수행,
            x == y 라면 사이클이 완성되었으므로 출력 후 System.out
            아니라면 연결된 사이클이 없으므로 0을 출력한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 모든 값이 자기 자신을 가리키도록
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        // 간선의 수만큼
        for(int i = 1; i <= m; i++) {

            st = new StringTokenizer(br.readLine());

            // 두 점을 입력 받는다.
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 합집합 연산을 수행한 후 결과값이 거짓이라면
            if(!union(start, end)) {

                // 출력 후 종료
                System.out.println(i);
                System.exit(0);
            }
        }

        System.out.println(0);

    }

    private static int find(int x) {

        // x가 부모에 해당한다면 반환
        if (x == parent[x]) return x;

        // 아니라면 재귀 탐색으로 부모를 거슬러 올라간다.
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int x, int y) {

        x = find(x);
        y = find(y);

        // x와 y의 부모를 찾은 뒤 x와 y의 부모가 같다면 간선이 연결되었다는 의미가 된다.
        if(x == y) return false;

        // 간선이 연결되지 않았을 경우에만 간선을 잇는다.
        parent[y] = x;
        return true;
    }

}