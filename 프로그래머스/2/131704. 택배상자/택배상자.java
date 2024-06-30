import java.util.Stack;
/*
    절차를 잘 생각해보자
    1.
*/
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        answer = loadParcel(order);
        return answer;
    }
    
    private int loadParcel(int[] order) {
        int count = 0;
        int length = order.length;
        Stack<Integer> stack = new Stack<>();
        int next = fill(1, order[0], stack);
        
        for(int s = 0; s < length; s++) {
            if(!stack.isEmpty() && stack.peek() == order[s]) {
                stack.pop();
                count++;
                continue;
            } else {
                if(next == order[s]) {
                    count++;
                    next++;
                } else if(next < order[s]) {
                    for(int i = next; i < order[s]; i++) {
                        stack.push(i);
                    }
                    next = order[s]+1;
                    count++;
                } else return count;
            }
        }
        return count;
    }
    
    private int fill(int start, int order, Stack<Integer> stack) {
        for(int i = start; i <= order; i++) {
            stack.push(i);
        }
        return order+1;
    }
}