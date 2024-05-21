function solution(start, end_num) {
    var answer = [];
    for (let index = start; index >= end_num; index--) {
        answer.push(index);
    }
    return answer;
}