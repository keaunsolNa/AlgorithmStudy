# Two Pointer

- 1차원 배열에서 각자 다른 원소를 가리키고 있는 2개의 포인터를 조작해가면서 원하는 값을 찾을 때 까지 탐색하는 알고리즘이다.
- 리스트에 순차적으로 접근해야 할 때 두 개의 점(포인트)의 위치를 기록하면서 처리한다.
- 처음에는 start=end=0 이고, 조건은 항상 두 포인터들의 관계는 start <= end이다.
- 특정한 합을 가지는 부분 연속 수열 찾기에 사용될 수 있다.
  - 어떤 숫자들의 리스트가 주어질 때, 해당 리스트의 연속 수열의 합이 특정 값을 가지는 것을 확인하는 문제
- 매 루프마다 항상 두 포인터 중 하나는 1씩 증가한다. 각 포인터는 최대 N까지 증가할 수 있고, 항상 start <= end 이다. 따라서 두 포인트가 증가하는 과정은 최대 N번만 반복된다. O(N^2)가 걸리는 문제를 O(N)에 해결할 수 있다.


# 예시) 백준 2003 ( 수들의 합 2)


```Java
import java.io.*;  
import java.util.StringTokenizer;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());  
        // 배열의 길이  
        int N = Integer.parseInt(st.nextToken());  
        // 타겟 수  
        long M = Long.parseLong(st.nextToken());  
        // 배열  
        int[] arr = new int[N];  
        //배열값 입력받음  
        st = new StringTokenizer(br.readLine());  
        //입력받은 값을 배열안에 할당  
        for (int i = 0; i < N; i++) {  
            arr[i] = Integer.parseInt(st.nextToken());  
        }  
  
        //투 포인터, 포인터사이 값의 합, 목표값개수  
        int p1 =0, p2 = 0, hab = 0, count = 0;  
  
        //p2포인터가 배열을 넘으면 종료  
        while (true) {  
            //포인터 사이의 값이 M이상이면 p1을 제거후 p1증가  
            if (hab >= M){  
                hab -= arr[p1++];  
            }else if(p2 == N){  
                break;  
            }else {  
                //포인터 사이의 값이 M미만이면 p2의 값을 더한후 p2증가  
                hab += arr[p2++];  
            }  
            //포인터 사이의 값이 목표값과 같다면 count 증가  
            if (hab == M) {  
                count++;  
            }  
        }  
        System.out.print(count);  
    }  
}
```