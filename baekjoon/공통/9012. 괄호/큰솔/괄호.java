import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t --> 0) {

            Stack<Character> stack = new Stack<>();
            char[] charArray = br.readLine().toCharArray();

            for (char c : charArray) {

                // 문자열의 character 값이 '(' 라면 stack 에 넣는다.
                if(c == '(') stack.add(c);

                    // 아니라면
                else if(c == ')') {

                    // stack 이 비었을 경우 올바르지 않은 문자열이다.
                    // => 이전에 '('이 입력되지 않았으므로, ')'로 문자가 시작되는 케이스
                    if(stack.isEmpty()) {

                        // stack 이 비어있을 경우 올바른 문자열로 판별하므로 임의의 문자 'N'을 넣는다.
                        stack.add('N');
                        break;

                        // 스택이 비어 있지 않다면 '()' 형태로 들어왔다는 의미이므로 기존의 '('를 pop 한다.
                    } else stack.pop();

                }
            }

            // 스택이 비어있다면 모든 문자열이 올바른 괄호 문자열이라는 의미.
            sb.append(stack.isEmpty() ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

}