import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열의 길이
        int N = Integer.parseInt(st.nextToken());
        // 타겟 수
        long M = Long.parseLong(st.nextToken());
        // 배열
        int[] arr = new int[N];
        //배열값 입력받음
        st = new StringTokenizer(br.readLine());
        //입력받은 값을 배열안에 할당
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //투 포인터, 포인터사이 값의 합, 목표값개수
        int p1 =0, p2 = 0, hab = 0, count = 0;

        //p2포인터가 배열을 넘으면 종료
        while (true) {
            //포인터 사이의 값이 M이상이면 p1을 제거후 p1증가
            if (hab >= M){
                hab -= arr[p1++];
            }else if(p2 == N){
                break;
            }else {
                //포인터 사이의 값이 M미만이면 p2의 값을 더한후 p2증가
                hab += arr[p2++];
            }
            //포인터 사이의 값이 목표값과 같다면 count 증가
            if (hab == M) {
                count++;
            }
        }
        System.out.print(count);
    }
}