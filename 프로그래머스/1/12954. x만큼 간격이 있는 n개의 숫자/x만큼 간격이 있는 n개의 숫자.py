def solution(x, n):
    
    a = x
    answer = []
    
    for i in range(1,n,1):
        answer.append(x*i)
    
    answer.append(x*n)

    return answer