import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    // 노래에 대한 구현체
    private static class Sing implements Comparable<Sing>{

        // 시퀸스 넘버 (고유번호)
        int seq;
        // 곡별 재생횟수
        int play;
        // 장르별 총 재생횟수
        int totalPlay;
        // 장르
        String genres;

        public Sing(int seq, int play, int totalPlay, String genres) {
            this.seq = seq;
            this.play = play;
            this.totalPlay = totalPlay;
            this.genres = genres;
        }

        // Comparable 인터페이스 구현체 compareTo 사용하여 클래스 정렬
        @Override
        public int compareTo(Sing o) {

            // 장르별 총 재생횟수가 다르다면 총 재생횟수의 내림차순 정렬
            if(this.totalPlay != o.totalPlay) return o.totalPlay - this.totalPlay;
            // 아니라면 각 곡별 재생횟수로 내림차순 정렬
            else if(this.play != o.play) return o.play - this.play;
            // 아니라면 고유번호 오름차순 정렬
            else return Integer.compare(this.seq, o.seq);
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        // 노래의 정보를 담을 Map
        Map<String, Integer> map = new HashMap<>();
        // 정렬을 위한 PriorityQueue
        PriorityQueue<Sing> pq = new PriorityQueue<>();

        // 장르의 양만큼 순회하며
        for(int i = 0; i < genres.length; i++)
            // 장르별 총 재생횟수 (누적합) 추가
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

        // 장르의 양만큼 순회하며
        for(int i = 0; i < genres.length; i++)
            // PriorityQueue에 Sing 클래스 형태로 시퀸스 번호, 개별 재생횟수, 총 재생횟수, 장르 저장.
            pq.add(new Sing(i, plays[i], map.get(genres[i]), genres[i]));

        // 리스트 선언
        List<Integer> list = new ArrayList<>();
        // 비교를 위해 PriorityQueue의 가장 앞선 노래 추출
        Sing sing = pq.poll();
        // 리스트에 담는다.
        list.add(sing.seq);
        // 비교를 위한 String 객체 (장르)
        String prev = sing.genres;
        // 장르별 노래 숫자를 기록하기 위한 변수
        int cnt = 0;

        // PriorityQueue의 사이즈만큼 순회
        while(!pq.isEmpty()) {

            sing = pq.poll();

            // 이전 곡의 장르와 현재 곡의 장르가 같다면 cnt++
            if(prev.equals(sing.genres)) cnt++;
            // 아니라면 다른 장르이므로 cnt 초기화
            else cnt = 0;

            // 이전 곡의 장르 변경
            prev = sing.genres;
            // 장르별 수록곡이 2개 이하라면 list에 add
            if(cnt < 2) list.add(sing.seq);

        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);

        return answer;
    }
}