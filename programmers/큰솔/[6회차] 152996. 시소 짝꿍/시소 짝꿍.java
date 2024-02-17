import java.util.*;

class Solution {
    
    public long solution(int[] weights) {

        long answer = 0;
        Map<Long, Long> map = new HashMap<>();
        Map<Long, Long> map2 = new HashMap<>();

        for (long weight : weights) {

            map2.put(weight, map2.getOrDefault(weight, 0L) + 1);
            Long[] temp = { weight * 2, weight * 3, weight * 4 };

            for(Long tem : temp) map.put(tem, map.getOrDefault(tem, 0L) + 1);
        }

        for (Long cnt : map.values()) if(cnt > 1) answer += (Long) cnt * (cnt - 1) / 2;

        Long minus = 0L;

        for (Long cnt : map2.values()) if(cnt > 1) minus += (cnt * (cnt - 1) / 2) * 2;

        return answer - minus;
    }
}