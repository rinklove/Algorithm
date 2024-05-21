import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i<numbers.length-1;i++) {
			for(int j = i+1; j<numbers.length;j++) {
				if(result.indexOf(numbers[i]+numbers[j]) == -1)
					result.add(numbers[i]+numbers[j]);
			}
		}
		result.sort(null);
		answer = new int[result.size()];
		for(int i = 0; i<answer.length; i++) {
			answer[i] = result.get(i);
		}
		
        return answer;
    }
}