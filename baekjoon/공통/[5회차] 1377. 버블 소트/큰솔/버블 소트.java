import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 배열의 값과 인덱스를 담을 Class
    public static class Array implements Comparable<Array> {

        int num;
        int idx;

        public Array(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        // 배열의 값 기준으로 정렬
        @Override
        public int compareTo(Array o) {
            return num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Array[] arr = new Array[N + 1];

        // 배열에 값 삽입, 1 ~ N
        for(int i = 1; i <= N; i++) arr[i] = new Array(Integer.parseInt(br.readLine()), i);
        // 1부터 N + 1 까지 정렬
        Arrays.sort(arr, 1, N + 1);

        int max = 0;
        // 정렬된 인덱스와 정렬 전 인덱스를 비교하여 최대값을 찾으므로
        // Class의 인덱스(정렬 전 인덱스)에서 i(정렬 후 인덱스) 를 뺀 값 중 최대 값을 찾는다.
        for(int i = 1; i <= N; i++) max = Math.max(max, arr[i].idx - i);

        // 1을 더한다.
        System.out.println(max + 1);
    }
}