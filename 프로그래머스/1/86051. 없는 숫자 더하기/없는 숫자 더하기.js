function solution(numbers) {

    let b =0;

    for (let i=0;i <= 9 ; i++) {
        if(!(numbers.includes(i)))
            b += i;
    }
    return b ;
        
}