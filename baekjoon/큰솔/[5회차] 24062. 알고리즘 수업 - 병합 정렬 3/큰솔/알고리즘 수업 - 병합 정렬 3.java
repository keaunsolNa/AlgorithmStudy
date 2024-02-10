import java.io.*;
import java.util.*;

public class Main {

    // 배열의 길이, 정답이 될 플래그, 배열 동등 여부를 탐색 할 인덱스
    private static int n, count = 0, now = 0;
    // 원 배열, 비교 배열, 정렬 중 사용할 임시 배열
    private static int[] arr, target, sorted;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        // 원 배열 입력
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 비교 배열 입력
        st = new StringTokenizer(br.readLine());
        target = new int[n];
        for(int i = 0; i < n; i++) target[i] = Integer.parseInt(st.nextToken());

        // 정렬 배열의 초기값은 원 배열의 clone
        sorted = arr.clone();
        // 입력 초기값부터 동등할 때를 확인하기 위한 메서드
        check();
        // 병합 정렬 시행
        merge(0, n - 1);
        // 결과 값 출력
        System.out.println(count);
    }

    // merge 재귀 메서드
    public static void merge(int left, int right) {

        /*

            좌측 이 우측보다 작다면 탐색 진행
            분할 정복 메커니즘으로 시행한다.
            pivot 값은 mid 값

         */

        // left < right면 반복 시행
        if(left < right) {

            // 중간 값
            int mid = (left + right) / 2;
            // 재귀 탐색 좌측 ~ 중간 값
            merge(left, mid);
            // 재귀 탐색 중간 ~ 마지막 값
            merge(mid + 1, right);
            // 변경된 값으로 배열 재정렬
            merge(left, mid, right);

        }

    }

    // 배열 재정렬을 위한 메서드
    public static void merge(int left, int mid, int right) {

        // 좌측 포인터를 기록할 변수
        int l = left;
        // 우측 포인터를 기록할 변수
        int r = mid + 1;
        // sort 배열의 인덱스
        int index = 0;

        // 좌측 포인터가 매개변수 좌측 위치보다 작고 우측 포인터가 매개변수 우측 위치보다 작을 때 반복
        while (l <= mid && r <= right) {

            // 우측의 요소가 좌측의 요소보다 크다면 정렬 배열 값의 좌측 포인터 위치를
            if(arr[l] <= arr[r]) sorted[index++] = arr[l++];
                // 아니라면 우측 포인터 위치를 넣는다.
            else sorted[index++] = arr[r++];

        }

        // l <= mid 일 떄 반복 시행
        while (l <= mid) {
            // 정렬 배열에 원 배열의 좌측 값
            sorted[index++] = arr[l++];
        }

        // r < right일 때 반복 시행
        while (r <= right) {
            // 정렬 배열에 원 배열의 우측 값
            sorted[index++] = arr[r++];
        }

        // l, index 초기화
        l = left;
        index = 0;

        // l < right 라면 정렬이 필요하다는 의미가 된다.
        while (l <= right) {

            // 원 배열의 값을 정렬 배열의 값으로 변경한다.
            arr[l++] = sorted[index++];

            /*
                배열의 변경이 있을 때,
                배열의 모든 길이를 비교 대상 배열과 비교 하는 것은 시간 복잡도를 통과하지 못 한다.  [ O(n2) ]
                변경 후 탐색이 있을 때, 이전의 탐색 범위는 지나가고 남은 배열에 대해서만 탐색한다.
             */

            // 만약 배열이 이미 대상 배열과 동일한 적이 있었다면 변경할 필요 없다.
            if(count < 1) {

                while(true) {

                    // 원 배열과 비교 대상 배열이 같다면
                    if(arr[now] == target[now]) {

                        // 배열의 끝까지 탐색 했다면
                        if (now == arr.length - 1) {

                            // 1을 출력하고 프로그램 종료
                            System.out.println(1);
                            System.exit(0);
                        }

                        // 아니라면 탐색 위치를 1칸 우측으로 늘린다.
                        now++;
                    } else break;
                }
            }
        }

    }

    // 초기에는 배열의 시작부터 끝까지 모두 탐색
    private static void check() {
        for(int i = 0; i < n; i++) {

            if(arr[i] != target[i]) return;
        }

        // 이미 배열이 동일하다면 탐색할 필요 없으므로 종료
        System.out.println(1);
        System.exit(0);
    }
}