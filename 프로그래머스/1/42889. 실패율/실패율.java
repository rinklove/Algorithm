import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int count;
		int user = stages.length;
		Map<Integer, Double> failure = new HashMap<Integer, Double>();
		
		for(int i = 1;i<=N;i++) {
			count=0;
			for(int j =0; j<stages.length;j++) {
				if(i==stages[j]) {
					count++;
				}
			}
			System.out.println(count);
			if(user != 0) {
				failure.put(i, (double)count/user);
			}else {				
				failure.put(i, 0.0);
			}
				user -=count;
		}

		answer = failure.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
		.mapToInt(Map.Entry::getKey).toArray();
        return answer;
    }
}