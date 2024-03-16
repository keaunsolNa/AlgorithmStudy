# DP
- 기본적인 아이디어로 하나의 큰 문제를 여러 개의 작은 문제로 나누어서 그 결과를 저장하여 다시 큰 문제를 해결할 때 사용하는 것으로 특정한 알고리즘이 아닌 하나의 문제 해결 패러다임이다.
- 큰 문제를 작은 문제로 쪼개서 그 답을 저장해두고 재활용한다.
- 일반적인 재귀를 단순히 사용하게되면 작은 문제들이 려 번 반복 되어 비효율적인 계산이 이루어지지만 DP를 이용하여 한번 구한 작은 문제의 결과 값을 저장해두고 재사용 한다면 시간복잡도를 개선할 수 있다.
- DP가 적용되기 위해서는 2가지 조건을 만족해야 한다.
    - Overlapping Subproblems(겹치는 부분 문제)
    - Optimal Substructure(최적 부분 구조)
- Overlapping Subproblems
    - 동일한 작은 문제들이 반복하여 나타나는 경우에 사용이 가능하다.
      ![img1](dp_img/img1.png)
- Optimal Substructure
    - 부분 문제의 최적 결과 값을 사용해 전체 문제의 최적 결과를 낼 수 있는 경우를 의미한다.
      ![img2](dp_img/img2.png)
- DP로 풀 수 있는 문제인지 확인
    - 특정 데이터 내 최대화 / 최소화 계산을 하거나 특정 조건 내 데이터를 세야 한다거나 확률 등의 계싼의 경우 DP로 풀 수 있는 경우가 많다.
- 문제의 변수 파악
    - DP는 현재 변수에 따라 그 결과 값을 찾고 그것을 전달하여 재사용하는 것을 거친다. 즉, 문제 내 변수의 개수를 알아내야 한다는 것이다. 이것을 영어로 'state'를 결정한다고 한다.
- 변수 간 관계식 만들기
    - 변수들에 의해 결과 값이 달라지지만 동일한 변수값인 경우 결과는 동일하다. 또한 그 결과값을 그대로 이용할 것이므로 그 관계식을 만들수 있어야 한다. 이러한 식을 점화식이라고 부른다.
- 메모하기
    - 변수의 값에 따른 결과를 저장해야한다.
- 기저 상태 파악하기
    - 가장 작은 문제의 상태를 알아야한다.
- 구현하기
    - Bottom-up (Tabulation 방식) - 반복문 사용
    - Top-Down (Memorization 방식) - 재귀 사용
- Bottom-Up 방식
    - 아래에서 부터 계산을 수행 하고 누적시켜서 전체 큰 문제를 해결하는 방식이다.
    - "Tabulation"
        - 반복을 통해서 dp[0]부터 하나씩 채우는 과정을 "table-filling"이라고 하며, 이 Table에 저장된 값에 직접 접근하여 재활용한다.
- Top-Down 방식
    - 위에서 부터 바로 호출을 시작하여 dp[0]의 상태까지 내려간 다음 해당 결과 값을 재귀를 통해 전이시켜 재활용하는 방식이다.




**피보나치 수열 예시**

```JAVA
public class Fibonacci{
	// DP 를 사용 시 작은 문제의 결과값을 저장하는 배열|
	// Top-down, Bottom-up 별개로 생성하였음(큰 의미는 없음)|
	static int[] topDown_memo;
	static int[] bottomup_table;
	public static void main(String[] args){
		int n = 30;
		topDown_memo = new int[n+1];
		bottomup_table = new int[n+1];

		long startTime = System.currentTimeMillis();
		System.out.println(naiveRecursion(n));
		long endTime = System.currentTimeMillis();
		System.out.println("일반 재귀 소요 시간 : " + (endTime - startTime));

		System.out.println();

		startTime = System.currentTimeMillis();
		System.out.println(topDown(n));
		endTime = System.currentTimeMillis();|
		System.out.println("Top-Down DP 소요 시간 : " + (endTime - startTime));

		System.out.println();

		startTime = System.currentTimeMillis();
		System.out.println(bottomUp(n));
		endTime = System.currentTimeMillis();
		System.out.println("Bottom-Up DP 소요 시간 : " + (endTime - startTime));
	}

	// 단순 재귀를 통해 Fibonacci를 구하는 경우|
	// 동일한 계산을 반복하여 비효율적으로 처리가 수행됨|
	public static int naiveRecursion(int n){
		if(n &lt;= 1){
			return n;
		}
		return naiveRecursion(n-1) + naiveRecursion(n-2);
	}

	// DP Top-Down을 사용해 Fibonacci를 구하는 경우
	public static int topDown(int n){
	// 기저 상태 도달 시, 0, 1로 초기화
	if(n &lt; 2) return topDown_memo[n] = n;

	// 메모에 계산된 값이 있으면 바로 반환!
	if(topDown_memo[n] &gt; 0) return topDown_memo[n];

	// 재귀를 사용하고 있음!|
	topDown_memo[n] = topDown(n-1) + topDown(n-2);

	return topDown_memo[n];
	}

	// DP Bottom-Up을 사용해 Fibonacci를 구하는 경우
	public static int bottomUp(int n){
		// 기저 상태의 경우 사전에 미리 저장
		bottomup_table[0] = 0; bottomup_table[1] = 1;

		// 반복문을 사용하고 있음!
		for(int i=2; i&lt;=n; i++){
		// Table을 채워나감!
			bottomup_table[i] = bottomup_table[i-1] + bottomup_table[i-2];
		}
		return bottomup_table[n];
	}
}

/*
결과
832040
일반 재귀 소요 시간 : 9

832040
Top-Down DP 소요 시간 : 0

832040
Bottom-Up DP 소요 시간 : 0
}
```