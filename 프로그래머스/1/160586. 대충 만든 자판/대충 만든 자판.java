import java.util.Map;
import java.util.HashMap;

class Solution {
    private final Map<Character, Integer> count = new HashMap<>();
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        setKeymap(keymap);
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = completeTarget(targets[i]);
        }
        
        return answer;
    }
    
    private int completeTarget(String target) {
        int sum = 0;
        for(char t : target.toCharArray()) {
            if(!count.containsKey(t)) {
                return -1;
            }
            sum += count.get(t);
        }
        return sum;
    }
    
    private void setKeymap(String[] keymap) {
        for(String key : keymap) {
            setCount(key);
        }
    }
    
    private void setCount(String key) {
        int index = 1;
        for(char a : key.toCharArray()) {
            int c = count.getOrDefault(a, Integer.MAX_VALUE);
            if(c > index) {
                count.put(a, index);
            }
            index++;
        }
    }
}