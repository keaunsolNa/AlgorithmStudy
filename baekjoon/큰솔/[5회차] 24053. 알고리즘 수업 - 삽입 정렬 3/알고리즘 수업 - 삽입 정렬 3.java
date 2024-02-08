import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;
    private static int[] arr2;
    private static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        arr = new int[n + 1];
        arr2 = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        insertionSort();
        System.out.println(0);

    }

    private static void insertionSort() {

        for(int i = 2; i <= n; i++) {

            int loc = i - 1;
            int newItem = arr[i];

            while(1 <= loc && newItem < arr[loc]) {

                arr[loc + 1] = arr[loc];
                loc--;
                if(chk()) {
                    System.out.println(1);
                    System.exit(0);
                }
            }

            if(loc + 1 != i) arr[loc + 1] = newItem;
            if(chk()) {
                System.out.println(1);
                System.exit(0);
            }
        }
    }

    private static boolean chk() {

        boolean chk = true;
        for(int i = 1; i <= n; i++) {

            if(arr[i] != arr2[i]) { chk = false; break; }
        }

        return chk;
    }
}