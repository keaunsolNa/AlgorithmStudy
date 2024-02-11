import java.util.Arrays;

class Solution {
   static String solution(int[] numbers) {
		
		String[] str = new String[numbers.length];
 
        for(int i = 0; i < numbers.length; i++){
            // string 으로 변경하여 배열에 삽입
            str[i] = String.valueOf(numbers[i]);
        }
 
        // 두 수를 합친 값이 큰 순서대로 내림차순 정렬
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
 
        // 첫 번째 수가 0이면 0을 리턴.
        if (str[0].equals("0")) {
            return "0";
        }
 
        // 문자열 연결하여 return
        return String.join("", str);
	}
}