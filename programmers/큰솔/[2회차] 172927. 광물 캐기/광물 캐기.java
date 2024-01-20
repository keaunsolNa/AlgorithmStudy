import java.util.*;

class Solution {

    // 광물 Class
    private static class Mineral {

        private int dia;
        private int iron;
        private int stone;

        public Mineral(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }

    // 광물 그룹별 피로도를 누적하는 배열
    private static int[][] score;
    // 광물들 리스트
    private static List<Mineral> list;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 곡괭이별 소요 피로도 배열, 다이아 - 철 - 돌
        score = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        // 전체 곡괭이의 수
        int total = Arrays.stream(picks).sum();
        // 리스트 초기화
        list = new ArrayList<>();

        // 광물 5개를 순서대로 캐야 하므로 5개씩 그룹핑
        for(int i = 0; i < minerals.length; i += 5) {

            if(total == 0) break;

            int dia = 0;
            int iron = 0;
            int stone = 0;

            // 그룹핑된 광물들의 개별 광물
            for(int j = i; j < i + 5; j++) {

                // 광물이 5개로 끝나지 않을 경우를 위한 탈출문
                if(j == minerals.length) break;

                // 개별 광물
                String mineral = minerals[j];

                // 돌 철 다이아 순
                int value = mineral.equals("stone") ? 2 : mineral.equals("iron") ? 1 : 0;

                dia += score[0][value];
                iron += score[1][value];
                stone += score[2][value];

            }

            // 각 광물들 별 소요 피로도가 포함된 리스트
            list.add(new Mineral(dia, iron, stone));
            total--;
        }

        // 돌 곡괭이를 사용했을 때를 기준으로 정렬한다.
        Collections.sort(list, ((o1, o2) -> (o2.stone - o1.stone)));

        // 정렬 이후에는 가장 많은 피로도가 필요한 광물 그룹별로 for문을 수행, 다이아 -> 철 -> 돌 순으로 곡괭이를 할당한다.
        for(Mineral m : list) {

            int dia = m.dia;
            int iron = m.iron;
            int stone = m.stone;


            if(picks[0] > 0) {
                answer += dia;
                picks[0]--;
            }

            else if(picks[1] > 0) {
                answer += iron;
                picks[1]--;
            }

            else if(picks[2] > 0) {
                answer += stone;
                picks[2]--;
            }
        }

        return answer;
    }
}