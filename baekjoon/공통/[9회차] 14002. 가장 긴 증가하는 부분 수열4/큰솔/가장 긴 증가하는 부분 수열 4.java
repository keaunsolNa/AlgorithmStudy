import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static Integer[] number, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		number = new Integer[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) number[i] = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++) solove(i);
	
		int ans = Integer.MIN_VALUE;
		for (int i : dp) if(ans < i) ans = i;
		
        int value = ans;
        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            if (value == dp[i]) {
                stack.push(number[i]);
                value--;
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop() + " ");
        
        System.out.println(ans);
        System.out.println(sb);
		
	}
	
	private static int solove(int n) {
		
		if(dp[n] == null) {
			dp[n] = 1;

			for(int i = n - 1; i >= 0; i--)
				if(number[i] < number[n]) dp[n] = Math.max(dp[n], solove(i) + 1);

		}

		return dp[n];
	}
}