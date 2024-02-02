import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] arr2 = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) arr2[i] = Integer.parseInt(st.nextToken());

        boolean flag1 = true;
        for(int i = 1; i <= n; i++) if(arr[i] != arr2[i]) flag1 = false;

        if(flag1) {
            System.out.println(1);
            return;
        }

        for(int last = n; last >= 2; last--) {

            int max = Integer.MIN_VALUE;
            int i = 0;

            for(int idx = 1; idx <= last; idx++) {
                if (max < arr[idx]) {
                    max = arr[idx];
                    i = idx;
                }
            }

            if (last != i) {
                int tmp = arr[last];
                arr[last] = arr[i];
                arr[i] = tmp;

                boolean flag = true;
                for(int c = 1; c <= n; c++) {
                    if(arr[c] != arr2[c]) {
                        flag = false;
                    };
                }

                if(flag) {
                    System.out.print(1);
                    return;
                }
            }
        }

        System.out.print(0);
    }
}
