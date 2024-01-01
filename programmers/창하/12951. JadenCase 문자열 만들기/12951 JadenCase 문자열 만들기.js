function solution(s) {
    var answer = '';

    //문자열 s를 소문자로 치환하여 배열로 저장
    var sa = s.toLowerCase().split(' ');

    //배열 sa 순회
    for(var i = 0; i < sa.length; i++ ){
        //각 배열의 인덱스 문자열중 첫글자를 대문자 나머지를 소문자로 치환
        sa[i] = sa[i].charAt(0).toUpperCase() + sa[i].slice(1).toLowerCase()
    }

    //join메소드를 통해 배열을 문자열로 변경
    answer = sa.join(' ');


    return answer;
}