function solution(numbers) {

    var result = numbers
       .sort(function(a,b){
       if( ('' + b + b + b).substring(0,3) == ('' + a + a + a).substring(0,3)) return ('' + b + a) - ('' + a + b);
       return ('' + b + b + b).substring(0,3) - ('' + a + a + a).substring(0,3) })
       .join('');
    
    return Math.max(...numbers) == 0 ? '0' : result;
}



function solution(numbers) {

    var result = numbers
        .sort(function(a,b) {
            return `${b}${a}` - `${a}${b}`;
        })
        .join('');

    return result[0] === '0' ? '0' : result;
}