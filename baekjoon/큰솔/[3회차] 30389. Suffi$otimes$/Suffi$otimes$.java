import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // O(1) 탐색을 위해 HashSet 사용
        HashSet<String> s = new HashSet<>();

        while(n --> 0) {

            String str = br.readLine();

            // suffix 배열의 빠른 탐색을 위해 역탐색
            for(int i = 0; i < str.length(); i++) {

                // 연산 횟수 줄이기 위해 변수 설정
                String key = str.substring(i);

                // O(1) 탐색으로 키가 있다면 remove (교집합 제거)
                if(s.contains(key)) s.remove(key);
                // 아니라면 add (합집합)
                else s.add(key);
                // => 차집합 연산.
            }
        }

        // Set의 사이즈가 답안.
        System.out.println(s.size());

    }

}