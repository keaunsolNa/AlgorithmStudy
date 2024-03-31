import java.util.*;

class Solution {

    public int solution(String arr[]) {

        int oc = (int) Math.ceil(arr.length / 2.0);
        int[][] maxDp = new int[oc][oc];
        int[][] minDp = new int[oc][oc];

        for (int i = 0; i < oc; i++) {

            Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
            maxDp[i][i] = Integer.parseInt(arr[i * 2]);
            minDp[i][i] = Integer.parseInt(arr[i * 2]);

        }

        for (int cnt = 1; cnt < oc; cnt++)

            for (int i = 0; i < oc - cnt; i++) {

                int j = i + cnt;

                for (int k = i; k < j; k++)

                    if (arr[k * 2 + 1].equals("+")) {

                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + maxDp[k + 1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + minDp[k + 1][j]);

                    } else {

                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] - minDp[k + 1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] - maxDp[k + 1][j]);

                    }

            }


        return maxDp[0][oc - 1];

    }
}