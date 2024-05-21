function solution(my_string, index_list) {
    var answer = '';
    return index_list.map(el => answer.concat(my_string[el])).join("");
}