import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * bj1377
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());    // 배열의 크기
        maxData[] A = new maxData[N];
        for (int i = 0; i < N; i++) {
			A[i] = new maxData(Integer.parseInt(br.readLine()), i);

		}

        // 문제와 동일하게 for문 했더니 시간초과
        // 버블정렬은 한번에 1칸씩만 이동하기 때문에 전체 정렬 후 인덱스 비교하는 방법 사용
        Arrays.sort(A);

        int Max = 0;

        for(int i = 0; i < N; i++){
            if(Max < A[i].index - i){
                Max = A[i].index - i;
            }
        }

        System.out.println(Max + 1);   // swap이 일어나지 않고 반복문이 한 번 더 실행될 수 있으므로 + 1

    }

}

class maxData implements Comparable<maxData>{

    int value;  // 배열의 값
    int index;  //기존 index

    public maxData(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(maxData o) {
        return this.value - o.value;    // value 기준 오름차순 정렬
    }
    
}