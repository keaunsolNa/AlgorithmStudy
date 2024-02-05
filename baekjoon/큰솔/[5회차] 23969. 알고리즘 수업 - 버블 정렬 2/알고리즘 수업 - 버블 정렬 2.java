import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = N; i >= 2; i--) {

            for(int j = 0; j < N - 1; j++) {

                if(arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    K--;

                    if(K == 0) {

                        for (int l : arr)
                            System.out.print(l +" ");
                        System.exit(0);

                    }

                }
            }
        }

        System.out.println(-1);
    }
}