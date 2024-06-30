import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        return loadParcel(order);
    }
    
    private int loadParcel(int[] order) {
        int count = 0;
        int length = order.length;
        Stack<Integer> stack = new Stack<>();
        int next = 1;
        
        for(int s = 0; s < length; s++) {
            while(next <= order[s]) {
                stack.push(next++);
            }
            
            if(!stack.isEmpty() && stack.peek() == order[s]) {
                stack.pop();
                count++;
                continue;
            } else break;
        }
        return count;
    }
}