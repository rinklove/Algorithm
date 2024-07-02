import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int cycle = 4*queue1.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2  = new LinkedList<>();
        long sum1 = getSum(queue1, q1);
        long sum2 = getSum(queue2, q2);
        if((sum1+sum2) % 2 == 1) return answer;
        
        for(int count = 0; count < cycle; count++) {
            if(!(sum1 != 0 && sum2 != 0)) return -1;
            
            if(sum1 == sum2) return count;
            else if(sum1 > sum2) {
                int element = q1.poll();
                q2.offer(element);
                sum1 -= element;
                sum2 += element;
            } else {
                int element = q2.poll();
                q1.offer(element);
                sum1 += element;
                sum2 -= element;
            }
        }
        return answer;
    }
    
    private long getSum(int[] queue, Queue<Integer> q) {
        long sum = 0;
        for(int i = 0; i < queue.length; i++) {
            q.offer(queue[i]);
            sum += queue[i];
        }
        return sum;
    }
}