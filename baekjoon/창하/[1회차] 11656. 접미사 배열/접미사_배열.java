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

        /*
            위 문제의 경우 출력해야 할 건수가 최대 1000건이지만,
            상위 난이도 문제의 경우 10 ~ 100만 건까지의 출력도 많습니다.
            질의에 대한 출력이 단일 건이 아닌 경우,
            System.out.println();은 Scanner와 같이 출력 성능이 좋지 않아 불이익이 큽니다.
            다건의 출력이 필요할 경우 StringBuilder()를 사용하는 것을 권장드립니다.
            동일한 문제의 경우, 동일한 코드의 출력문을 System.out.println()이 아닌
            StringBuilder()를 사용했을 경우 성능 차이는
            기존 메모리: 16040 KB, 시간: 208 ms
            에서 메모리: 17732 KB, 시간: 168 ms의 차이가 있습니다.
            위 문제의 경우 출력건이 많지 않아 크지 않아 보일 수 있지만,
            https://chb2005.tistory.com/73
            위 링크 확인 시 유의미한 성능 차이를 확인 가능하십니다...
         */

    }
}