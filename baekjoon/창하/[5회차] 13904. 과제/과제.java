import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//과제
class Assignment{
    //과제 마감일
    int day;
    //과제 점수
    int score;
    Assignment(int day, int score) {
        this.day = day;
        this.score = score;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        //과제의 개수
        int N = Integer.parseInt(st.nextToken()); 
        //과제 리스트
        List<Assignment> assignmentList = new ArrayList<>();
        //과제에서 최대마감일
        int maxDay = 0;
        
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            
            //과제 마감일
            int d = Integer.parseInt(st.nextToken());
            //과제 점수
            int w = Integer.parseInt(st.nextToken());
            //과제 생성
            assignmentList.add(new Assignment(d, w));
            //과제 최대마감일
            maxDay = Math.max(maxDay, d);
        }

        //점수의 총합
        int totalscore = 0;
        
        //점수의 총합 구하기
        for (int i =  maxDay; i > 0; i--){
            totalscore += getMaxScoreInDay(assignmentList, i);
        }

        System.out.print(totalscore);
    }
    public static int getMaxScoreInDay(List<Assignment> assignmentList,int now){
        int idx = -1;
        int result = 0;
        for (int i = 0; i< assignmentList.size(); i++){
            if(assignmentList.get(i).day >= now && result < assignmentList.get(i).score) {
                idx = i;
                result = assignmentList.get(i).score;
            }
        }
        //0일때는 리스트에서 값을 제거가 안되기 때문에 return 0
        if (result == 0){
            return 0;
        }
        //그외의 값 리스트에서 값제1   
        assignmentList.remove(idx);
        return result;
    }
}
