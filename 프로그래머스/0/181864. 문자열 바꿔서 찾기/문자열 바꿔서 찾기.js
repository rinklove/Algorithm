function solution(myString, pat) {
    return [...myString].map(el => {return el === "A"? "B":"A";}).join("").includes(pat) ? 1 : 0;
}