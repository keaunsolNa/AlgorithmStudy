class Solution {
    public static StringBuilder sb = new StringBuilder();
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
            
		int N = arr.length;
		QuadTree(0, 0, N, arr);
		
		int zero = 0;
		int one = 0;
		for (int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) == '0') {
				zero++;
			} else if(sb.charAt(i) == '1') {
				one++;
			}
		}
		answer[0] = zero;
		answer[1] = one;
				
		return answer;
    }
    
    public static void QuadTree(int x, int y, int size, int[][] arr) {
		
		if(isPossible(x, y, size, arr)) {
			sb.append(arr[x][y]);
			return;
		}
		
		int newSize = size / 2;	
		
		QuadTree(x, y, newSize, arr);						
		QuadTree(x, y + newSize, newSize, arr);				
		QuadTree(x + newSize, y, newSize, arr);				
		QuadTree(x + newSize, y + newSize, newSize, arr);	
		
	}
	
	public static boolean isPossible(int x, int y, int size, int[][] arr) {
		int value = arr[x][y];
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(value != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}