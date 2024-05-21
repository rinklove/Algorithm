function solution(numbers, n) {
    var answer = 0;
    let start = n;
    for (const key in numbers) {
        if (Object.hasOwnProperty.call(numbers, key)) {
            const element = numbers[key];
            start -= element;

            if(start < 0) {
                return n-start;
                break;
            }
        };
    };
}