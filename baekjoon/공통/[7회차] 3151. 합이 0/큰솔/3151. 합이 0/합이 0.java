import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);

		long answer = 0L;
		
		for(int x = 0; x < N; x++) {
			
			if(arr[x] > 0) break;
			int start = x + 1;
			int end = N - 1;
			
			while(start < end) {
				
				int s = 1;
				int e = 1;
				int c = arr[x] + arr[start] + arr[end];
				
				if(c == 0) {
					
					if(arr[start] == arr[end]) {
						answer += ((end - start + 1)) * (end - start) / 2;
						break;
					}
					
					while(start + 1 < end && arr[start] == arr[start + 1]) {
						s++;
						start++;
					}
					
					while(start < end - 1 && arr[end] == arr[end - 1]) {
						e++;
						end--;
					}
					
					answer += s * e;
				}
				
				if(c > 0) end--;
				else start++;
			}
		}
		System.out.println(answer);
		
   }
}