class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        	answer = (Math.abs((double)(dots[1][1] - dots[0][1]) / (double)(dots[1][0] - dots[0][0])) == Math.abs((double)(dots[3][1] - dots[2][1]) / (double)(dots[3][0] - dots[2][0]))) ||
					(Math.abs((double)(dots[2][1] - dots[0][1]) /(double) (dots[2][0] - dots[0][0])) == Math.abs((double)(dots[3][1] - dots[1][1]) /(double) (dots[3][0] - dots[1][0]))) ||
						(Math.abs((double)(dots[2][1] - dots[1][1]) / (double)(dots[2][0] - dots[1][0])) == Math.abs((double)(dots[3][1] - dots[0][1]) / (double)(dots[3][0] - dots[0][0]))) ? 1 : 0;
		
        return answer;
    }
}