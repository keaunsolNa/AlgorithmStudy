import java.io.*;
import java.util.*;

public class Main {

    // 그래프 Class
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

    // 정점의 부모를 기록하기 위한 static 변수
    private static int[] parents;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 행성에 대한 초기 데이터를 입력받아 List에 저장한다.
        List<int[]> data = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            data.add(new int[] {i, x, y, z});
        }

        // 우선순위 큐 + 유니온 파인드인 크루스칼 알고리즘으로 최소 신장 트리를 구한다.
        PriorityQueue<Point> q = new PriorityQueue<>();

        // x, y, z 좌표에 대한 최소값을 각각 구해야 하므로 for문을 3번 수행한다.
        for(int idx = 1; idx <= 3; idx++) {

            int vector = idx;
            // 각 x, y, z 좌표 순으로 오름차순 정렬한 뒤 인접한 정점끼리의 거리를 구한다.
            data.sort(Comparator.comparingInt(o -> o[vector]));

            // 각 x, y, z 좌표에 대해 입력받은 노드의 숫자만큼 반복문을 수행
            for(int i = 1; i < n; i++) {

                int[] p1 = data.get(i - 1);
                int[] p2 = data.get(i);
                // 좌표 간의 거리 계산
                int dis = Math.abs(p1[idx] - p2[idx]);

                // p1과 p2에 대한 간선 데이터를 큐에 저장한다.
                q.add(new Point(p1[0], p2[0], dis));

            }
        }

        // 각 노드간 연결을 확인하기 위한 parents 변수
        parents = new int[n];
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

    // 유니온 파인드 Find 알고리즘
    private static int find(int x) {

        // x가 부모에 해당한다면 반환
        if(parents[x] == x) return x;

        // 아니라면 재귀 탐색으로 부모 검색
        return parents[x] = find(parents[x]);
    }

    // 유니온 파인트 Union 연산
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