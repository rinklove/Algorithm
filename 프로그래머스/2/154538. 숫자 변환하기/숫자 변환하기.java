import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        return search(x, y, n);
    }
    
    private int search(int start, int end, int plus) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> log = new HashSet<>();
        q.offer(start);
        log.add(start);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int s = 0; s < size; s++) {
                int poll = q.poll();
                
                if(poll == end) return count;
                else if(poll > end) continue;
                
                addNext(poll, plus, log, q);
            }
            count++;
        }
        return -1;
    }
        
    private void addNext(int number, int plus, Set<Integer> set, Queue<Integer> queue) {
        if(!isExist(set, number + plus)) {
            set.add(number+plus);
            queue.add(number+plus);
        }
        
        if(!isExist(set, number*2)) {
            set.add(number*2);
            queue.add(number*2);
        }
        
        if(!isExist(set, number*3)) {
            set.add(number*3);
            queue.add(number*3);
        }
    }
    
    private boolean isExist(Set<Integer> set, int number) {
        return set.contains(number);
    } 
    
}