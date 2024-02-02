import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int K;
    private static int cnt = 0;
    private static boolean flag = false;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        heapSort(arr);
    }


    private static void heapSort(int[] arr) {

        int n = arr.length - 1;
        buildMinHeap(arr, n);

        for (int i = n ; i >= 2; i--) {
            swap(arr, 1, i);
            heapify(arr, 1, i - 1);
        }

        if(flag) System.out.println(result);
        else System.out.println(-1);

    }

    private static void buildMinHeap(int[] arr, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(arr, i, n);
        }
    }

    private static void heapify(int[] arr, int e, int n) {

        int left = 2 * e;
        int right = left + 1;
        int smaller = 0;

        if (right <= n) {

            if (arr[left] < arr[right]) smaller = left;
            else smaller = right;

        }

        else if (left <= n) smaller = left;

        else return;

        if (arr[smaller] < arr[e]) {
            swap(arr, e, smaller);
            heapify(arr, smaller, n);
        }
    }

    private static void swap(int[] arr, int z, int x) {

        cnt++;
        int temp = arr[z];
        arr[z] = arr[x];
        arr[x] = temp;

        if(cnt == K) {

            flag = true;
            for(int i = 1 ; i < arr.length ; i++) result.append(arr[i]+" ");

        }

    }
}