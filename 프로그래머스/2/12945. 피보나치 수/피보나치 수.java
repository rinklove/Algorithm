import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
		
		list.add(0);
		list.add(1);
		
		for(int number = 2; number <= n; number++) {
			list.add((list.get(number-2) +list.get(number-1)) %1234567);
		}
        return list.get(n);
    }
}