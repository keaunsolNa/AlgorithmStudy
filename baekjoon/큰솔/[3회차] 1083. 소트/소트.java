import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
            버블 소트에 대한 그리디성 구현 문제
            문제 이해에 시간이 더 걸렸다.
            Sort 시 Swap 이 아닌 인덱스를 앞으로 가져온다는 개념으로 접근해야 한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) list.add(Integer.parseInt(st.nextToken()));

        int s = Integer.parseInt(br.readLine());

        // 순회를 시작할 원소
        for(int i = 0; i < n; i++) {

            if(s == 0) break;
            // 가장 큰 값
            int max = 0;
            // 해당 인덱스
            int idx = -1;
            // 비교 대상 원소
            for(int j = i + 1; j < n; j++) {

                // 더 큰 원소가 있으며, s 보다 두 원소 간의 거리가 크거나 같으며, 해당 원소가 이전 최댓값보다 클 떄
                if(list.get(i) < list.get(j) && s >= j - i && list.get(j) > max) {

                    // 최댓값을 갱신하며
                    max = list.get(j);
                    // 인덱스를 갱신한다.
                    idx = j;
                }

            }

            // 비교가 일어났다면
            if(idx != -1) {

                // 리스트에서 비교 대상을 제거한 뒤
                list.remove(idx);
                // 인덱스의 순회 대상 위치에 비교 대상 삽입
                list.add(i, max);
                // s 값 갱신
                s -= idx - i;
            }
        }

        // 출력
        for(int i : list) System.out.print(i + " ");

    }

}