import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
		Arrays.sort(completion);
		int mismatch = Arrays.mismatch(participant, completion);
		System.out.println(mismatch);
		
		answer = participant[mismatch];
        return answer;
    }
}