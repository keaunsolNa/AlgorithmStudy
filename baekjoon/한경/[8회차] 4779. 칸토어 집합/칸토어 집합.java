import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = "";

        while( (num = br.readLine()) != null){
            int str = Integer.parseInt(num);
            int pow = (int)Math.pow(3,str); // 3제곱 구하기
            sb = new StringBuilder();

            for(int i = 0; i < pow; i++){
                sb.append('-'); // 문자열 생성                
            }

            set(0, pow);
            System.out.println(sb);

        }

    }

    public static void set(int start,int size) {
		if(size==1) { //문자열 사이즈가 1이되면 리턴
			return;
		}

		int newSize=size/3;
        
        // 3등분한 문자열의 2번째 부분 공백처리
		for(int i=start+newSize; i<start+2*newSize; i++) {
			sb.setCharAt(i, ' ');   
		}
		
		set(start, newSize); // 3등분한 문자열에서 앞부분
		set(start+2*newSize, newSize); // 3등분한 문자열의 뒷부분
	}
}
