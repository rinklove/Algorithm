/*
    1 2 3 4
    2 2 3 4
    3 3 3 4
    4 4 4 4
    ----
    1. 값을 채워 넣나? 
    arr[0] = 1
    arr[4] = 2
    arr[8] = 3
    arr[15] = 4
*/
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        
        for(int i = 0; i < answer.length; i++) {
            long num = left + i;
            answer[i] = (int) Math.max(num / n, num % n) + 1;
        }
        
        return answer;
    }
}