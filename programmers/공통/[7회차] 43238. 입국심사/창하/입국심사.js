function solution(n, times) {
    //오름차순으로 정렬
    times.sort((a,b) =>  a-b);
    
    //입국심사가 걸리는 최소시간
    //오름차순된 times의 첫번째 배열로 할당
    let min = times[0];
    //입국심사가 걸리는 최악의시간
    //모든인원이 최악의 시간으로 입국심사를 받은것으로 할당
    let max = n * times[times.length - 1]
    
    //이분탐색을 사용하기 위해 min이 max보다 같거나 작을때만 수행
    while(min <= max){
        //입국 심사를 받은 사람의 수
        let people = 0;
        //걸리는 시간중 중간값
        let mid = Math.floor((min + max) / 2);
        
        for(let time of times){
            //각 심사관이 주어진 mid 시간동안 처리할 수 있는 사람의 수
            people += Math.floor(mid / time);
        }
        
        //처리한 사람이 심사를 받는 사람들보다 같거나 많으면 max값을 mid - 1로 조정
        //반대의 경우 min값을 mid + 1로 조정
        people >= n ? max = mid - 1 : min = mid + 1;
    }
    return min;
}