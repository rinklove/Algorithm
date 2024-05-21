
class Solution {
    public int solution(int n) {
        int answer = 0;
        double d = Math.sqrt(n);
        
        if(d % (int)d == 0) answer = 1;
        else answer=2;
        
        return answer;
    }
}