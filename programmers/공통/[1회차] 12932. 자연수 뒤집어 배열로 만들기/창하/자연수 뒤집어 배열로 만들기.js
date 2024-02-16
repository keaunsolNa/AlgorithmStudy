function solution(n) {
    var answer = [];

    //n이 0이하일때까지 반복
    while(n > 0){
        //자연수 n을 10으로 나눈 나머지를 answer 배열에 삽입
        answer.push(Math.floor(n%10));
        //n을 10으로 나눈 자연수로 재할당
        n = Math.floor(n/10);
        //계속 반복하다보면 n은 0이되게됨.
    }
    //정답배열 반환.
    return answer;
}