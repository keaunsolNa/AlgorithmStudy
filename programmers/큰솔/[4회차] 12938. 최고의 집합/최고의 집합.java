import java.util.*;

class Solution {
    public int[] solution(int n, int s) {

        if (s < n) return new int[]{-1};

        int q = s / n;
        int r = s % n;

        int[] answer = new int[n];
        for (int i = 0; i < n; i++)
            answer[i] = q;

        int idx = 0;

        while(r > 0) {

            if(idx >= n) idx = 0;

            answer[idx++]++;
            r--;

        }

        Arrays.sort(answer);

        return answer;
    }
}