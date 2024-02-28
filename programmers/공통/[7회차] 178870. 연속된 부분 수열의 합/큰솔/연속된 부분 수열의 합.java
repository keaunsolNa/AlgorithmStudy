import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
		
        int[] answer = new int[]{0, sequence.length - 1};
        
        int left = 0;
        int right = 1;
        int sum = sequence[0];
        
        while(left < right) {
            
            if (sum == k) {
                change(right, left, answer);
                sum -= sequence[left++];
            }

            else if (sum > k) sum -= sequence[left++];
            else if (right < sequence.length) sum += sequence[right++];
            else break;
        }
        
       return answer;
	}
	
    

    private static void change(int right, int left, int[] answer) {
    
        if (right - 1 - left < answer[1] - answer[0]) {
                answer[0] = left;
                answer[1] = right - 1;
        }
    }
    
}