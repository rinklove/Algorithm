import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        String str = Arrays.stream(ingredient).mapToObj(String::valueOf).collect(Collectors.joining(""));

		answer = makeBurger(str);
		return answer;
    }
    
    private int makeBurger(String str) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
        sb.append(str);
		int index = sb.indexOf("1231", -1);
		while(index > -1) {
			sb.delete(index, index+4);
			count++;
			index -= 4;
			index = sb.indexOf("1231", index);
		}
		return count;
	}
}