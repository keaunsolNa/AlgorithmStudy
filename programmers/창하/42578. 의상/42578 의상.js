function solution(clothes) {
    //1종류일 때 a개 ( a + 1 ) - 1
    //2종류일 때 a + b + ab 개 (a + 1)(b + 1) - 1
    //3종류일때 a + b + c + ab + bc + ac + abc (a+1)(b+1)(c+1)-1
    //일반화 공식 (a + 1)(b + 1)... -1

    let clothesMap = {};
    clothes.forEach(item=>{
        clothesMap[item[1]] = clothesMap[item[1]] === undefined ? 1 : clothesMap[item[1]] + 1
    });

    let answer = Object.values(clothesMap).reduce((acc,cur)=>{
        return acc * (cur + 1);
    },1)

    return answer - 1;
}