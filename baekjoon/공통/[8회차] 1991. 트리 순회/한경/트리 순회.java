import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 순회할 트리
    static int[][] tree;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
        tree = new int[26][2];  

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node = st.nextToken().charAt(0) - 'A';  // 트리 인덱스 만들기 A부터 0으로
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(left == '.'){
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A';     // 해당 알파벳의 인덱스로 가기 위해 숫자로 저장
            }

            if(right == '.'){
                tree[node][1] = -1;
            } else {
                tree[node][1] = right - 'A';
            }
        }

          // 전위순회
          preOrder(0);
          System.out.println();
          // 중위순회
          inOrder(0);
          System.out.println();
          // 후위순회
          postOrder(0);
          System.out.println();
    }

    // 전위순회 (중앙-왼쪽-오른쪽)
    public static void preOrder(int cur){
        if (cur == -1){ // 빈 자식노드
            return;
        }

        System.out.print((char) (cur + 'A')); // 숫자로 저장했기 떄문에 A를 더해준다
        preOrder(tree[cur][0]);     // 왼쪽 자식노드 탐색
        preOrder(tree[cur][1]);     // 오른쪽 자식노드 탐색

    }

    // 중위순회 (왼쪽-중앙-오른쪽)
    public static void inOrder(int cur){
        if (cur == -1){ // 빈 자식노드
            return;
        }
 
        inOrder(tree[cur][0]);     // 왼쪽 자식노드 탐색
        System.out.print((char) (cur + 'A'));
        inOrder(tree[cur][1]);     // 오른쪽 자식노드 탐색

    }

    // 후위순회 (왼쪽-오른쪽-중앙)
    public static void postOrder(int cur){
        if (cur == -1){ // 빈 자식노드
            return;
        }

        
        postOrder(tree[cur][0]);     // 왼쪽 자식노드 탐색
        postOrder(tree[cur][1]);     // 오른쪽 자식노드 탐색
        System.out.print((char) (cur + 'A'));

    }
}
