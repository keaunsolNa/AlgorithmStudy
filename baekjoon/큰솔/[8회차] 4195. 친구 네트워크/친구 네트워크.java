import java.io.*;
import java.util.*;

public class Main {

    private static int[] parent;
    private static int[] level;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t --> 0) {

            int f = Integer.parseInt(br.readLine());

            parent = new int[f * 2];
            level = new int[f * 2];

            for (int i = 0; i < f * 2; i++) {
                parent[i] = i;
                level[i] = 1;
            }

            int idx = 0;
            Map<String, Integer> map = new HashMap<>();

            while(f --> 0) {

                st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if(!map.containsKey(name1)) map.put(name1, idx++);
                if(!map.containsKey(name2)) map.put(name2, idx++);

                sb.append(union(map.get(name1), map.get(name2))).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    private static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    private static int union(int x, int y) {

        x = find(x);
        y = find(y);

        if(x != y)  {
            parent[y] = x;
            level[x] += level[y];

            level[y] = 1;
        }

        return level[x];
    }

}