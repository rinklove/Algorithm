class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        if (dot[0] * dot[1] < 0) {
            answer = dot[0]>0? 4:2;
        } else{
            answer = dot[0]>0? 1:3;
        }
        return answer;
    }
}