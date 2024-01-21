import java.io.*;
import java.util.*;

public class Main {

    // 세그먼트 트리
    private static int[] tree;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];

        // 수열
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 세그먼트 트리의 크기는 수열의 크기 * 4로 지정한다.
        tree = new int[n * 4];
        // 인트 범위 초과로 long 타입 합계 변수
        long res = 0;

        // 역순으로 계산.
        for(int i = n; i > 0; i--) {

            // 수열의 요소
            int x = arr[i];

            //  트리의 구간합을 구해 더한다.
            res += query(1, n, 1, 1, x - 1);
            // 세그먼트 트리 업데이트
            update(1, n, 1, x);
        }

        // 출력
        System.out.println(res);

    }

    // 세그먼트 트리 업데이트 메서드
    private static int update(int start, int end, int node, int idx) {

        // 수열의 범위 지정 및 투포인터 탐색 범위
        if(end < idx || idx < start) return tree[node];
        if(start == end) return tree[node] += 1 ;

        // 투 포인터 탐색을 위한 mid 값
        int mid = (start + end) / 2;

        // 트리의 노드 값은 투 포인터 방식으로 재귀 구현
        return tree[node] = update(start, mid, node * 2, idx) +
                update(mid + 1, end, node * 2 + 1, idx);
    }

    // 구간 합 탐색 메서드
    private static int query(int start, int end, int node, int l, int r) {

        // 탐색 범위 지정
        if(r < start || end < l) return 0;
        if(l <= start && end <= r) return tree[node];

        // 투 포인터 탐색
        int mid = (start + end) / 2;
        return query(start, mid, node * 2, l, r) +
                query(mid + 1, end, node * 2 + 1, l, r);

    }
}