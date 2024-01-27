import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new TreeMap<>(Collections.reverseOrder());    // 역순 트리맵

        int n = Integer.parseInt(br.readLine());    // 출입기록 수

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();   // 이름
            String com = st.nextToken();     // 출입기록

            // 출입이면 put
            if(com.equals("enter")){
                map.put(name, com);
            } else {
                // 아니면 remove
                map.remove(name);
            }
        }
        
        // 출력
        for(String key: map.keySet()){
            System.out.println(key);
           }



    }
}
