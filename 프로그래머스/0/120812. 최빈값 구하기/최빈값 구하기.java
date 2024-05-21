import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] newArr = Arrays.stream(array).distinct().toArray();
		Map<Integer, Integer> frequency = new HashMap<>();
		
		for(int i =0; i < newArr.length; i++) {
			int current = newArr[i];
			int count = (int) Arrays.stream(array).filter(index -> index == current).count();
			frequency.put(current, count);
		}
		
		int max = frequency.entrySet().stream().mapToInt(i -> i.getValue()).max().getAsInt();
		answer = frequency.entrySet().stream().filter(i -> i.getValue().intValue() == max).count() > 1 ? -1  
				: frequency.entrySet().stream().filter(i -> i.getValue().intValue() == max).map(Map.Entry::getKey).mapToInt(i-> i).sum();
        return answer;
    }
}