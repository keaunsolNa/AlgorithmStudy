function solution(a) {
    /*
    * 스타 수열의 조건
    * 1. x의 길이가 짝수입니다. => 부분 수열의 최소 개수는 2
    * 2. 교집합의 원소의 개수가 1이상입니다. => 부분 수열에서 공통된 집합이 1개 이상 존재해야함
    * 3. x[0] != x[1] => 같은 집합안에 동일한 수 불가
    */
    // ex) a = [0,3,3,0,7,2,0,2,2,0]    
    // 공통된 교집합 list = [0,2,3,7]
    var list = Array.from(new Set(a)); 
    // 공통된 교집합의 개수 배열 초기화 cnt = [0,0,0,0,0,0,0,0,0,0]
    var cnt = new Array(a.length).fill(0); //공통된 교집합의 개수 
    
    // cnt에 값 할당
    // cnt = [4,0,3,2,0,0,0,1]
    for ( var item of a ){
        cnt[item]++;
    }
    
    // 현재 가장 많은 횟수의 스타 수열 교집합
    // ex) {0,3},{0,7},{0,2},{2,0} 일경의 0이 4개
    let maxCnt = -1;
    
    //각 교집합을 기준으로 for
    for(var i=0; i<cnt.length; i++){
        
        // 교집합의 개수가 0개라면 다음 교집합 진행
        if (cnt[i] == 0) continue;
        // 교집합의 개수가 이전의 스타 수열 교집합의 개수보다 적다면 다음 교집합 진행
        if (cnt[i] <= maxCnt) continue;
        
        // 현재 해당하는 수열에 대한 스타수열 교집합 개수
        let result = 0;
        
        // 주어진 수열을 순회
        for(var j=0; j<a.length - 1; j++){
            // 제 2규칙 현재 수 와 다음 수 중 교집합에 해당하지 않으면 다음수 탐색
            if (a[j] != i && a[j+1] != i) continue;
            // 제 3규칙 현재 수 와 다음 수가 같다면 다음수 탐색 (인접한 두 수가 같을 수 없음)
            if (a[j] == a[j+1]) continue;
            
            //위의 조건을 통과한 경우
            //스타수열 교집합 개수 + 1
            result++;
            //제 1조건에따라 조합은 최소 2 이상의 짝수이므로 탐색할 수를 하나 더 미룬다.
            j++;
        }
        //현재 수의 스타수열 교집합과 최대 스타수열 교집합중 더 큰수를 최대 스타수열 교집합으로 저장
        maxCnt = Math.max(maxCnt,result);
    }
    
    // 제 1조건에따라 최소 2 이상인 짝수이므로 스타수열 교집합 * 2
    return maxCnt * 2;
 
}