function solution(num_list) {
    const first = num_list.at(-1);
    const second = num_list.at(-2);
    first > second ? num_list.push(first - second) : num_list.push(first*2);
    return num_list;
}