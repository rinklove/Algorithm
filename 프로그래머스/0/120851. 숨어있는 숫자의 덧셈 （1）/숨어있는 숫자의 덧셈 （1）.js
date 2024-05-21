function solution(my_string) {
    let answer = '';
    let start = 0;
    
    answer = [...my_string].filter(el => el == Number(el))
                        .reduce((acc, cur) => Number(acc)+Number(cur), start);
    return answer;
}