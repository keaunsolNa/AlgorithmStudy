import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 원본 티어리스트 배열
        String[] tierList = new String[n];
        for(int i = 0; i < n; i++) tierList[i] = st.nextToken();

        // 정렬 티어리스트 clone
        String[] sortList = tierList.clone();

        // Arrays.sort
        Arrays.sort(sortList, (o1, o2) -> {

            // 티어만 뜯어낸다.
            String key = o1.substring(0, 1);
            String key2 = o2.substring(0, 1);

            // 단계만 뜯어낸다.
            int value = Integer.parseInt(o1.substring(1));
            int value2 = Integer.parseInt(o2.substring(1));

            // 티어가 같다면 단계 순 정렬
            if (key.compareTo(key2) == 0) return value2 - value;

            // 티어가 다르다면
            else {

                // 함수 돌린 뒤 정렬
                key = convertRank(key);
                key2 = convertRank(key2);

                return key.compareTo(key2);
            }
        });

        // 원본과 정렬을 비교하면서 다르다면 append
        for(int i = 0; i < n; i++) {

            if(!sortList[i].equals(tierList[i])) sb.append(sortList[i]).append(" ");
        }

        // 출력
        System.out.println(sb.isEmpty() ? "OK" : "KO\n" + sb.toString());

    }

    // 티어별 정렬 메서드
    private static String convertRank(String rank) {

        // 스위치로 티어를 받아 B -> S -> G -> P -> D 순으로 정렬한다.
        switch (rank) {
            case "B" -> {
                return "0";
            }
            case "S" -> {
                return "1";
            }
            case "G" -> {
                return "2";
            }
            case "P" -> {
                return "3";
            }
            default -> {
                return "4";
            }
        }
    }
}