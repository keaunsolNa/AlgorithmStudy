import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        StringTokenizer st;
        // 최댓값과 최솟값에 대한 우선순위큐를 두 개 만들 경우,
        // remove() 연산을 위한 O(N) 시간복잡도가 필요하다.
        // 따라서 TreeMap을 활용하여 구현한다.
        TreeMap<Integer, Integer> que = new TreeMap<>();

        for(String str : operations) {

            st = new StringTokenizer(str);
            char oper = st.nextToken().charAt(0);
            int number = Integer.parseInt(st.nextToken());

            // I일 경우 이중우선순위 큐에 getOrDefault 연산으로 값을 넣는다.
            if(oper == 'I')
                que.put(number, que.getOrDefault(number, 0) + 1);

            else {

                // 큐가 비어있을 경우 연산을 무시한다.
                if(que.isEmpty()) continue;

                // 아니라면 number가 1일 경우에는 마지막 값(최댓값)을, 아닐 경우 첫 번째 값(최솟값)을 변수에 할당한다.
                int target = number == 1 ? que.lastKey() : que.firstKey();
                // 이후 각가의 Key에 대한 Value를 -1 한다.
                // 이 때 최솟값, 최댓값이 하나라면 remove한다.
                if(que.put(target, que.get(target) - 1) == 1) que.remove(target);

            }

        }

        // 큐가 비어있다면 0, 0 배열 반환
        if(que.isEmpty()) return new int[] {0, 0};
        // 아니라면 최댓값과 최솟값 반환
        else return new int[] { que.lastKey(), que.firstKey() };

    }
}