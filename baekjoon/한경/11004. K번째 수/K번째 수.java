import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
  
        int N = Integer.parseInt(st.nextToken());   // N개의 수를 입력받고
        int K = Integer.parseInt(st.nextToken());   // 정렬 후 K번 째 값을 return

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];   /// N개의 수로 이루어진 배열 A

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N-1, K-1);


        System.out.println(A[K-1]);
    }

    // 퀵소트 실행
    public static void quickSort(int[] A, int S, int E, int K){

        // S : 시작값, E : 종료 값
        if(S < E){
            int pivot = partition(A, S, E); // pivot 설정

            if(pivot == K){
                // pivot이 K번째 수 인 경우 바로 return
                return;     
            } else if(K < pivot){
                // K가 pivoit보다 작으면 K의 왼쪽만 정렬
                quickSort(A, S, pivot - 1, K);
            } else {
                // K가 pivot보다 크면 K의 오른쪽만 정렬
                quickSort(A, pivot + 1, E, K);
            }
        }
    }

    public static int partition(int[] A, int S, int E){

        // 시작값 + 1이 종료값인 경우 == 데이터가 2개인 경우는 바로 swap해서 return
        if(S+1 == E){
            if(A[S] > A[E]){
                swap(A, S, E);
            }

            return E;
        }

        // 가운데 값을 골라서 pivot으로 설정정
        int M = (S+E) / 2;
        swap(A, S, M);  // 중앙값과 A[S] swap

        int pivot = A[S];
        int i = S+1;    // pivot 다음 값을 i로 설정
        int j = E;

        while(i <= j){
            
            // pivot보다 작은 수가 나올때까지 j--
            while(j >= S+1 && pivot < A[j]){
                j--;
            }

            // pivot보다 큰 수가 나올때까지 i++
            while(i <= E && pivot > A[i]){
                i++;
            }

            // i와 j가 만나면 swap
            if(i <= j){
                swap(A, i++, j--);
            }
        }

        A[S] = A[j];
        A[j] = pivot;
        
        return j;

    }

    // A의 i번째 값과 j번째 값을 swap
    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
