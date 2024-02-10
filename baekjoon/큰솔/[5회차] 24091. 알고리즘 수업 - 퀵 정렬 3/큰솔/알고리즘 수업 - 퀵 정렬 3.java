import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[] arr;
    private static int[] arr2;
    private static boolean flag;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr2 = new int[n];
        for(int i = 0; i < n; i++) arr2[i] = Integer.parseInt(st.nextToken());

        flag = false;
        chk();
        quickSort(0, n - 1);

        System.out.println(flag ? 1 : 0);
    }

    private static void quickSort(int left, int right) {

        if(left >= right) return;
        if(flag) return;

        int pivot = partition(left, right);

        quickSort(left, pivot - 1);
        quickSort(pivot + 1, right);

    }
    private static int partition(int left, int right) {

        int l = left;
        int r = right;
        int pivot = arr[right];

        while(l < r) {

            while(l < r && arr[l] < pivot) l++;

            while(l < r && arr[r] >= pivot) r--;

            swap(l, r);
            chk();
        }

        swap(r, right);
        chk();
        return r;
    }

    private static void swap(int left, int right) {

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

    }
    private static void chk() {

        for(int i = 0; i < n; i++) {
            if(arr[i] != arr2[i]) return;
        }

        flag = true;
    }
}