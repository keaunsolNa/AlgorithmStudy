import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        //처음 입력받은 값만큼 반복
        while( num-- > 0){
            //기본적인 출력값을 YES로 설정
            //VPS가 아닐경우 NO를 출력하고 실행을 멈추기 위함
            String answer = "YES";
            //Deque를 사용하여 Stack배열을 구성
            Deque<Character> stackChar = new ArrayDeque<>();
            char[] arr = br.readLine().toCharArray();

            //배열을 순회
            for(char item : arr){
                //여는 괄호를 만날경우 스택에 add
                if(item == '(')
                    stackChar.add(item);

                //닫는 괄호를 만날경우
                //스택이 비어있는지 확인 (비어있는 경우 : 잘못된 VPS 출력값을 NO로 설정후 반복문 break)
                //스택이 비어있지 않은경우 (정상적은 VPS 진행중임으로 스택에서 여는 괄호를 pop)
                if(item == ')'){
                    if(!stackChar.isEmpty()){
                        stackChar.pop();
                    }else{
                        answer = "NO";
                        break;
                    }
                }
            }

            //여는 괄호의 개수가 많을 경우 반복이 끝났음에도 스택에 값이 남아있기 때문에 비어있다면 NO 출력
            if(!stackChar.isEmpty()) answer = "NO";
            System.out.println(answer);
        }
    }
}