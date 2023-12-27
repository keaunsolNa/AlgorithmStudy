class Solution {
    public int[] solution(long n) {

        // 정수 값 + "" = String, .toCharArray()로 Character 배열 생성
        char[] charArr = (n + "").toCharArray();
        // 정답을 담을 int 배열 생성
        int[] answer = new int[charArr.length];

        // Character 배열의 길이만큼 순회
        for(int i  = 0; i < charArr.length; i++)
            // 역순으로 int 배열에 담는다.
            answer[i] = charArr[charArr.length - (i + 1)] - '0';

        // 반환
        return answer;
    }
}