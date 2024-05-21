import java.util.Arrays;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        int[] row = {dots[0][0], dots[1][0], dots[2][0], dots[3][0]};
		int[] col = {dots[0][1], dots[1][1], dots[2][1], dots[3][1]};
		
		row =Arrays.stream(row).distinct().sorted().toArray();
		col = Arrays.stream(col).distinct().sorted().toArray();
		
		answer = (row[1] - row[0]) * (col[1] - col[0]);
        return answer;
    }
}