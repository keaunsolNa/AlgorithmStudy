import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 학생의 수
        int N = Integer.parseInt(st.nextToken());
        int[] studentArr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            studentArr[i] = Integer.parseInt(st.nextToken());
        }
        //학생 배열 오름차순 정렬
        Arrays.sort(studentArr);

        // 조합이 가능하므로 long
        long count = 0;

        //첫번째수를 고정시키고 나머지 두수를 탐색
        for(int i=0; i<N; i++){
            //시작 수가 0보다크면 오름차순이므로 계산할 필요없음
            if(studentArr[i] > 0 ) break;
            //첫번째 값
            int first = studentArr[i];
            //두번째 값 탐색 위치 (앞에서부터)
            int s = i+1;
            //세번째 값 탐색 위치 (뒤에서부터)
            int e = N-1;

            //두번째 수가 세번째 수보다 작을때까지
            while(s < e){
                //세수의 합
                int sum = first + studentArr[s] + studentArr[e];

                //정답일때
                if(sum == 0){
                    //두번째, 세번째 수가 같은 수의 개수
                    int l = 1;
                    int r = 1;

                    //두번째수부터 끝까지 같다면
                    if (studentArr[s] == studentArr[e]){
                        //s에서 e까지의 개수 조합
                        count += getCombination(e-s+1);
                        break;
                    }

                    //두번째수의 값이 같을때
                    while (studentArr[s] == studentArr[s+1]){
                        //두번째수의 개수 증가
                        l++;
                        //두번째수 인덱스 증가
                        s++;
                    }
                    //세번째수의 값이 같을때
                    while (studentArr[e] == studentArr[e-1]){
                        //세번째수의 개수 증가
                        r++;
                        //세번째수는 뒤에서부터 오기때문에 감소
                        e--;
                    }

                    //왼쪽의 개수 * 오른쪽의 개수 (가능한 수)
                    count += l * r;
                }

                //세수의 합이 0보타 크다면 세번째수 인덱스 감소
                if (sum > 0){
                    e--;
                }
                //세수의 합이 0보다 작다면 두번째수 인덱스 증가
                else {
                    s++;
                }
            }
        }
        System.out.print(count);
    }

    public static int getCombination(int n){
        //nC2 = n!/(n-2)!2! = n(n-1)/2!
        return n * (n-1) / 2;
    }
}