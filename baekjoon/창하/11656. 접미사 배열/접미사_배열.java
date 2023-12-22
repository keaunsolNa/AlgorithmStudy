import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 접미사_배열 {
    public static void main(String args[]) throws IOException {
        //BufferedReader를 사용한 문자열 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력된 문자열을 String변수 st에 저장
        String st = br.readLine();

        //입력된 문자열 st의 길이만큼의 String 타입의 배열 생성.
        String[] arr = new String[st.length()];

        //입력받은 문자열 st의 길이만큼 반복문 실행
        for(int i=0; i < st.length(); i++){
            //배열에 st의 문자열을 1씩 잘라 '접미사 배열'을 생성
            arr[i] = st.substring(i);
        }

        //Arrays 정렬함수인 sort를 사용
        //배열 arr 오름차순 정렬
        Arrays.sort(arr);

        //st의 길이 = arr배열크기만큼 반복문 실행
        for(int i=0; i < st.length(); i++){
            //정렬된 배열 arr 출력
            System.out.println(arr[i]);
        }

    }
}