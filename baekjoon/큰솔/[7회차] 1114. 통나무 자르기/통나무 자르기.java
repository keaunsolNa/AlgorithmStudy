import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long l = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Long> cutList = new ArrayList<>();
        cutList.add(0L);
        cutList.add(l);
        for (int i = 0; i < k; i++) cutList.add(Long.parseLong(st.nextToken()));

        cutList.sort((a, b) -> (int) (a - b));

        long start = 0;
        long end = l;
        long first = 0;
        long last = l;

        while(start <= end) {

            long mid = start + (end - start) / 2;
            long currentCut = 0;
            long firstCut = -1;
            long diff = 0;

            for (int i = k; i >= 0; i--) {

                diff += cutList.get(i + 1) - cutList.get(i);

                if (diff > mid)  {

                    diff = cutList.get(i + 1) - cutList.get(i);
                    currentCut++;

                    if(diff > mid) {

                        currentCut = c + 1;
                        break;
                    }
                }
            }

            if (currentCut < c) firstCut = cutList.get(1);
            else firstCut = diff;

            if (currentCut <= c) {

                last = Math.min(mid, last);
                first = firstCut;
                end = mid - 1;

            } else start = mid + 1;
        }


        System.out.println(last + " " + first);
    }

}