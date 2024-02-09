import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {

        // 출발지점과 도착지점을 배열에 추가하기 위해 기존 배열 + 2를 사이즈로 하는 신규 배열을 생성한다.
        int length = rocks.length + 2;
        int[] rock = new int[length];

        // 기존 배열을 옮기고
        for(int i = 0; i < length - 2; i++) rock[i] = rocks[i];

        // 출발 지점과 도착 지점을 배열에 추가한다.
        rock[length - 2] = 0;
        rock[length - 1] = distance;

        // 이후 배열을 정렬한다.
        Arrays.sort(rock);

        // 이분 탐색을 위한 start와 end 포인트
        int start = 0;
        int end = distance;
        // 결과 값을 기록하기 위한 변수
        int result = 0;

        // 이분 탐색 시작
        while(start <= end) {

            // 중간 점
            int mid = (start + end) / 2;
            // 합계
            int sum = 0;
            // 인덱스
            int now = 0;

            // 배열의 길이만큼 반복
            for(int i = 1; i < length; i++) {

                // 누적합으로 구한다.
                if(rock[i] - rock[now] < mid) sum++;
                else now = i;
            }

            if(sum > n) end = mid - 1;
            else {
                result = mid;
                start = mid + 1;
            }

        }

        return result;
    }
}