package 창하;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 타노스는 요세푸스가 밉다 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N마리의 청설모의 수
        int K = Integer.parseInt(st.nextToken()); // 삭제되는 청설모의 수
        Deque<Integer> dq = new ArrayDeque<Integer>(); //청설모들을 넣은 deque

        //청설모 1번부터 K번까지 DeQueue에 추가
        for(int i=1; i <=N; i++){
            dq.add(i);
        }

        while(true){
            //큐에 청설모가 한마리 이거나 K보다 적게 남아있는경우 해당 청설모 반환
            if(dq.size() == 1 || dq.size() < K) {
                System.out.println(dq.pollFirst());
                break;
            }else{
                //첫번째 청설모를 DeQueue의 마지막에 추가
                dq.addLast(dq.pollFirst());
                //첫번째 청설모를 제외한 청설모를 제거하므로 K-1마리 제거
                for(int i=0; i < K-1; i++){
                    dq.remove();
                }
            }
        }
    }
}