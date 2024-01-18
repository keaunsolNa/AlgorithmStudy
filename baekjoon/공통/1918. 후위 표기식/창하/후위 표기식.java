package 창하;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    //연산자의 우선순위를 반환하는 메서드
    //우선순위가 높을수록 먼저 실행
    private static int getPriority(char o) {
        switch (o){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default :
                return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder(); // 결과를 담을 변수
        String N = br.readLine(); // 입력받는 문자열 ex) A*(B+C)
        Stack<Character> stack = new Stack<>();

        //입력받은 문자열을 Char형태의 배열로 순회
        for (char item : N.toCharArray()) {

            //피연산자는 바로 result에 append
            //item을 아스키 코드로 변환하여 대문자 A-Z 사이의 값인지 확인
            // A : 65 , Z : 90
            if ((int) item >= 65 && (int) item <= 90) {
                result.append(item);
            // 괄호는 다른 연산자보다 먼저 체크한다.
            // 만약 여는 괄호라면 stack에 push
            } else if (item == '(') {
                stack.push(item);
            // 닫는 괄호라면 여는 괄호가 나올때까지 연산자 pop
            } else if (item == ')') {
                while (stack.peek() != '(') {
                    result.append(stack.pop());
                }
                // 여는괄호 pop
                stack.pop();
            // 그 외라면 연산자이다.
            // 연산자 우선순위를 체크하여 현재 item의 우선순위보다 높다면 result에 append
            } else {
                while (!stack.isEmpty() && getPriority(item) <= getPriority(stack.peek())){
                    result.append(stack.pop());
                }
                //아니라면 stack에 해당 item push
                stack.push(item);
            }
        }

        //남은 연산자를 차례대로 꺼내서 result에 append
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        System.out.print(result);
    }
}