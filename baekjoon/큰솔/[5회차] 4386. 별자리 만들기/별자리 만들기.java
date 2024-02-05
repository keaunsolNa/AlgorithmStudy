import java.io.*;
import java.util.*;

public class Main {

    // n개의 별들의 x, y 좌표를 기록하기 위한 클래스
    private static class Point {

        double x;
        double y;
        int idx;

        public Point(double x, double y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    // 노드의 간선 길이를 기록하기 위한 클래스. x, y 좌표와 각 좌표 사이의 거리
    private static class Edge implements Comparable<Edge> {

        int start;
        int end;
        double vector;

        public Edge(int start, int end, double vector) {
            this.start = start;
            this.end = end;
            this.vector = vector;
        }

        @Override
        public int compareTo(Edge o) {

            return this.vector < o.vector ? -1 : 1;
        }

    }
    private static int[] parents;
    public static void main(String[] args) throws IOException {

        /*
            크루스칼 알고리즘 기반 최소 스패닝 트리로 풀이한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        // n개의 별들의 x, y 좌표
        Point[] points = new Point[n];

        // n 개의 별들의 좌표를 Point 배열에 기록한다.
        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), i);

        }

        // PriorityQueue 선언
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Union Find를 위한 parents 변수 선언
        parents = new int[n + 1];

        // 초기 값은 자기 자신
        for(int i = 0; i < n + 1; i++) parents[i] = i;

        // x 좌표와 y 좌표에 대해 각각 거리값을 구해야 하므로 2중 반복문을 수행한다.
        for(int i = 0; i < n - 1; i++)
            for(int j = i + 1; j < n; j++)
                // Priority Queue에 Edge 클래스로 x 좌표, y 좌표, x좌표와 y 좌표 사이의 거리를 기록한다.
                pq.add(new Edge(points[i].idx, points[j].idx, getDist(points[i], points[j])));

        double result = 0;
        int cnt = 0;

        // Priority Queue가 빌 때 까지
        while(!pq.isEmpty()) {

            // 가장 앞에 있는 간선을 꺼낸 뒤
            Edge cur = pq.poll();

            // 해당 간선의 좌표들이 union-find 연산을 통해 연결되었는지 확인한다. 아니라면
            if(find(cur.start) != find(cur.end)) {

                // 두 좌표를 연결한 뒤
                union(cur.start, cur.end);
                // cnt ++ 
                cnt++;
                
                // 최소 스패닝 트리 거리 += 연산
                result += cur.vector;
            }

            if(cnt == n) break;
        }

        System.out.printf("%.2f", result);


    }

    // 두 좌표 간의 거리를 구하기 위한 메서드
    private static double getDist(Point p1, Point p2) {

        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    // Union - Find  Find 연산
    private static int find(int x) {

        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);

    }

    // Union - Find Union 연산
    private static void union(int x, int y) {

        x = find(x);
        y = find(y);

        if(x < y) {

            int tmp = x;
            x = y;
            y = tmp;
        }

        parents[y] = x;
    }
}