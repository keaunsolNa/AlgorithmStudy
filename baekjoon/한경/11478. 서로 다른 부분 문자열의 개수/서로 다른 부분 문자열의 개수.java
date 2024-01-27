import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();    // 중복 제거를 위해 HashSet 사용

        String S = br.readLine(); // 문자열 입력받기

        for(int i = 0; i < S.length(); i++){
            for(int j = i+1;j <= S.length(); j++){
                // 이중 for문을 통해 문자열 조합을 hashset에 add
                set.add(S.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}