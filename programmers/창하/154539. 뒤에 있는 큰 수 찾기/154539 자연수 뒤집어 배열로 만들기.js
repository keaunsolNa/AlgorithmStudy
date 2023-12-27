function solution(numbers) {
    //answer 배열을 numbers배열의 길이만큼 -1로 초기화
    var answer = Array.from({length : numbers.length}, () => -1 );

    //stack 배열 선언
    //index를 가지는 배열
    var stack = [];

    //numbers 배열 순회
    //numbers 배열이 끝나도록 값이 바뀌지 않은 항목은 최대값이므로 -1
    for(var i = 0; i < numbers.length; i++){

        //stack의 첫 값을 인덱스로 가지는 numbers의 값이 numbers[i] 보다 작으면
        //해당 인덱스에 number[i]를 입력
        while(stack && numbers[stack.at(-1)] < numbers[i])
            answer[stack.pop()] = numbers[i];

        //stack에 i값을 입력
        //아직 값이 할당 되지 않은 index 넣음
        stack.push(i);
    }

    //정답배열 반환
    return answer;
}