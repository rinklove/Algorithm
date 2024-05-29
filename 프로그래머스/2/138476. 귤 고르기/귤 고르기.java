import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;  
        Map<Integer, Integer> map = new HashMap<>(); //<종류 수량>
        classify(map, tangerine); 
        
        int[] arr = getValues(map);
        int index = 0;
        
        while(k > 0) {
            k -= arr[index++];
            answer++;
        }
        
        return answer;
    }
    
    private void classify(Map<Integer, Integer> map, int[] tangerine) {
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t ,0)+1);
        }
    }
    
    private int[] getValues(Map<Integer, Integer> map) {
        return map.entrySet().stream()
            .map(Map.Entry::getValue)
            .sorted(Comparator.reverseOrder())
            .mapToInt(i -> i)
            .toArray();
    }
}