class Solution {
    public int solution(int n) {
        int answer = 1;
		int round = (int) Math.round((double) n / 2);
		
		if(n != 1) {
			for(int i = 1; i <= round; i++) {
				int tmp = (int) Math.floor(Math.sqrt(2*n+(Math.pow(i, 2)-i)));
				
				if(tmp * (tmp + 1) == 2 * n + Math.pow(i, 2)-i) answer++;
			}			
		}
        return answer;
    }
}