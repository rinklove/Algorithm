import java.util.Map;
import java.util.HashMap;

class Solution {
    private final Map<Integer, Integer> count1 = new HashMap<>();
    private final Map<Integer, Integer> count2 = new HashMap<>();
    public int solution(int[] topping) {
        int answer = -1;
        init(topping);
        
        answer = compare(topping);
        return answer;
    }
    
    private int compare(int[] topping) {
        int count = 0;
        for(int i = 1; i < topping.length-1; i++) {
            if(count1.size() == count2.size()) 
                count++;
            
            int prev = count2.get(topping[i]);
            if(prev == 1) {
                count2.remove(topping[i]);
            } else {
                count2.put(topping[i], prev - 1);
            }
            
            count1.put(topping[i], count1.getOrDefault(topping[i], 0) + 1);
        }
        return count;
    }
    
    private void init(int[] topping) {
        count1.put(topping[0], 1);
        
        for(int i = 1; i < topping.length; i++) {
            count2.put(topping[i], count2.getOrDefault(topping[i], 0)+1);
        }
    }
}