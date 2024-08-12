import java.util.PriorityQueue;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for(int e : enemy) {
            pq.offer(-1*e);
            if(k == 0 && n < e) break;
            
            if(n >= e) {
                n -= e;
                answer++;
            } else if(k > 0) {
                n -= pq.poll() + e; 
                k--;
                answer++;
            }
            
        }
        return answer;
    }
}