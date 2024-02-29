import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N과 M 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N];
        int[] answer = new int[2];
        int j = 0;
        int k = N-1;
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(number);


        int min = Math.abs(number[j] + number[k]);

        while (k>j){

            int sum = number[j] + number[k];
            
            if(Math.abs(sum) <= min){
                min = Math.abs(sum);
                answer[0] = number[j];
                answer[1] = number[k];

                if(sum == 0){
                    break;
                }
            }
            
            // 음수 + 음수가 제일 작은 값일 경우도 고려해야함
            if(sum < 0){
                // 음수인 경우 왼쪽 포인터 이동
                j++;
            } else if(sum > 0){
                // 양수인 경우 오른쪽 포인터 이동
                k--;
            }

        }

        sb.append(answer[0] + " " + answer[1]);

        System.out.println(sb);
    }
}
