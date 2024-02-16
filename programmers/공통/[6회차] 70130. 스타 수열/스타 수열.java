class Solution {
    public int solution(int[] a) {
        
        int len = a.length;
        int max = 0;
        
        int[] arr = new int[len];
        
        for(int i = 0; i < len; i++) arr[a[i]]++;
        
        for(int i = 0; i < len; i++) {
            
            if(arr[i] <= max) continue;

            int amount = 0;
            
            for(int j = 0; j < len - 1; j++) {
                
                if((a[j] == i || a[j + 1] == i) && a[j] != a[j + 1]) {
                    j++;
                    amount++;
                }
            }
            
            max = Math.max(amount, max);
        }
        
        return max * 2;
    }
}