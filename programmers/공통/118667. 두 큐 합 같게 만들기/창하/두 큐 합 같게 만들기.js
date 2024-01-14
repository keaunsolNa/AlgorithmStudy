function solution(queue1, queue2) {
  //투포인터 사용을위해 하나의 큐로 생성
  let q = [...queue1, ...queue2];
  //queue1의 합
  let q1sum = queue1.reduce((prev, acc) => prev + acc, 0)
  //queue2의 합
  let q2sum = queue2.reduce((prev, acc) => prev + acc, 0)
  //두 큐의 합의 절반 == 목표값
  const tv = (q1sum + q2sum) / 2;
  //두 큐를 합친 q에서 queue1의 시작값
  let pointer1 = 0;
  //두 큐를 합친 q에서 queue2의 시작값
  let pointer2 = queue1.length;

  //q에서 이동횟수
  /**queue1.length * 3인 이유
   * queue1에서 모든값을 pop()하는데 queue1.length 만큼 소요
   * queue1의 값을 모두 push()받은 queue2에서 모든 값을 pop()하는데 queue1.length * 2 만큼 소요
   * 즉 도합 queue1.length * 3만큼 소요
  */
  for(let cnt = 0; cnt < queue1.length * 3; cnt++){

    //queue1의 합이 목표값과 같으면 cnt 반환
    if(q1sum === tv){
      return cnt;
    }

    //queue1의 합이 목표값보다 큰 경우
    //queue1의 첫번째 요소를 제거후 pointer이동
    if(q1sum > tv){
      q1sum -= q[pointer1++ % q.length];
    }
        //queue1의 합이 목표값보다 크지 않은경우
    //queue2의 첫번째 요소를 더한후 pointer2이동
    else{
      q1sum += q[pointer2++ % q.length];
    }
  }

  //queue1.length * 3만큼 반복하고도 같은값이 나오지 않았다면
  //같은값이 나오는것이 불가능 -1 반환
  return -1;
}