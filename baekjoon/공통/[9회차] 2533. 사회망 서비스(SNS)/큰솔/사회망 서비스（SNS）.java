import java.util.*;
import java.io.*;

public class Main {

    private static List<List<Integer>> list;
    private static int[][] dp;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;

       int n = Integer.parseInt(br.readLine());
       list = new ArrayList<>();
       dp = new int[n + 1][2];
       visited =  new boolean[n + 1];

       for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

       for (int i = 0; i < n - 1; i++) {

           st = new StringTokenizer(br.readLine());
           int u = Integer.parseInt(st.nextToken());
           int v = Integer.parseInt(st.nextToken());

           list.get(u).add(v);
           list.get(v).add(u);
       }

       solve(1);
       System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    private static void solve(int node) {

        visited[node] = true;
        dp[node][0] = 1;

        for (int next : list.get(node)) {

            if (visited[next]) continue;

            solve(next);
            dp[node][1] += dp[next][0];
            dp[node][0] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}