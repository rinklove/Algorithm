import java.util.*;

class Solution {
    private final Set<String> types = new HashSet<>();
    private final Map<String, Integer> cart = new HashMap<>();
    public int[] solution(String[] gems) {
        int[] answer = {-1, 100001};
        int start = 0, end = 0;
        init(gems);        
        
        while(true) {
            if(cart.size() == types.size()) {
                update(answer, start+1, end);
                
                if(cart.get(gems[start]) > 1) {
                    cart.put(gems[start], cart.get(gems[start]) - 1);
                } else {
                    cart.remove(gems[start]);
                }
                
                start++;
            } else if(end == gems.length) {
                update(answer, start, end);
                break; 
            } else {
                cart.put(gems[end], cart.getOrDefault(gems[end], 0) + 1);
                end++;
            } 
        }
        return answer;
    }
    
    private void update(int[] answer, int start, int end) {
        if(answer[1] - answer[0] > end - start) {
            answer[1] = end;
            answer[0] = start;
        }
    }
    
    private void init(String[] gems) {
        for(String gem : gems) {
            types.add(gem);
        }
    }
}