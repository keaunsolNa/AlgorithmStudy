import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer> tree = new ArrayList<>();
		int last = 1;
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {

			int length = Integer.parseInt(st.nextToken());
			tree.add(length);
			if(length > last) last = length;

		};
		
		int first = 0;
		while(first < last) {
			
			int mid = (first + last) / 2;
			long sum = 0;
			
			for(int treeH : tree)
				if(treeH - mid > 0) sum += treeH - mid;

			if(sum < M) last = mid;
			else first = mid +1;

		}
		
		System.out.println(first - 1);
	}
}