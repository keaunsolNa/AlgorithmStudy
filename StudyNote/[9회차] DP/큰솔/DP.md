# DP
- 개념
    - 복잡한 문제를 여러 개의 작은 부분 문제(Sub-Problem)로 나누어 해결하는 방법
    - Memoization을 이용하면 큰 문제로부터 빠른 속도로 최적의 해를 찾아낼 수 있다.
    - Memoization이란 반복되는 결과를 메모리에 저장해서 중복호출 되었을 때, 한 번 더 계산하지 않고 메모리에 저장해둔걸 가져와서 재활용하는 방식이다.
- 특징
    - Top-Down 방식과 Bottom-Up 방식이 있다.
    - Top-Down 방식은 큰 문제(Main Problem)에서 작은 부분 문제(Sub-Problem)를 재귀적으로 호출하여 리턴된 값으로 문제를 해결하는 방식이다. 아래의 코드는 피보나치 수열의 Top-Down 방식 구현의 의사코드.

        ```java
        Func(n) = Func(n-1) + Func(n-2);
        ```

    - Top-Down 방식은 재귀함수를 통해 구현되기 때문에 함수 호출에 대한 오버헤드가 발생한다는 단점이 있다.
    - 단, Memoization을 잘 활용하면 Bottom-Up보다 훨씬 빠르다.
    - Bottom-Up 방식은 작은 부분문제(Sub Problem)를 미리 계산해두고, 이 문제들을 모아 큰 문제를 해결하는 방식이다. 아래의 코드는 피보나치 수열의 Bottom-Up 방식 구현의 의사코드.

        ```java
        DP[1] = 1;
        DP[2] = 1;
        
        for(int i = 3; i < N; i++){
        	DP[1] = DP[i-2] + DP[i-1];
        }
        ```

    - Bottom-Up은 큰 문제를 해결하기 위해서 어떤 Sub-Problem이 요구되는지 몰라서 모든 부분 문제를 해결해야 한다는 단점이 있다.
    - 단, for문으로 구현되므로 자원이 비교적 자유로워 시간 및 메모리 최적화가 수월하다.
- 구현
    - 대표적인 문제로 Coin Change Problem을 구현한다.
    - 거스름돈을 줄 때 동전의 갯수를 최소화하는 로직을 짜는 문제로, Coin DP라고 한다. 코드는 다음과 같다.

        ```java
        import java.util.*;
         
        public class Main {
            public static void main(String args[]) {
                Scanner scanner = new Scanner(System.in);
         
                int n = scanner.nextInt();
                int k = scanner.nextInt();
         
                int coin[] = new int[n];
                for (int i = 0; i < n; i++) {
                    coin[i] = scanner.nextInt();
                }
         
                int d[] = new int[k + 1];
                for (int i = 1; i <= k; i++) {
                    d[i] = -1;
                    for (int j = 0; j < n; j++) {
                        if (coin[j] <= i) {
                            if (d[i - coin[j]] < 0) continue;
                            if (d[i] < 0) d[i] = d[i - coin[j]] + 1;
                            else if (d[i - coin[j]] + 1 < d[i]) d[i] = d[i - coin[j]] + 1;
                        }
                    }
                }
         
                System.out.println(d[k]);
            }
        }
        ```

    - int n 은 가지고 있는 동전의 갯수다. (1원 1개, 5원 1개, 11원 1개라면 n = 3)
    - int k 는 만들어야 하는 금액이다.
    - coin[i]는 동전의 액수다. (위 예시를 이어나가, 1원, 5원, 11원)
    - D[i]는 i원을 만들기 위해 필요한 동전의 최소 갯수다.
    - Coin에는 가지고 있는 동전의 가치이며, Coin[N] = {1, 5, 11}이라면, 거스름돈으로 1원, 5원, 11원짜리를 가지고 있음을 의미한다.
    - 우선 d[i] = -1;을 통해 Coin의 값을 초기화 한다.
    - 이후 i가 임의의 수일때, 임의의 수보다 작거나 같은 동전이 있는지 조건문을 통해 탐색한다. 편의상 A 조건문으로 칭한다.
        ```java
        if (coin[j] <= i)

    - 이후 d[i]가 -1이면 반복문을 진행하지 않는 조건문을 추가한다. 이는 가지고 있는 동적으로는 만들 수 없는 값을 탐색하기 위함이다. 예를 들어 2원, 5원, 11원을 가지고 있을 때, 8원을 만들 수 없는 경우를 예외처리하기 위함이다. 이를 B조건문이라 칭한다.
        ```java
        if (d[i - coin[j] < 0) continue

    - A조건문과 B 조건문으로 만들 수 있는 동전임을 증명하는 예외처리를 마친다. 이후에는 반복문을 통해 최소값을 찾기 위한 탐색을 진행한다.
        ``` java
        if (d[i] < 0) d[i] = d[i - coin[j]] + 1;

    - D[i]가 -1이라면, 즉 구하려는 d원을 처음만났다면 일단 'i-Coin[j]원의 방법에 Coin[j]코인 1개를 더하는 방법'으로 값을 할당한다. 즉, d[6] = d[6 -5] + 1, 즉 d[1] + 1 의 의미는 1원을 만들기 위해 필요한 최소 동전의 갯수에 5원을 추가하여, 6원을 만들때 필요한 최소 동전의 갯수를 d[6]에 저장하겠다는 소리가 된다. → C 조건문
        ``` java
        else if (d[i - coin[j]] + 1 < d[i]) d[i] = d[i - coin[j]] + 1;

    - 위 조건문의 경우에는 i가 5일 때, d[4]까지 구해진 상태에서, 5원만 넣은 것과 (d[i]), 4원까지의 최소 값에 +1 한 것 (d[i - coin[j] + 1)을 비교했을 때, 더 작은 값을 넣는 조건문이다. 즉, 최소 가짓수를 위한 알고리즘.