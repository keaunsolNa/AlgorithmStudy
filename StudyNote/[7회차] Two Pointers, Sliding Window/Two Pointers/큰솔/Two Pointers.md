# Two Pointers

- 투 포인터는 정렬된 배열에서 쌍을 검색하는 데 일반적으로 사용되는 기술이다.
- 리스트에 순차적으로 접근해야 할 때 두 개의 점의 위치를 기록하면서 처리하는 알고리즘이다.
- N개의 정수를 갖는 정렬된 배열 A(오름차순)가 주어지면 그 합이 X와 같은 요소 쌍(A[start], A[end])가 있는지 찾는다.
- 알고리즘은 기본적으로 입력 배열이 정렬된다는 사실을 사용한다. 
  - 극단값(최솟값과 최댓값)의 합을 시작하고 조건에 따라 두 포인터를 모두 이동한다.
  - A[start]와 A[end]의 합이 X보다 작을 때 왼쪽 포인터를, 합이 X보다 클 때는 오른쪽 포인터를 이동한다.
  - 합이 X가 될 때까지 두 포인터를 움직인다.
- O(N)의 시간 복잡도를 가진다.
- 정렬되어 있는 두 리스트의 합집합에도 사용되며, 병합정렬과 분할 정복 알고리즘의 기초가 된다. 

# pseudocode
```java
import java.util.Arrays;
import java.util.List;

public class TwoPointer {
    
    // 길이가 N인 List A에서 합이 X인 순서쌍의 수를 구하는 메서드
	public static int isPairSum(List<Integer> A, int N, int X) {
        
        // 왼쪽 포인터
        int start = 0;
        // 오른쪽 포인터
        int end = N - 1;
        // 합계를 기록할 변수
        int sum = 0;

        while (start <= end) {

            // 왼쪽 포인터 + 오른쪽 포인터 == X라면
            if (A.get(start) + A.get(end) == X) sum++;

            // 왼쪽 포인터 + 오른쪽 포인터 < X라면
            if (A.get(start) + A.get(end) < X) start++;

                // 왼쪽 포인터 + 오른쪽 포인터 >= X
            else end--;
        }

        return sum;
	}

	// Driver code
	public static void main(String[] args) {

        // 초기 List(배열)
        List<Integer> arr = Arrays.asList(2, 4, 2, 4, 2, 4, 2);
        
        // 찾는 값
        int val = 6;
        // 리스트 크기
        int arrSize = arr.size();
        // 오름차순 정렬
        Collections.sort(arr);

        // 갯수 출력
        System.out.println(isPairSum(arr, arrSize, val)); // 3
	}
}

```