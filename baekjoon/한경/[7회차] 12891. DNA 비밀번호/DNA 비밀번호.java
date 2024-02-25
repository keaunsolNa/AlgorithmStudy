import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int checkArr[];  // 비밀번호가 조건에 맞는지 체크
    static int cuArr[];     // 현재 상태 배열
    static int checkSecret; // 마지막 상태 체크용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // S과 P 입력 받기
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0; // 결과값

        char number[] = new char[S];
        checkArr = new int[4];
        cuArr = new int[4];
        checkSecret = 0;

        number = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0){
                checkSecret++;  // 이미 충족
            }
        }

        for(int i = 0; i < P; i++){
            Add(number[i]);
        }
        
        if(checkSecret == 4){
            result++;
        }

        for(int i = P; i < S; i++){
            int j = i-P;
            Add(number[i]);
            Remove(number[j]);

            if(checkSecret == 4){
                result++;
            }
        }


        System.out.println(result);
    }

    private static void Remove(char c) {
        switch(c) {
            case 'A':
                if (cuArr[0] == checkArr[0]){
                    checkSecret--;
                }
                cuArr[0]--;
                break;
            case 'C':
                if (cuArr[1] == checkArr[1]){
                    checkSecret--;
                }
                cuArr[1]--;
                break;
            case 'G':
                if (cuArr[2] == checkArr[2]){
                    checkSecret--;
                }
                cuArr[2]--;
                break;
            case 'T':
                if (cuArr[3] == checkArr[3]){
                checkSecret--;
                }
                cuArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch(c) {
            case 'A':
                cuArr[0]++;
                if (cuArr[0] == checkArr[0]){
                    checkSecret++;
                }
                break;
            case 'C':   
                cuArr[1]++;
                if (cuArr[1] == checkArr[1]){
                    checkSecret++;
                }
                break;
            case 'G':
                cuArr[2]++;
                if (cuArr[2] == checkArr[2]){
                    checkSecret++;
                }
                break;
            case 'T':
                cuArr[3]++;
                if (cuArr[3] == checkArr[3]){
                    checkSecret++;
                }
                break;
        }
    }
}
