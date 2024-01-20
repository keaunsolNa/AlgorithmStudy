import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // 소수를 담기 위한 배열
    private static boolean[] isPrime;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // TC
        int t = Integer.parseInt(br.readLine());
        // 소수를 담기 위한 List
        List<Integer> list = new ArrayList<>();

        // 에라토스테네스의 체 실행
        sieve();

        // 실행 결과값으로 List 채우기
        for(int i = 0; i < isPrime.length; i++) if(isPrime[i]) list.add(i);

        // TC만큼 반복 시행
        while(t --> 0) {

            // 타겟이 되는 k
            int k = Integer.parseInt(br.readLine());

            // 반복문 탈출을 위한 플래그 변수
            boolean flag = false;
            // 정답을 담기 위한 int[] 변수
            int[] answer = new int[3];

            // 리스트의 사이즈만큼 3바퀴 돈다.
            for(int i = 0; i < list.size(); i++) {

                // 내장 for문
                for(int j = 0; j < list.size(); j++) {

                    // 내장 향상된 for문
                    for (Integer integer : list) {

                        // 리스트의 값들을 더해서 target이 됐을 경우
                        if (list.get(i) + list.get(j) + integer == k) {

                            // 탈출 변수 true
                            flag = true;

                            // 정답 담기
                            answer[0] = list.get(i);
                            answer[1] = list.get(j);
                            answer[2] = integer;
                            break;
                        }
                    }
                    // 값을 찾았을 경우 break
                    if(flag) break;
                }
                if(flag) break;
            }

            // 정답 오름차순으로 정렬
            Arrays.sort(answer);

            // 정답의 가장 큰 값이 0이라면 일치하는 값을 찾지 못 한 초기값이므로, 0을 출력한다.
            System.out.println(answer[2] == 0 ? 0 : answer[0] + " " + answer[1] + " " + answer[2]);
        }

    }

    // 에라토스테네스의 체 알고리즘
    private static void sieve() {

        // 7 <= K <= 1,000 이므로, 1001 크기의 배열 선언으로 충분하다.
        isPrime = new boolean[1001 + 1];

        // 초기 배열은 모두 true
        Arrays.fill(isPrime, true);

        // 소수에는 0, 1을 제외하므로 false
        isPrime[0] = false;
        isPrime[1] = false;

        // 2부터 시작하여 제곱근의 크기만큼 반복문 시행
        for (int i = 2; i * i <= 1001; i++) {

            // i가 소수일 경우 (2로부터 시작하므로 소수임이 입증)
            if (isPrime[i]) {

                // 소수에 자기 자신을 더한 값은 소수가 아니다. (명제)
                for (int j = 2 * i; j < 1001 + 1; j += i) {

                    // 소수가 아닌 값은 false 처리.
                    isPrime[j] = false;
                }
            }
        }
    }
}