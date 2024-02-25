import java.io.*;
import java.util.*;

public class Main {

    private static List<Long> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if(n > 1022) { System.out.println(-1); return; }
        else if(n < 10) { System.out.println(n); return; }

        for(int i = 0; i < 10; i++) dp(i, 1);

        Collections.sort(list);

        System.out.println(list.get(n));
    }

    private static void dp(long num, int idx) {

        if(idx > 10) return;

        list.add(num);

        for(int i = 0; i < num % 10; i++) dp((num * 10) + i, idx + 1);
    }
}