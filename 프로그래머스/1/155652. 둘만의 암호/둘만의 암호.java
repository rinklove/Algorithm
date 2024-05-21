import java.util.Arrays;

class Solution {
    public String solution(String s, String skip, int index) {
       String words = "";
		String answer = "";
		
		for(char ch = 'a'; ch <= 'z'; ch++) {
			if(skip.contains(String.valueOf(ch))) continue;
			words += ch;
		}
		
		String[] wordArray = words.split("");
		String[] tmp = s.split("");
		for(String t : tmp) {
			answer += 	wordArray[(words.indexOf(t)+index)%words.length()];	
		}
        return answer;
    }
}