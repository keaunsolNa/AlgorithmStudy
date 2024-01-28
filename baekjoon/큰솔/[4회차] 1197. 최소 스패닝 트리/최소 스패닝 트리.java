import java.io.*;
import java.util.*;
public class Main {
    // 가중치별로 정렬하기 위한 Class
    private static class Point implements Comparable<Point> {

        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Point point) {
            return this.z - point.z;
        }
    }

    private static int[] parents;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Node & Edge
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 간선을 가중치 별로 정렬하기 위한 PriorityQueue
        PriorityQueue<Point> q = new PriorityQueue<>();

        // 정점의 수대로 for문 수행
        for(int i = 0; i < e; i++) {

            st = new StringTokenizer(br.readLine());

            // x, y와 가중치 z
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            q.add(new Point(x, y, z));
        }

        parents = new int[n + 1];
        // 최소값은 자기 자신을 가리키도록 한다.
        for(int i = 0; i < n; i++) parents[i] = i;

        // 최소 비용 변수
        int min = 0;
        // 크루스칼 알고리즘 시작
        while(!q.isEmpty()) {

            // 각 좌표를 꺼낸 뒤
            Point point = q.poll();

            // 유니온 파인드로 각 좌표의 부모를 구하는 방식(재귀)으로 최소 비용을 구한다.
            int rx = find(point.x);
            int ry = find(point.y);

            // 루트 노드가 일치하지 않는다면 비용을 더한다.
            if(rx != ry) {

                // 최소 비용에 비용을 더한 뒤
                min += point.z;
                // 해당 노드를 연결한다.
                union(point.x, point.y);
            }
        }

        // 최소 비용 출력
        System.out.println(min);

    }

    private static int find(int x) {

        // x가 부모에 해당한다면 반환
        if (x == parents[x]) return x;

        // 아니라면 재귀 탐색으로 부모를 거슬러 올라간다.
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {

        // 각 정점에 대한 부모를 구한다.
        x = find(x);
        y = find(y);

        // x < y라면 계산의 편의를 위해 x와 y를 변경한다.
        if(x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        parents[y] = x;
    }

}