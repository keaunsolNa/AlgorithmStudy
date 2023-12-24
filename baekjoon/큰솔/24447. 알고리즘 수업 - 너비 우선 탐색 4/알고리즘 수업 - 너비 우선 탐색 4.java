import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 그래프
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    // 깊이를 기록할 배열
    private static long[] visited;
    // 방문한 순서를 기록할 배열
    private static long[] seq;
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노드의 정점, 간선, 시작 정점
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        // 방문한 순서를 기록할 배열
        seq = new long[n + 1];
        // 깊이를 기록할 배열
        visited = new long[n + 1];

        // 깊이 배열 초기화
        for(int i = 1; i <= n; i++) visited[i] = -1;

        // 그래프 초기화
        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());

        // 그래프에 값 대입
        for(int i = 0; i < m; i++) {

            // 간선 정보 정점 u와 가중치 v
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 정점 u에 가중치 v를 담는다.
            list.get(u).add(v);
            // 정점 v에 가중치 u를 담는다. (양방향 그래프)
            list.get(v).add(u);
        }

        // 인접 정점들을 오름차순 정렬
        for(int i = 1; i <= n; i++) Collections.sort(list.get(i));

        // bfs 시행
        bfs(r);

        // 정답을 담을 변수
        long ans = 0;

        // 방문한 순서 * 깊이로 모든 노드에 대한 di * ti를 구한다.
        for(int i = 1; i <= n; i++) ans += seq[i] * visited[i];

        // 정답 출력
        System.out.println(ans);
    }

    // BFS, 시작 정점 r과 간선 정보를 받는다.
    private static void bfs(int r) {

        // 방문을 기록할 queue 선언
        Queue<Integer> queue = new LinkedList<>();
        // 큐에 시작 정점 r의 정보를 담는다.
        queue.add(r);
        // 시작 정점에 대해 방문했다고 표시
        visited[r] = 0;

        // 현재 위치를 표시할 변수
        int seqCnt = 1;
        // 방문 순서에 가중치 적용
        seq[r] = seqCnt++;

        while(!queue.isEmpty()) {

            // 큐의 맨 앞쪽 요소 삭제
            int cur = queue.poll();

            // 정점 u의 인접 정점 집합. (정점 번호 오름차순 방문)
            for(int num : list.get(cur)) {

                // 아직 방문하지 않았다면
                if(visited[num] == -1) {

                    // 방문했다고 표시한 뒤
                    queue.add(num);
                    // 노드의 깊이는 전 노드의 깊이 + 1
                    visited[num] = visited[cur] + 1;
                    // 방문 순서에 가중치를 적용한다.
                    seq[num] = seqCnt++;
                }
            }
        }
    }
}