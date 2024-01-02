function solution(my_string, queries) {
    //정답 변수
    var answer = '';

    //반전될 문자열 앞의 문자 변수
    var front_string = '';
    //반전될 문자열 앞의 문자 변수
    var reverse_string = '';
    //반전될 문자열 뒤의 문자 변수
    var end_string = '';
    //전달받은 문자열의 길이
    var len = my_string.length;
    //이차원 정수 배열 queries 순회
    queries.map((e) => {
        //반전될 문자열 앞 문자열 할당
        front_string = my_string.slice(0,e[0]);
        //반전될 문자열 뒤 문자열 할당
        end_string = my_string.slice(e[1] + 1,len);
        //문자열 반전 my_string을 배열로 변환후 queries값만큼 잘라서 뒤집은뒤 문자열로 변환
        reverse_string = my_string.split('').slice(e[0],e[1] + 1).reverse().join('');
        //문자열 앞 + 반전된 문자열 + 문자열 뒤
        my_string = front_string + reverse_string + end_string;
    })

    // 정답변수에 정답 할당
    answer = my_string;

    return answer;
}