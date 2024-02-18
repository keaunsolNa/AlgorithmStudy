import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        // 자연수 A를 B번 곱한 수를 C로 나눈 나머지
        System.out.print(pow(A,B,C));

    }


    public static long pow(long x, long y, long z){
        long result = 1;

        //분할정복을 이용한 거듭제곱
        /*if (y == 0) return 1; //재귀 종료조건
        long tmp = pow(x, y/2, z); // 지수를 2로 나눈 몫을 재귀*/

        /*
          분할정복을 이용한 거듭제곱 공식
          pow(k,x) = k * pwo(k, x/2) * pow(k, x/2)
          모듈러 연산 특징
          (A * B)%m = ((A % m) * (B % m)) % m
         */
       /* if (y % 2 == 1){
            //홀수 x * pow(x,y/2) * pow(x,y/2)
            //모듈러 연산의 특징을 사용하여 곱하기 전에도 나머지를 구함
            result = ((x % z) * (tmp % z) * (tmp % z)) % z;
        } else {
            //짝수 pow(x,y/2) * pow(x,y/2)
            result = ((tmp % z) * (tmp % z)) % z;
        }
        return result;*/

        while( y > 0){
            if (y % 2 == 1){
                result = (result % z) * ((x % z) % z);
            }
            x = (x % z) * ((x % z) % z);
            y /= 2;
        }
        return result % z;
    }

}