import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // Segment Tree
    public static class CandyBox {
        int size;
        int[] candy, tree;

        public CandyBox() {

            // 사탕 맛의 종류 (1 ~ 1000000)
            int len = 1 << 20;
            // 사탕을 담을 배열
            this.candy = new int[1000001];
            // 세그먼트 트리의 길이 (맛의 종류 * 2)
            this.tree = new int[len * 2];
            // 사탕의 종류
            this.size = 1000000;
        }

        // 사탕을 집어 넣는 메서드
        public void putCandy(int taste, int num) {

            // 세그먼트 트리 업데이트 후
            update(1, size, 1, taste, num);

            // 캔디의 양 조절
            candy[taste] += num;
        }

        // 사탕을 꺼내는 메서드
        public int getCandy(int rank) {

            // 세그먼트 트리 업데이트 후
            int result = update(1, size, 1, rank);

            // 캔디의 양 조절
            candy[result]--;

            // 반환값은 차감된 트리의 인덱스(맛의 번호)
            return result;
        }

        // 사탕을 집어 넣은 뒤 세그먼트 트리 업데이트
        public void update(int start, int end, int node, int taste, int num) {

            // 투 포인터 탐색 예외처리
            if(taste < start || end < taste) return;

            // 세그먼트 트리 업데이트
            tree[node] += num;

            // 예외처리
            if(start == end) return;

            // 투 포인터 탐색을 위한 중앙 값 지정
            int mid = (start + end) >> 1;

            // 재귀 탐색으로 투 포인터 탐색, (1 ~ mid)
            update(start, mid, node * 2, taste, num);
            // 재귀 탐색으로 투 포인터 탐색, (mid ~ end)
            update(mid + 1, end, node * 2 + 1, taste, num);

        }

        // 사탕을 꺼낸 후 세그먼트 트리 업데이트
        public int update(int start, int end, int node, int rank) {

            // 사탕의 갯수 차감 후
            tree[node]--;

            // 투 포인터 탐색을 위한 탈출문
            if(start == end) return start;

            // 투 포인터 탐색을 위한 중앙 값
            int mid = (start + end) >> 1;

            // 투 포인터 탐색, (start ~ mid)
            if(tree[node * 2] >= rank) return update(start, mid, node * 2, rank);

                // 투 포인터 탐색, (mid ~ end)
            else return update(mid + 1, end, node * 2 + 1, rank - tree[node * 2]);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        CandyBox candyBox = new CandyBox();

        int n = Integer.parseInt(br.readLine());

        while(n --> 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 입력 값에 따른 get, put 메서드 실행
            if(Integer.parseInt(st.nextToken()) == 1) sb.append(candyBox.getCandy(Integer.parseInt(st.nextToken()))).append('\n');
            else candyBox.putCandy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        }
        System.out.println(sb);
        br.close();
    }
}