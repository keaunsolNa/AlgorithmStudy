import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] lts = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        lts[0] = arr[0] % 2 == 0 ? 0 : 1;

        for(int i = 1; i < n; i++) {

            if(arr[i] % 2 == 0) lts[i] = lts[i - 1];
            else lts[i] = lts[i - 1] + 1;

        }

        int ans = 0;
        for(int i = 0; i < n; i++) {

            int start = 0, end = i;

            while(start <= end) {

                int mid = (start + end) / 2;
                int cnt;

                if(mid == 0) cnt = lts[i];
                else cnt = lts[i] - lts[mid - 1];

                if(cnt <= k) end = mid - 1;
                else start = mid + 1;
            }

            int left = end + 1;
            if(left == 0) ans = Math.max(ans, i - left + 1 - lts[i]);
            else ans = Math.max(ans, i - left + 1 - (lts[i] - lts[end]));
        }

        System.out.println(ans);
    }
}