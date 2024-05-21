import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 7};
        
		List<Integer> list = Arrays.stream(win_nums).mapToObj(i -> new Integer(i)).collect(Collectors.toList());
        
		for(int i : lottos) {
			if(list.contains(i)) {
				answer[0]--;
				answer[1]--;
			} 
			if(i == 0) {
				answer[0]--;
			}
		}
        
        answer[0] = answer[0] == 7 ? 6 : answer[0];
		answer[1] = answer[1] == 7 ? 6 : answer[1];
        return answer;
    }
}