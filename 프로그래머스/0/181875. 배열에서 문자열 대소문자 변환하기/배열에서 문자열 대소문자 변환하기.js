function solution(strArr) {
    var answer = [];
    answer = strArr.map(el => {
        console.log(el);
        if(strArr.indexOf(el) % 2 === 0) {
           return el.toLowerCase();
        } else {
            return el.toUpperCase();
        }
    });
    return answer;
}