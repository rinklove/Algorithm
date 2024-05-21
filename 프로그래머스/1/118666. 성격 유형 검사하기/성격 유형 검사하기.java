import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
		Map<String, Integer> result = new HashMap();
		
		result.put("AN", 0);
		result.put("CF", 0);
		result.put("JM", 0);
		result.put("RT", 0);
		
		//음수면 2번째 양수면 첫번째
		for(int i = 0; i < survey.length; i++) {
			String tmp = Arrays.stream(survey[i].split("")).sorted().collect(Collectors.joining());
			if(survey[i].equals(tmp)) {
				 result.put(survey[i], result.getOrDefault(survey[i], 0)+(4-choices[i]));
			} else {
				result.put(tmp, result.getOrDefault(tmp, 0)+(choices[i]-4));
			}
		}
		for(Entry<String, Integer> s: result.entrySet()) {
			if(s.getValue() >=0) answer += s.getKey().charAt(0);
			else answer += s.getKey().charAt(1);
		}
        return answer;
    }
}