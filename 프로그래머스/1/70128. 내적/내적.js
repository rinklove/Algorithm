function solution(a, b) {
    
    var c=[];
    
    for(let i=0;i<a.length;i++){
        c[i]=a[i]*b[i];
    }
    return c.reduce( (prev, curr) => prev+curr);
}