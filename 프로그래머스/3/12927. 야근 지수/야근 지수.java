import java.util.*;
/*
    야근 지수가 언제 최소가 되는가? 
    -> 남아 있는 일의 양이 균등할 때
*/
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((w1, w2) -> w2 - w1);
        setWorks(pq, works);
        work(pq, n);
        return getFatigue(pq);
    }
    
    private long getFatigue(PriorityQueue<Integer> pq) {
        long sum = 0;
         for(int w : pq) {
            sum += (long) Math.pow(w, 2);
        }
        return sum;
    } 
    
    private void work(PriorityQueue<Integer> pq, int n) {
        while(!pq.isEmpty() && n != 0) {
            int poll = pq.poll();
            poll--;
            if(poll != 0) {
                pq.offer(poll);            
            }
            n--;
        }
    }
    
    private void setWorks(PriorityQueue<Integer> pq, int[] works) {
        for(int w : works) {
            pq.offer(w);
        }
    }
}