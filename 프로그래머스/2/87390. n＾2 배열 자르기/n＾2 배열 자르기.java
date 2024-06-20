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