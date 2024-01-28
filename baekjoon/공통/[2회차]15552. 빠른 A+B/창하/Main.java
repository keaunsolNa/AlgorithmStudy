import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //문자를 읽기위해 BufferedReader 사용
        /*
            BufferedReader가 Scanner보다 빠른이유
            Scanner는 1KB의 버퍼를 갖고있다. => 키보드의 입력이 키를 누르는 즉시 바로 전달됨.
            BufferedRader는 8KB의 버퍼를 갖고있다. 키보드의 입력이 있을 때마다 한 문자씩 버퍼로 전송
            버퍼가 가득 차거나, 개행문자가 있을경우 버퍼의 내용을 한번에 전달.
            입력 횟수를 줄이기 때문에 속도가 증가한다.(?)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //sb를 사용하지 않고 System.out.println()을 많이하니 입출력때문에 시간제한 걸림
        //sb를 사용하여 하나의 긴문자열로 만들어서 반환 System.out.print를 한번만
        StringBuilder sb = new StringBuilder();
        //첫번째 입력값은 입력받을 문자의 횟수
        int length =  Integer.parseInt(br.readLine());
        //한줄단위로 읽은 문자열을 공백단위로 나누기 위해 Stringtokenizer 사용
        StringTokenizer st;

        //입력받은 값 횟수만큼 반복
        for(int i = 0; i < length; i++){
            //한줄 읽믄 문자열을 공백기준으로 나눔
            st = new StringTokenizer(br.readLine()," ");
            //공백기준으로 나눈 Token을 int형 변환한 뒤 StringBuilder 문자열에 이어붙이기
            //마지막 줄넘김을 위해 마지막에 \n 문자열을 붙이기
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
        }

        //생성한 문자열을 출력
        System.out.print(sb);
    }
}