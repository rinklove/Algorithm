/*
*/
import java.util.Set;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1, 1000001};
        search(sequence, k, answer);
        return answer;
    }
    
    
    private void search(int[] sequence, int sum, int[] answer) {
        int start = 0, end = 0, tmp = 0;
        
        while(end < sequence.length) {
            tmp += sequence[end];
            
            while(tmp > sum && start <= end) {
                tmp -= sequence[start++];
            }
            
            if(tmp == sum && answer[1] - answer[0] > end - start) {
                answer[0] = start;
                answer[1] = end;
            } 
            
            end++;
        }
    }
}