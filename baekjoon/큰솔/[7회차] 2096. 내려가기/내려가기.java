import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];

        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int thr = Integer.parseInt(st.nextToken());

            if(i == 0) {
            	
            	max[0] = min[0] = one;
            	max[1] = min[1] = two;
            	max[2] = min[2] = thr;
            	
            } else {
            	
            	int beforeMax = max[0];
            	int beforeMax2 = max[2];
            	
            	max[0] = Math.max(max[0], max[1]) + one;
            	max[2] = Math.max(max[1], max[2]) + thr;
            	max[1] = Math.max(Math.max(beforeMax, max[1]), beforeMax2) + two;
            	
            	int beforeMin = min[0];
            	int beforeMin2 = min[2];
            	
            	min[0] = Math.min(min[0], min[1]) + one;
            	min[2] = Math.min(min[1], min[2]) + thr;
            	min[1] = Math.min(Math.min(beforeMin, min[1]), beforeMin2) + two;
            }
        }

        System.out.print(Math.max(max[0], Math.max(max[1], max[2])));
        System.out.print(" ");
        System.out.print(Math.min(min[0], Math.min(min[1], min[2])));
    }

}