import java.util.*;

class Solution {

    public int solution(String[] friends, String[] gifts) {

        // 선물 주고 받은 내역을 기록하기 위한 Map 변수
        Map<String, Integer> friendsMap = new HashMap<>();
        // 자료 활용을 편리하게 하기 위해 Integer 변수로 Map 생성
        for(int i = 0; i < friends.length; i++) friendsMap.put(friends[i], i);
        // 친구 목록 길이
        int fl = friends.length;
        // 선물 주고 받은 내역을 기록하기 위한 2차원 배열
        int[][] giveMap = new int[fl][fl];
        // 선물 지수를 담은 배열
        int[] indices = new int[fl];

        // 선물 주고 받은 내역 만큼
        for(int i = 0; i < gifts.length; i++) {

            // 선물을 준 사람
            int give = friendsMap.get(gifts[i].split(" ")[0]);
            // 선물을 받은 사람
            int receive = friendsMap.get(gifts[i].split(" ")[1]);

            // 2차원 배열 상에서, [준 사람][받은 사람] 형태의 2차원 배열을 생성한다.
            giveMap[give][receive]++;
            // 선물을 줬다면 선물 지수를 + 1
            indices[give]++;
            // 선물을 받았다면 선물 지수를 - 1 한다.
            indices[receive]--;

        }

        // 다음 선물을 주고 받을 내역을 기록하기 위한 1차원 배열
        int[] nextGiveMap = new int[fl];

        // 선물 내역 리스트의 길이 만큼
        for(int i = 0; i < giveMap.length; i++) {

            // 해당 사람이 선물을 준 사람 내역을 탐색한다.
            for(int j = 0; j < giveMap[i].length; j++) {

                // i == j는 같은 사람 간의 주고 받은 내역이므로 continue
                if(i == j) continue;

                // X가 Y에게 선물을 준 횟수 == Y가 X에게 선물을 준 횟수 라면
                if(giveMap[i][j] == giveMap[j][i]) {

                    // 선물 지수로 판별한다. 2중 for문이므로 i와 j 중 한 번만 탐색
                    if(indices[j] > indices[i])
                        // j가 선물 지수가 더 높다면 j가 선물을 받는다.
                        nextGiveMap[j]++;
                }

                // 서로 선물을 주고 받은 횟수가 다르다면 i가 선물을 받는다.
                // 2중 for문이므로 j는 제외
                else if(giveMap[i][j] > giveMap[j][i]) nextGiveMap[i]++;
            }

        }

        // 가장 선물을 많이 받은 사람을 기록하기 위한 변수
        int answer = 0;

        // for문을 수행하며 가장 많은 횟수를 탐색한 뒤
        for(int i = 0; i < nextGiveMap.length; i++)
            answer = Math.max(answer, nextGiveMap[i]);

        // 반환한다.
        return answer;
    }
}