import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 스택 선언
        Stack<Character> stk = new Stack<>();

        // oper 배열 생성 (연산자 우선순위 측정)
        int[] oper = new int[50];
        oper['*'] = 1;
        oper['/'] = 1;
        oper['('] = -1;
        oper[')'] = -1;

        // 연산 대상 입력
        String s = br.readLine();

        // 연산의 길이만큼
        for (int i = 0; i < s.length(); i++) {

            // 하나씩 뜯어낸다.
            char c = s.charAt(i);

            // 들어온 문자가 연산자, 가로가 아니라면
            if (c >= 'A') {

                // StringBuilder에 더한다.
                sb.append(c);
                continue;
            }

            // 들어온 문자가 여는 괄호라면
            if (c == '(') {

                // 스택에 더한다.
                stk.add(c);
                continue;
            }

            // 들어온 문자가 닫는 괄호라면
            if (c == ')') {

                //스택의 가장 앞 요소가 (가 아니라면 StringBuilder에 스택의 요소 삽입
                while (stk.peek() != '(') sb.append(stk.pop());
                // 한 번 더
                stk.pop();
                continue;
            }

            // 스택이 비어있지 않고 연산자 우선순위가 스택의 가장 앞 요소보다 낮다면
            // StringBUilder에 스택의 앞 요소를 더한다.
            while (!stk.isEmpty() && oper[stk.peek()] >= oper[c]) sb.append(stk.pop());
            // 스택에 연산자 더한다.
            stk.add(c);

        }

        // 스택이 비어있을 떄까지 StringBuilder에 남은 스택의 요소들 삽입
        while (!stk.isEmpty()) sb.append(stk.pop());

        System.out.println(sb);
    }
}
