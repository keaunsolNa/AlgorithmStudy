function solution(numbers) {

    var result = numbers
        .sort(function(a,b) {
            return `${b}${a}` - `${a}${b}`;
        })
        .join('');

    return result[0] === '0' ? '0' : result;
} 