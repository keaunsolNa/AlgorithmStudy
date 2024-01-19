import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      Stack<Character> stack = new Stack<>();
      StringBuilder sb = new StringBuilder();   //후위표기식

      // 중위표기식 입력받기
      String infix = st.nextToken();

      // 후위표기식으로 수정
      for (int i = 0; i < infix.length(); i++) {

         char A = infix.charAt(i);

         if(Character.isAlphabetic(A)){
            // 피연산자면 문자열에 추가
            sb.append(A);
         } else{
            // 닫는 괄호를 만나면 stack에서 연산자를 전부 꺼낸다
            // 괄호가 하나가 아닐 수 있으므로 수정하기
            if(A == ')'){
               while(!stack.isEmpty()){
                  if(stack.peek() != '('){
                     sb.append(stack.pop());
                  } else {
                     stack.pop();
                     break;
                  }
                  
               }
            // 연산자면 우선순위 비교
            // 연산자의 우선순위가 peek()과 같거나 더 작으면 꺼낸다.
            } else if(A == '+' || A == '-'){
               // 스택에 값이 있으면
               if(!stack.isEmpty()){
                  // +나-일 경우
                  // 괄호가 있지 않으면
                  if(!stack.contains('(')){
                     while(!stack.isEmpty()){
                        sb.append(stack.pop());
                     }
                  } else{
                     while(!stack.isEmpty()){
                        if(stack.peek() != '('){
                           sb.append(stack.pop());
                        } else {
                           break;
                        }
                        
                     }
                  }
                  // 괄호가 있으면 push
                  stack.push(A);
               // stack에 값이 없으면
               }else{
                  stack.push(A);
               }

            } else if(A == '*' || A == '/'){   
               if(!stack.isEmpty()){
                  // A가 +나 -일 경우 무조건 push
                  if(stack.peek() == '+' || stack.peek() == '-'){
                     stack.push(A);
                  // A가 *나 /일 경우 pop
                  } else if(stack.peek() == '*' || stack.peek() == '/'){
                     // 괄호가 없음
                     if(!stack.contains('(')){
                        while(!stack.isEmpty()){
                           if(stack.peek() == '+' || stack.peek() == '-'){
                              break;
                           } else{
                                sb.append(stack.pop());
                           }

                           
                        }
                     } else{
                        while(!stack.isEmpty()){
                           if(stack.peek() != '('){
                              if(stack.peek() == '+' || stack.peek() == '-'){
                                 break;
                              } else{
                                sb.append(stack.pop());
                              }   
                           } else {
                              break;
                           }
                           
                        }
                     }

                     stack.push(A);
                  }else{
                    stack.push(A);
                  } 
               }else{
                  stack.push(A);
               }
            // A가 '(' 인 경우
            } else{
               stack.push(A);
            }

         }
      }

      // for문으로 size()까지 돌리면 1번만 실행하고 끝난다,,,,,, 왜지? ㅠㅠ
      while(!stack.isEmpty()){
         if(stack.peek() != '('){
            sb.append(stack.pop());
         } else {
            stack.pop();
            break;
         }
         
      }
      
      System.out.println(sb);
   }   

}
