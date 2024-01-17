function solution(bridge_length, weight, truck_weights) {
    let endT = []; //다리를 건넌 트럭 배열
    let bridgeT = []; //다리에 있는 트럭 배열
    let timeT = []; //트럭이 다리에 있는 시간
    let time = 1; //경과한 시간 모든 작업은 1초부터 시작한다.
    let truck_index = 0; //현재 나가야할 트럭

    //만약 다리를 건넌 트럭 배열 개수와 다리를 건널 트럭의 배열 개수가 같을경우 종료
    //다넘어 온것임으로
    while (endT.length !== truck_weights.length) {
        //다리에 있는 트럭의 시간을 1 증가
        timeT = timeT.map((item) => item + 1);

        //다리위의 무게가 weight 이하이면서 다리에 있는 트럭의 개수가 bridge_length 이하일때만 트럭이 다리를 올라갈 수 있음.
        if ( truck_weights[truck_index] + bridgeT.reduce((acc, cur) => acc + cur, 0) <= weight
             && bridgeT.length <= bridge_length ) {

                //트럭을 다리에 올리고 다음 올라갈 트럭을 가리킨다.
                bridgeT.push(truck_weights[truck_index++]);
                //다리에 있는 트럭의 시간을 1로 설정하여 push
                timeT.push(1);
        }

        //다리에 있는 트럭의 시간이 bridge_length와 같다면 큐에서 제거하여 다리를 건넌 트럭 배열에 push
        //다리에 있는 트럭의 시간큐에서 제거
        if (timeT[0] === bridge_length) {
            endT.push(bridgeT.shift());
            timeT.shift();
        }

        //위의 상황이 다지나가면 1초가 증가함.
        time++;
    }
    return time;
}