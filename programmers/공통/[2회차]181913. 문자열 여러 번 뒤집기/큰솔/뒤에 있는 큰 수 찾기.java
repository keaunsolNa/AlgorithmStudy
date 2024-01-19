class Solution {
    public String solution(String my_string, int[][] queries) {

        for(int i = 0; i < queries.length; i++) {
            int sta = queries[i][0];
            int end = queries[i][1];

            StringBuilder sb0 = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for(int j = 0; j < my_string.length(); j++) {
                if(j < sta) sb0.append(my_string.charAt(j));
                else if (j <= end) sb1.append(my_string.charAt(j));
                else sb2.append(my_string.charAt(j));
            }

            sb1 = sb1.reverse();

            my_string = sb0.append(sb1).append(sb2).toString();
        }
        return my_string;
    }
}