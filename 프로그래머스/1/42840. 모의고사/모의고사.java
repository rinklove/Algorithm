import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
		int[] person1 = {1,2,3,4,5};
		int[] person2 = {2,1,2,3,2,4,2,5};
		int[] person3 = {3,3,1,1,2,2,4,4,5,5};
		int[] correct = {0,0,0};
		
		
		for(int i = 0; i < answers.length;i++) {
			if(answers[i] == person1[i % person1.length]) {
				correct[0]++;
			}
			if(answers[i] == person2[i % person2.length]) {
				correct[1]++;
			}
			if(answers[i] == person3[i % person3.length]) {
				correct[2]++;
			}
		}
		
		int max = Math.max(correct[0] ,Math.max(correct[1], correct[2]));
		List<Integer> person = new ArrayList<Integer>();
		
		for(int i = 0; i < correct.length; i++) {
			if(correct[i] == max) {
				person.add(i+1);
			}
		}
		
		answer = person.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}