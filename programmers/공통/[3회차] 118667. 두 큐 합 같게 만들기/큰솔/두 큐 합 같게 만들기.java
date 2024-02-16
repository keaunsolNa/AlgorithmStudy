import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {

        // queue1의 누적합을 구할 변수
        long oneSum = 0;
        // queue2의 누적합을 구할 변수
        long twoSum = 0;
        // 정답인 최소 횟수를 구할 변수
        int answer = 0;
        // Queue1, 2
        Queue<Integer> queueOne = new LinkedList<>();
        Queue<Integer> queueTwo = new LinkedList<>();

        // Queue에 배열의 원소를 더하며 누적합도 같이 구한다.
        for (int i : queue1) {
            oneSum += i;
            queueOne.add(i);
        }

        // Queue에 배열의 원소를 더하며 누적합도 같이 구한다.
        for (int i : queue2) {
            twoSum += i;
            queueTwo.add(i);
        }

        // 각 Queue 원소들의 누적합이 다르다면
        while(oneSum != twoSum) {

            // 연산 횟수 증가
            answer++;

            // Queue1의 누적합이 더 크다면
            if(oneSum > twoSum) {

                // Queue1의 원소를 빼낸 후
                int value = queueOne.poll();

                // Queue1의 누적합에서는 -= 원소
                oneSum -= value;
                // Queue2의 누적합에서는 += 원소
                twoSum += value;

                // Queue2에 add 연산
                queueTwo.add(value);

            // Queue2의 누적합이 클 경우는 위 연산의 반대로 수행
            } else {

                int value = queueTwo.poll();
                oneSum += value;
                twoSum -= value;
                queueOne.add(value);

            }

            // 만약 연산 횟수가 배열 2개의 길이 * 2보다 크다면
            // 모든 교환 가능한 방법을 수행했다는 의미이므로 -1을 return 한다.
            // => 어떤 방법으로도 각 큐의 원소 합을 같게 할 수 없음.
            if(answer > (queue1.length + queue2.length) * 2) return -1;

        }

        // 연산 횟수 반환
        return answer;
    }
}