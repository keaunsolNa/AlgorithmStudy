function solution(citations) {
    var answer = 0;
    return citations.sort((a,b)=>b-a).filter((item,idx)=>item>idx).length 
}