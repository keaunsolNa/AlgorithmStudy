import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);

        long min = times[0];
        long max = (long) n * times[times.length - 1];

        while(min <= max) {

            long people = 0;
            long mid = (min + max) / 2;

            for(int t : times) people += mid / t;

            if(people >= n) max = mid - 1;
            else min = mid + 1;
        }

        return min;
    }
}