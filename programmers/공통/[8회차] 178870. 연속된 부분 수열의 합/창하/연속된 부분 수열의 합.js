function solution(sequence, k) {
   
    //two-point 사이의 합
    let sum = sequence[0];
    //two-pointer
    let [l, r] = [0,0];
    //결과 배열
    let result = [0,sequence.length];

    while(l < sequence.length){
        
        // 합이 목표값보다 작다면 r증가후 해당 배열의 값 증가
        if (sum < k){
            sum += sequence[++r];
        } 
        // 목표값과 같을때 더 적은 값을 result 배열에 할당후 배열의 값 증가
        else if (sum === k && r - l  < result[1] - result[0]){
            result = [l,r];
            sum += sequence[++r];
        // 목표값보다 작을때 합에서 인덱스l값을 뺀 후 l 증가
        } else { 
            sum -= sequence[l++];
        }
    }
    
    //결과 배열 반환
    return result;
 
}