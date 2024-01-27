function solution(phone_book) {
    phone_book.sort();

    for(let i = 0; i < phone_book.length -1; i++){
        if(phone_book[i + 1].indexOf(phone_book[i]) == 0){
            return false;
        }
    }
    return true;
}

function solution(phone_book) {
    let hashMap = new Map();

    phone_book.forEach((item,index)=>{
       hashMap.set(item,index);
    });

    for(let i = 0; i < phone_book.length; i++){
        for(let j = 0; j < phone_book[i].length; j++){
            if( hashMap.has(phone_book[i].substring(0,j)) ) return false;
        }
    }
    return true;
}