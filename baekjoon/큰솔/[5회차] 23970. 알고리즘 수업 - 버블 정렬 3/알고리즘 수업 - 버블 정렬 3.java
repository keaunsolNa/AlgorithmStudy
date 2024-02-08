import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;
    private static int[] arr2;
    private static int[] arr3;
    private static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        arr = new int[n];
        arr2 = new int[n];
        arr3 = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = arr3[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        if(chk()) { System.out.println(1); return; }

        Arrays.sort(arr3);
        insertionSort();

    }

    private static void insertionSort() {

        int len = n;

        for(int i = n - 1; i >= 0; i--) {

            if(arr2[i] != arr3[i]) break;

            for(int j = 0; j < len - 1; j++) {

                if(arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    if(arr[len - 1] == arr2[len - 1] && chk()) {
                        System.out.println(1);
                        return;
                    }
                }
            }
            len--;
        }

        if(chk()) { System.out.println(1); return; }

        for(int i = 0; i < n - 1; i++) {

            if(arr[i] > arr[i + 1]) {

                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;

                if(chk()) { System.out.println(1); return; }
            }
        }

        System.out.println(0);
    }


    private static boolean chk() {

        boolean chk = true;
        for(int i = 0; i < n; i++) {

            if(arr[i] != arr2[i]) { chk = false; break; }
        }

        return chk;
    }
}