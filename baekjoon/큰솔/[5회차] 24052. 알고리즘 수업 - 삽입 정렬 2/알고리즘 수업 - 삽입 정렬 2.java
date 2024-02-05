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

        for (int i = 1; i < N; i++) {
            int loc = i - 1;
            int newItem = arr[i];

            while (loc >= 0 && newItem < arr[loc]) {
                arr[loc + 1] = arr[loc];
                loc--;
                K--;

                if(K == 0) {
                    for (int j : arr) System.out.print(j + " ");
                    System.exit(0);
                }


            }
            if (loc + 1 != i) {

                arr[loc + 1] = newItem;
                K--;

                if(K == 0) {
                    for (int j : arr) System.out.print(j + " ");
                    System.exit(0);
                }
            }
        }

        System.out.println(-1);
    }
}