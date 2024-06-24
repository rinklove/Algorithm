import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville) {
            pq.offer(s);
        }
        
        while(!pq.isEmpty()) {
            int min1 = pq.poll();
            if(min1 >= K) return answer;
            if(pq.isEmpty()) break;
            
            int min2 = pq.poll();
            
            pq.offer(createNewScoville(min1, min2));
            answer++;
        }
        return -1;
    }
    
    
    
    private int createNewScoville(int num1, int num2) {
        return num1 + num2*2;
    }
}