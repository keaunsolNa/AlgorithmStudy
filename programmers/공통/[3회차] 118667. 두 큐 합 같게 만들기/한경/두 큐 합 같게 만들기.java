package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ps118667 {

	// 큐 합 구하기
	public long getsum(int[] q) {
		long sum = 0;
		for (int i = 0; i < q.length; i++) {
			sum += (long) q[i];
		}
		return sum;
	}

	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		long sum1 = getsum(queue1);
		long sum2 = getsum(queue2);

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		// 입력받은 큐 넣기
		for (int i = 0; i < queue1.length; i++) {
			q1.add(queue1[i]);
			q2.add(queue2[i]);
		}

		// 두 큐의 합이 다르면
		while (sum1 != sum2) 
			// 최대 길이 : 다 옮겨서 넣었는데도 합이 다름
			// --> 수정 : 연산횟수(answer)가 2개의 배열이 있을 때 최대 조합(배열1의 길이 + 배열2의 길이) * 2 이상이면 합이 같을 수 없음
			// 또는
			// --> q1의 원소가 전부 q2로 넘어갔을 때 = queue1.length
			// --> q2의 원소를 전부 q1으로 넘길 때 = queue1.length * 2
			// 따라서 queue1.length * 3 도 가능
			if (answer > (queue1.length + queue2.length) * 2)
				return -1;

			int val = 0;

			if (sum1 < sum2) {
				val = q2.poll();
				q1.add(val);
				sum1 += (long) val;
				sum2 -= (long) val;
			}

			else if (sum1 > sum2) {
				val = q1.poll();
				q2.add(val);
				sum1 -= (long) val;
				sum2 += (long) val;
			}

			else {
				return answer;
			}

			answer++;
		}
		return answer;
	
	}
}
