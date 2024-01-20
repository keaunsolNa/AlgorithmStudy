import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Town implements Comparable<Town> {
        int end;
        int weight;

        Town(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Town arg0) {
            return weight - arg0.weight;
        }
    }

    private static final int INF = 987654321;
    private static ArrayList<ArrayList<Town>> arrList, reverse_arrList;
    private static int N, X;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 문제의 입력을 그대로 받은 배열
        arrList = new ArrayList<>();
        // 문제의 입력을 반대로 받은 배열
        reverse_arrList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {

            arrList.add(new ArrayList<>());
            reverse_arrList.add(new ArrayList<>());

        }

        // arrList와 reverse_arrList를 각각 단방향 인접리스트로 구현
        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arrList.get(start).add(new Town(end, weight));
            reverse_arrList.get(end).add(new Town(start, weight));
        }

        // X에서 시작점들 사이의 최단거리
        int[] dist1 = dijkstra(arrList);
        // 시작점들에서 X 사이의 최단거리
        int[] dist2 = dijkstra(reverse_arrList);

        int ans = 0;

        for (int i = 1; i <= N; i++)
            ans = Math.max(ans, dist1[i] + dist2[i]);

        System.out.println(ans);
    }

    // 다익스트라 알고리즘
    public static int[] dijkstra(ArrayList<ArrayList<Town>> a) {

        // 우선순위큐
        PriorityQueue<Town> pq = new PriorityQueue<>();
        pq.offer(new Town(X, 0));

        // 초기 값 셋팅
        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;


        while (!pq.isEmpty()) {
            Town curTown = pq.poll();
            int cur = curTown.end;

            if (!check[cur]) {
                check[cur] = true;

                // 전체 순회하며 가장 깊은 값으로 갱신
                for (Town town : a.get(cur)) {
                    if (!check[town.end] && dist[town.end] > dist[cur] + town.weight) {
                        dist[town.end] = dist[cur] + town.weight;
                        pq.add(new Town(town.end, dist[town.end]));
                    }
                }
            }
        }

        return dist;

    }
}