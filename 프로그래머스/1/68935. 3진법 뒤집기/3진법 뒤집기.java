import java.util.ArrayList;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
		while(n >= 3) {
			System.out.println(n);
			list.add(n % 3);
			n /= 3;
		}
		list.add(n);
		for(int i =0; i<list.size(); i++) {
			answer += (list.get(list.size()-1-i) * Math.pow(3, i));
		}
        
        return answer;
    }
}