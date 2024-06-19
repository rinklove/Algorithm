import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
            answer += check(s);
            s = s.substring(1) + s.substring(0, 1);
        }
        
        return answer;
    }
    
    private int check(String str) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        try {
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                switch(c) {
                    case ']':
                        if(stack.peek() != '[') return 0;
                        stack.pop(); break;
                    case '}':
                        if(stack.peek() != '{') return 0;
                        stack.pop(); break;
                    case ')': 
                        if(stack.peek() != '(') return 0;
                        stack.pop(); break;
                    default: stack.push(c); break;
                }
            }
        } catch(EmptyStackException e) {
            return 0;
        }
        
        return stack.isEmpty() ? 1: 0;
    }
}