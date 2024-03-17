# DP

## DP (Dinamic Programming)

- 동적계획법 : 하나의 큰 문제를 여러개의 작은 문제로 나누어 그 결과를 저장하여 사용

## Memoization

- 중복되는 계산 결과를 저장하는 메모리 기법인 메모이제이션(Memoization)을 사용
- 이전에 계산한 값을 캐싱하고, 다시 필요할 때 해당 값을 가져와 재사용

## DP의 조건

- Overlapping Subproblems
    - DP란 문제를 나누고 값을 재활용하여 답을 구하기 때문에 동일한 작은 문제들이 반복하여 나타나는 경우에 사용 가능하다.
    - 따라서 부분 문제가 반복적으로 나타나지 않는 경우 사용할 수 없다.
- Optimal Substructure
    - 부분 문제의 최적의 결과 값을 사용해 전체 문제의 최적 결과를 낼 수 있는 경우 사용 가능하다.
    - ex) 부분 문제에서 구한 최적의 결과가 전체 문제ㅔ서도 동일하게 적용되는 경우
    

## DP의 구현방식

- Bottom-Up 방식
    - 아래에서부터 계산을 수행하고 누적시켜 큰 문제 해결하는 방식
    - 작은 문제들의 결과 값을 저장함으로써 동일한 계산을 반복하지 않아 시간 복잡도 감소
    - 스택 오버플로우가 발생할 가능성이 있음
- Top-Down 방식
    - dp[n]의 값을 찾기 위해 위에서부터 바로 호출을 시작하여 dp[0]의 상태까지 내려간 다음 해당 결과 값을 재귀를 통해 재활용하는 방식
    - 초기값을 설정해주어야 하고, 작은 문제들의 결과 값을 임시적으로 저장해 둘 공간이 필요

## DP로 피보나치 수열 구하기

```java
public class MemoizationExample {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = fibonacci(n - 1) + fibonacci(n - 2);

        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }
}
```