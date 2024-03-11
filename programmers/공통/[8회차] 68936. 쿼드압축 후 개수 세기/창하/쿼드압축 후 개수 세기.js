function solution(arr) {
    let answer = [0,0];
    
    //배열 사이즈 , 정답, 시작위치
    function quad(size, start){
        const first = arr[start[0]][start[1]]
        if(size === 1) {
            first === 0 ? answer[0]++ : answer[1]++;
            return;
        }
        
        //압축이 가능한가.
        let flag = true;
        
        for(let i = start[0]; i < start[0] + size; i++){
            for(let j = start[1]; j < start[1] + size; j++){
                if(first !== arr[i][j]){
                    //첫값과 다른값이 나올경우 ( 압축 불가 )
                    flag = false;
                    break;;
                }
            }
            if( !flag ) break;;
        }
        
        //압축 가능
        if ( flag ) {
            first === 0 ? answer[0]++ : answer[1]++;
            return;
        }
        
        //압축 불가능
        const half = size / 2;
        //사분면으로 다시 나누기
        quad(half, start)
        quad(half, [start[0] + half,start[1]])
        quad(half, [start[0],start[1] + half])
        quad(half, [start[0] + half,start[1] + half])
        return;
    }
    
    
    
    quad(arr.length, [0,0]);
    return answer;
}