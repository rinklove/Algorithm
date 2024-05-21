import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

		Map<String, Integer> scores = new HashMap<>();

		for (int i = 0; i < name.length; i++) {
			scores.put(name[i], yearning[i]);
		}

		for (int index = 0; index < photo.length; index++) {
			for (String p : photo[index]) {
				answer[index] += scores.getOrDefault(p, 0);
			}
		}
        
        return answer;
    }
}