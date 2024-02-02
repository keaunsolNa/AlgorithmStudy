import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {

        // 숫자간 더하기가 아닌 문자열 이어붙이기의 형식이므로 int 배열이 아닌 string 배열로 변환한다.
        String[] intArr = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        String answer = "";

        for (int i=0; i < intArr.length; i++)
            intArr[i] = String.valueOf(numbers[i]);


        // 배열을 정렬한다. 기준은 두 개의 스트링을 이어 붙인 뒤 compareTo로 내림차순 정렬
        Arrays.sort(intArr, new Comparator<String>() {

            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        // 만약 가장 큰 수가 0이라면 0을 그대로 반환한다.
        if(intArr[0].equals("0")) return "0";

        else {

            // 아니라면
            for(int i = 0; i < intArr.length; i++)
                // String + 보단 StringBuilder append가 더 빠르다.
                sb.append(intArr[i]);
        }

        return answer.toString();
    }
}