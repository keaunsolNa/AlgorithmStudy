import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 순열 입력
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        // 스택 배열 생성
        Stack<Integer>[] stacks = new Stack[4];

        // 배열에 스택 초기화, 최소값 0 입력
        for(int i = 0; i < 4; i++) {
            stacks[i] = new Stack<>();
            stacks[i].push(0);
        }

        // 순열 탐색
        for(int i = 0; i < n; i++) {

            //플래그
            boolean chk = false;

            // 스택의 갯수만큼 반복문 수행
            for(Stack<Integer> stack : stacks) {

                // 각 스택의 peek이 순열의 값보다 작다면
                if(stack.peek() < a[i]) {

                    // 스택에 순열의 값을 업데이트하고
                    stack.push(a[i]);
                    // 플래그 처리
                    chk = true;
                    break;
                }
            }

            // 모든 스택의 peek이 순열의 값보다 크다면 순열을 정리할 수 없다
            if(!chk) {
                System.out.println("NO");
                return;
            }
        }

        // if(!chk) 를 거치지 않았다면 순열 정리가 가능하다.
        System.out.println("YES");
    }

}