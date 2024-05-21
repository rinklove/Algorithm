import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
		
		answer = Arrays.stream(arr).mapToInt(num -> Integer.parseInt(num)).min().getAsInt() + 
		" " + Arrays.stream(arr).mapToInt(num -> Integer.parseInt(num)).max().getAsInt();
        return answer;
    }
}