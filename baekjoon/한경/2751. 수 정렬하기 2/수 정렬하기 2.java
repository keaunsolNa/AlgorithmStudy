import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    
    public static int[] A;
    public static int[] temp;
    
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        temp = new int[N+1];

        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        // Arrays.sort(A); 사용 시 시간초과
        // 버블정렬로 정렬해도 시간초과,,,
        // 병합정렬로 다시 시도
        mergeSort(1, N);
        
        for(int l = 1; l <= N; l++){
           bw.write(A[l] + "\n");
        }

        bw.flush();
        bw.close();

    }

    // 병합정렬 구현
    public static void mergeSort(int start, int end) {

        if(end-start < 1){
            return;
        }

        // 쪼갤 배열의 중간지점 저장
        int mid = start + (end-start) / 2;

        // 처음부터 중간까지 병합정렬
        mergeSort(start, mid);

        // 중간 +1부터 끝까지 병합정렬
        mergeSort(mid+1, end);
       
        // 원래 배열 저장
        for(int i = start; i<= end; i++){
            temp[i] = A[i];
        }

        // 인덱스 저장
        int p = start;
        int q = mid + 1;
        int idx = p;

        // 3가지 경우를 한번에 비교했더니 시간초과가 나와서 각각의 경우로 구분
        // 두 분할된 집합에 모두 원소가 있는 경우
        while (p<=mid && q<=end) {
            // 두 분할된 집합의 원소 값을 비교하여 더 작은 값을 A에 넣고 각각의 인덱스 한 칸 이동
            if(temp[p]>temp[q]){
                A[idx] = temp [q];
                idx++;
                q++;
            } else {
                A[idx] = temp[p];
                idx++;
                p++;
            }
        }

        // 한쪽 그룹에만 원소가 있는 경우
        while (p <=mid){
            A[idx] = temp[p];
            idx++;
            p++;
        }

        while (q <= end){
            A[idx] = temp[q];
            idx++;
            q++;
        }
    }

}
