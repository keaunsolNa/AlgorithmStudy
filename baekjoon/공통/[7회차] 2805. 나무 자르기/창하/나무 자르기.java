import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //나무의 개수
        int N = Integer.parseInt(st.nextToken());
        //가져가려는 나무의 길이
        int M = Integer.parseInt(st.nextToken());
        //나무 배열
        int[] tree = new int[N];
        //가장 작은 나무 높이
        int min = 0;
        //가장 높은 나무 높이
        int max = 0;
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            //나무 배열 삽입
            tree[i] = Integer.parseInt(st.nextToken());
            //가장 높은 나무높이
            if (max < tree[i]){
                max = tree[i];
            }
        }
        //이분탐색 upper bound 사용
        while(min < max){
            //중간값 설정
            int mid = (min + max) / 2;
            //나무 높이 배열의 합 ( 최대 1000000 * 2000000000 )
            long sum = 0;

            //나무 배열을 순회하며 나무 높이 비교
            for(int treeHeight : tree) {

                //나무의 높이가 mid보다 클때만 (음수는 더하지 않음)
                if (treeHeight - mid > 0) {
                    //잘라낸 나무의 합
                    sum += (treeHeight - mid);
                }
            }
                //잘라낸 나무길이의 합(sum)이 가져가야할 나무길이의 합(mid)보다 작을때
                //mid(잘라내는 나무길이)가 클수록 sum이 작아짐
                if (sum < M){
                    //잘라내는 나무의 범위를 min ~ mid 까지로 설정
                    max = mid;
                } else {
                    //나무길이의 합이 가져가야할 나무길이의 합보다 크거나 같을때
                    //잘라내는 나무의 범위를 mid + 1 ~ max 까지로 설정
                    min = mid + 1;
                }

        }
        System.out.println(min - 1);
    }
}