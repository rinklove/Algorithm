import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        String answer = "";
		String[] split = s.toLowerCase().split(" ", -1);
		for(int i = 0; i < split.length; i++) {
			if(!split[i].isBlank()) {
				split[i] = split[i].replaceFirst(split[i].substring(0,1), split[i].substring(0,1).toUpperCase());
			} 
		}
		answer = Arrays.stream(split).collect(Collectors.joining(" "));
        return answer;
    }
}