class Solution {

    public int solution(int[] bandage, int health, int[][] attacks) {

        // 현재 시간을 기록하기 위한 변수
        int time = 0;
        // attacks 배열을 순회하기 위한 변수
        int index = 0;
        // 붕대를 감기 시작한 뒤 지속시간
        int maintainSec = 0;
        // 현재 체력
        int currentHealth = health;

        // 우선 반복문 시작
        do {

            // time == 0 이기에 시간을 1초 늘린다.
            time++;

            // attacks 배열의 첫 번째 인덱스의 공격 시간과 현재 시간 비교. 일치한다면 공격 시간
            if (attacks[index][0] == time) {

                // 현재 체력은 현재 체력 - 현재 몬스터의 공격력이다.
                currentHealth = currentHealth - attacks[index][1];
                // 현재 체력이 0 미만이면 사망이므로 -1 반환
                if (currentHealth < 0) return -1;
                // 사망하지 않았다면 붕대 감기 유지시간을 0으로 초기화
                maintainSec = 0;

                // 다음 몬스터의 공격을 탐색하기 위해 index++
                index++;

                // 몬스터가 공격 중인게 아니라면
            } else {

                // 현재 체력은 현재 체력 + 초당 회복력과 최대 체력 중 작은 값으로 한다.
                currentHealth = Math.min(currentHealth + bandage[1], health);
                // 붕대 감기 유지시간++
                maintainSec++;

                // 붕대 감기 유지시간이 보너스 시간과 일치한다면
                if (maintainSec == bandage[0]) {

                    // 현재 체력은 현재 체력 + 보너스 회복력과 최대 체력 중 작은 값으로 한다.
                    currentHealth = Math.min(currentHealth + bandage[2], health);
                    // 붕대 감기 유지시간 초기화
                    maintainSec = 0;
                }
            }

            // 반복문 탈출 조건은 마지막 공격이 끝났을 때.
        } while (index != attacks.length);

        // 반복문이 종료됐다면 살아남았다는 것이므로, 현재 체력 반환
        return currentHealth;
    }
}