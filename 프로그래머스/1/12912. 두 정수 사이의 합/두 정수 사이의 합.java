class Solution {
    public long solution(int a, int b) {
        
        //int의 범위를 넘어서서 오버플로우 발생. --> long으로 바꾸니 해결.
        long answer = 0;
        long big = 0;
        long small = 0;
        if (a > b) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }
        if((big-small+1) % 2 == 0) { //짝수개일 경우, ex) 4~7
            answer = (big+small) * ((big-small+1) / 2);
        } else { //ex) 4~8, 10 ~ 14
            answer = (small+big) * ((big-small+1) / 2) + ((small+big) / 2);
        }
        
        
    
        return a == b? a : answer;
    }
}