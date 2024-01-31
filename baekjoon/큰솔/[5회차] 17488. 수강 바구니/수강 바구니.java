import java.io.*;
import java.util.*;

public class Main {

    //메서드 활용을 위한 전역 변수 선언
    private static int n;
    private static int[] l;
    // 수강 초과를 기록하기 위한 배열
    private static boolean[] over;
    // 학생 별 수강 성공 여부를 기록하기 위한 배열
    private static boolean[][] map;
    private static BufferedReader br;
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        l = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) l[i] = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        over = new boolean[m];

        // 메서드 실행
        enrolment();

        // 1차 수강과 2차 수강을 관리하기 위해 1차 수강의 기록을 깊은 복사로 copy
        boolean[][] ans = new boolean[n][m];
        for(int i = 0; i < n; i++) System.arraycopy(map[i], 0, ans[i], 0, m);

        // 메서드 실행
        enrolment();
        for(int j = 0; j < map.length; j++) {

            boolean chk = false;
            for (int i = 0; i < map[j].length; i++) {

                // 1차 수강과 2차 수강 중 한 번이라도 성공했다면 강의 번호 기록
                if (map[j][i] || ans[j][i]) {
                    sb.append(i + 1).append(" ");
                    chk = true;
                }

            }
            
            // 없다면 망했어요 출력
            if(!chk) sb.append("망했어요");
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // 수강 신청 메서드
    private static void enrolment() throws IOException {
        StringTokenizer st;
        
        // 학생 수 만큼 반복
        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            while(true) {

                // 탈출 조건, 편의를 위해 -1
                int request = Integer.parseInt(st.nextToken()) - 1;

                if(request == -2) break;

                // 이미 초과된 강의라면 continue로 넘긴다.
                if(over[request]) continue;

                // 아니라면 해당 강의 수강 제한 인원 - 1
                l[request]--;
                
                // 신규 수강 신청 후 인원이 초과 됐다면
                if(l[request] < 0) {
                    
                    // 기존 수강 성공 이력을 모두 무효화 한 뒤
                    for(int j = 0; j < n; j++) map[j][request] = false;
                    
                    // 해당 강의를 초과 상태로 만든다.
                    over[request] = true;
                } else {
                    
                    // 아니라면 수강 신청 성공으로 기록
                    map[i][request] = true;
                }
            }
        }
    }


}