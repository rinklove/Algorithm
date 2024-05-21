class Solution {
    /**
        n = 1(1) -> 1
        n = 2(2) -> 11, 2
        n = 3(3) -> 111, 12, 21
        n = 4(5) -> 1111, 112, 121, 211, 22
        n = 5(8) -> 11111, 1112, 1121, 1211, 2111, 221, 212, 122
        n = 6(13) -> 111111, 11112, 11121, 11211, 12111, 21111, 2211, 2121, 1221, 
                    2112, 1212, 1122, 222
        => 수열 A에 대해서 식이 다음과 같을 때, A(n) = A(n-1) + A(n-2) (단, n > 2)
    */
    public long solution(int n) {
        long answer = 0;
        
        if(n < 3) return n;
        
        long a = 1;
        long b = 2;
        for(int i = 3; i <= n; i++) {
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }
        return answer;
    }
}