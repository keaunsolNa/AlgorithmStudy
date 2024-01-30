import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] A;
    static long K;
    static int size;
    public static void quickSort(int p, int r){
       if(p < r){
           int q = partition(p, r);
           quickSort(p, q-1);
           quickSort(q + 1, r);
       }
    }

    public static int partition(int p, int r){
        int x = A[r];
        int i = p - 1;
        for(int j = p; j < r; j++){
            if(A[j] <= x){
                swap(++i,j);
            }

        }

        if ( (i + 1) != r) {
            swap(i+1,r);
        }

        return i + 1;
    }

    public static void swap(int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;

        if(--K == 0){
            for(int abc = 1; abc < size; abc++){
                sb.append(A[abc]).append(" ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken()) + 1;
        K = Integer.parseInt(st.nextToken());
        A = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < size; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(1, size -1 );

        if(sb.toString().isEmpty()){
            System.out.print("-1");
        } else{
            System.out.print(sb.toString().replaceFirst(".$",""));
        }
    }
}