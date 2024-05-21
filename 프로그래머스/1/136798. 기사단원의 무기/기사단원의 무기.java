import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int number, int limit, int power) {
		Set<Integer> set = new HashSet();
		int answer =0;
		
		for(int n = 1; n <=number; n++) {
			for(int divide =1; divide <=  Math.sqrt(n); divide++) {
				if(n % divide == 0) {
					set.add(divide);
					set.add(n/divide);
				}
			}
			answer += set.size() > limit ? power : set.size();
			set.clear();
		}
        return answer;
    }
}